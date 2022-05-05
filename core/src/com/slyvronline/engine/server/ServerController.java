package com.slyvronline.engine.server;

import java.io.IOException;

import com.slyvronline.engine.Game;
import com.slyvronline.engine.common.objects.Entity;
import com.slyvronline.engine.common.objects.GameSession;
import com.slyvronline.engine.common.objects.RenderableProperty;

public class ServerController {

	private GameSession game;
	private String name;
	
	private int counter;
	
	public ServerController() {
		name = "SERVER"+System.currentTimeMillis();
		game = new GameSession();
	}
	
	public void start() {
		Game.getKryoserver().start();
		try {
			Game.getKryoserver().bind(54555,54777);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Game.getKryoserver().addListener(new ServerListener());
	}

	public void update() {
		Game.getKryoserver().sendToAllTCP(this.game);
		
		if (counter > 5) {
			counter = 0;
			Entity ent = (Entity)game.getEntities().get(0);
			//ent.getImg().setX(ent.getX() + 1);
		}
		else {
			counter++;
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
	
	
}
