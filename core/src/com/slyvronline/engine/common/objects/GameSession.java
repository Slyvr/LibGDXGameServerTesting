package com.slyvronline.engine.common.objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.slyvronline.engine.Game;

public class GameSession implements Serializable {

	private ArrayList<Entity> entities;
	
	public GameSession() {
		entities = new ArrayList<Entity>();
		
		Entity entity = new Entity();
		RenderableProperty renderable = new RenderableProperty();
		renderable.setName("badlogic");
		renderable.setX(100);
		renderable.setY(100);
		entity.getProperties().add(renderable);
		entities.add(entity);
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart();
		json.writeValue("entities", entities, ArrayList.class, Entity.class);
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		
	}

	public void render(SpriteBatch batch) {
		for(Entity entity : entities) {
			entity.render(batch);
		}
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
}
