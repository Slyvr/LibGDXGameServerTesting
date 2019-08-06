package com.slyvronline.engine;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;
import com.slyvronline.engine.client.ClientController;
import com.slyvronline.engine.common.Global;
import com.slyvronline.engine.common.objects.Entity;
import com.slyvronline.engine.common.objects.GameSession;
import com.slyvronline.engine.common.objects.RenderableProperty;
import com.slyvronline.engine.server.ServerController;

public class Game extends ApplicationAdapter {
	
	private String type;
	private static Global global;
	private static ClientController client;
	private static ServerController server;
	private static Server kryoserver;
	private static Client kryoclient;
	private static SpriteBatch gameBatch;
	private static SpriteBatch menuBatch;
	
	@Override
	public void create () {
		gameBatch = new SpriteBatch();
		menuBatch = new SpriteBatch();
		
		global = new Global();
		
		if (type.equals("client")) {
			kryoclient = new Client();
			client = new ClientController();
			registerKryoClasses(kryoclient.getKryo());
			client.connect();
		}
		else if (type.equals("server")) {
			kryoserver = new Server();
			server = new ServerController();
			registerKryoClasses(kryoserver.getKryo());
			server.start();
		}
		else if (type.equals("both")) {
			kryoserver = new Server();
			server = new ServerController();
			registerKryoClasses(kryoserver.getKryo());
			server.start();
			
			kryoclient = new Client();
			client = new ClientController();
			registerKryoClasses(kryoclient.getKryo());
			client.connect();
		}
	}

	@Override
	public void render () {
		
		if (client != null) {
			client.render();
			client.update();
		}
		
		if (server != null) {
			server.update();
		}
	}
	
	@Override
	public void dispose () {
		
	}
	
	public void registerKryoClasses(Kryo kryo) {
		kryo.register(ClientController.class);
		kryo.register(ServerController.class);
		kryo.register(GameSession.class);
		kryo.register(ArrayList.class);
		kryo.register(Entity.class);
		kryo.register(RenderableProperty.class);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static Global getGlobal() {
		return global;
	}

	public static void setGlobal(Global global) {
		Game.global = global;
	}

	public static ClientController getClient() {
		return client;
	}

	public static void setClient(ClientController client) {
		Game.client = client;
	}

	public static ServerController getServer() {
		return server;
	}

	public static void setServer(ServerController server) {
		Game.server = server;
	}

	public static Server getKryoserver() {
		return kryoserver;
	}

	public static void setKryoserver(Server kryoserver) {
		Game.kryoserver = kryoserver;
	}

	public static Client getKryoclient() {
		return kryoclient;
	}

	public static void setKryoclient(Client kryoclient) {
		Game.kryoclient = kryoclient;
	}

	public static SpriteBatch getGameBatch() {
		return gameBatch;
	}

	public static void setGameBatch(SpriteBatch gameBatch) {
		Game.gameBatch = gameBatch;
	}

	public static SpriteBatch getMenuBatch() {
		return menuBatch;
	}

	public static void setMenuBatch(SpriteBatch menuBatch) {
		Game.menuBatch = menuBatch;
	}
	
	
}
