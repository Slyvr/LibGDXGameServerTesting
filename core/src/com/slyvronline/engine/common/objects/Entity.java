package com.slyvronline.engine.common.objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Entity implements Serializable{
	
	private String name;
	private Img img;
	private ArrayList<Property> properties;
	
	public Entity() {
		properties = new ArrayList<Property>();
	}
	
	@Override
	public void write(Json json) {
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		
	}
	
	public void render(SpriteBatch batch) {
		for(Property property : properties) {
			property.render(batch);
		}
		img.render(batch);
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	
	public Float getX() {
		return img.getX();
	}
	
	public Float getY() {
		return img.getY();
	}

	public Float getWidth() {
		return img.getWidth();
	}
	
	public Float getHeight() {
		return img.getHeight();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Img getImg() {
		return img;
	}

	public void setImg(Img img) {
		this.img = img;
	}
	
	
}
