package com.slyvronline.engine.common.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.slyvronline.engine.Game;
import com.badlogic.gdx.utils.JsonValue;

public class ClientGameSession implements Serializable {
	
	private Rectangle mousePos;
	private boolean updated;
	
	public ClientGameSession() {
		updated = false;
		mousePos = null;
	}
	
	public void update() {
		if (mousePos != null) {
			Img entImg = Game.getServer().getGame().getEntities().get(0).getImg();
			entImg.setX(mousePos.getX());
			entImg.setY(mousePos.getY());
			
			mousePos = null;
		}
	}
	
	public Rectangle getMousePos() {
		return mousePos;
	}
	public void setMousePos(Rectangle mousePos) {
		this.mousePos = mousePos;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		
	}
	
	
}
