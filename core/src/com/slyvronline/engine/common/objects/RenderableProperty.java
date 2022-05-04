package com.slyvronline.engine.common.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class RenderableProperty extends Property {
	
	private Img img;
	
	public RenderableProperty() {
		
	}
	
	public RenderableProperty(RenderableProperty renderable) {
		
	}

	public void render(SpriteBatch batch) {
		img.render(batch);
	}
	
	public void update(float stateTime) {
		
	}
	
	@Override
	public void write(Json json) {
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		
	}
	
}
