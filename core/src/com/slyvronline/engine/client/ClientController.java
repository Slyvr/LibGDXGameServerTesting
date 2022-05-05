package com.slyvronline.engine.client;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.engine.Game;
import com.slyvronline.engine.common.objects.ClientGameSession;
import com.slyvronline.engine.common.objects.GameSession;

public class ClientController {

	private GameSession game;
	private ClientGameSession clientGame;
	private String name;
	
	public ClientController() {
		name = "ID"+System.currentTimeMillis();
		Game.getKryoclient().setName(name);
		clientGame = new ClientGameSession();
	}
	
	public void connect(){
		Game.getKryoclient().start();
		try {
			Game.getKryoclient().connect(5000, "localhost", 54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Game.getKryoclient().addListener(new ClientListener());
		Game.getKryoclient().sendTCP(this);
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Game.getGameBatch().begin();
		if (game != null) {
			game.render(Game.getGameBatch());
		}
		Game.getGameBatch().end();
	}
	
	public String message;
	
	public void update() {
		if (clientGame != null) {
			if(Gdx.input.justTouched()) {
				int mouseX = Gdx.input.getX();
				int mouseY = Gdx.graphics.getHeight()-Gdx.input.getY();
				clientGame.setMousePos(new Rectangle(mouseX,mouseY,1,1));
				clientGame.setUpdated(true);
			}
			
			if (clientGame.isUpdated()) {
				clientGame.setUpdated(false);
				Game.getKryoclient().sendTCP(clientGame);
			}
		}
	}
	
	public GameSession getGame() {
		return game;
	}

	public void setGame(GameSession game) {
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientGameSession getClientGame() {
		return clientGame;
	}

	public void setClientGame(ClientGameSession clientGame) {
		this.clientGame = clientGame;
	}
	
	
}
