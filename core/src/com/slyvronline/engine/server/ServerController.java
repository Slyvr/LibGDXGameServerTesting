package com.slyvronline.engine.server;

import java.io.IOException;

import com.slyvronline.engine.Game;
import com.slyvronline.engine.common.objects.GameSession;

public class ServerController {

	private GameSession game;
	private String name;
	
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
		Game.getKryoserver().sendToAllTCP(this);
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
