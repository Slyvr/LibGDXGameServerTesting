package com.slyvronline.engine.common.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Json.Serializable;
import com.slyvronline.engine.Game;

public class Img implements Serializable {

	private String name;
	private String fullpath;
	private float x;
	private float y;
	private float originX;
	private float originY;
	private float width;
	private float height;
	private float scaleX;
	private float scaleY;
	private float rotation;
	private int srcX;
	private int srcY;
	private int srcWidth;
	private int srcHeight;
	private boolean flipX;
	private boolean flipY;
	
	public Img() {
		
	}
	
	public Img(Img img) {
		this.name = img.name;
		this.fullpath = img.fullpath;
		this.x = img.x;
		this.y = img.y;
		this.originX = img.originX;
		this.originY = img.originY;
		this.width = img.width;
		this.height = img.height;
		this.scaleX = img.scaleX;
		this.scaleY = img.scaleY;
		this.rotation = img.rotation;
		this.srcX = img.srcX;
		this.srcY = img.srcY;
		this.srcWidth = img.srcWidth;
		this.srcHeight = img.srcHeight;
		this.flipX = img.flipX;
		this.flipY = img.flipY;
	}
	
	public void render(SpriteBatch batch) {
		//batch.draw(Game.getGlobal().getImgByName(name).getTexture(), x, y, originX, originY, width, height, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY);
		batch.draw(Game.getGlobal().getTexByName(name), x, y);
	}
	
	@Override
	public void write(Json json) {
		/*
		json.writeValue(name);
		json.writeValue(x);
		json.writeValue(y);
		json.writeValue(originX);
		json.writeValue(originY);
		json.writeValue(width);
		json.writeValue(height);
		json.writeValue(scaleX);
		json.writeValue(scaleY);
		json.writeValue(rotation);
		json.writeValue(srcX);
		json.writeValue(srcY);
		json.writeValue(srcWidth);
		json.writeValue(srcHeight);
		json.writeValue(flipX);
		json.writeValue(flipY);
		*/
		json.writeObjectStart();
		json.writeField(name, "name");
		json.writeField(x, "x");
		json.writeField(y, "y");
		json.writeField(originX, "originX");
		json.writeField(originY, "originY");
		json.writeField(width, "width");
		json.writeField(height, "height");
		json.writeField(scaleX, "scaleX");
		json.writeField(scaleY, "scaleY");
		json.writeField(rotation, "rotation");
		json.writeField(srcX, "srcX");
		json.writeField(srcY, "srcY");
		json.writeField(srcWidth, "srcWidth");
		json.writeField(srcHeight, "srcHeight");
		json.writeField(flipX, "flipX");
		json.writeField(flipY, "flipY");
		json.writeObjectEnd();
	}
	
	@Override
	public void read(Json json, JsonValue jsonData) {
		String text = json.toJson(this, RenderableProperty.class);
		JsonValue root = new JsonReader().parse(text);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullpath() {
		return fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getOriginX() {
		return originX;
	}

	public void setOriginX(float originX) {
		this.originX = originX;
	}

	public float getOriginY() {
		return originY;
	}

	public void setOriginY(float originY) {
		this.originY = originY;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public int getSrcX() {
		return srcX;
	}

	public void setSrcX(int srcX) {
		this.srcX = srcX;
	}

	public int getSrcY() {
		return srcY;
	}

	public void setSrcY(int srcY) {
		this.srcY = srcY;
	}

	public int getSrcWidth() {
		return srcWidth;
	}

	public void setSrcWidth(int srcWidth) {
		this.srcWidth = srcWidth;
	}

	public int getSrcHeight() {
		return srcHeight;
	}

	public void setSrcHeight(int srcHeight) {
		this.srcHeight = srcHeight;
	}

	public boolean isFlipX() {
		return flipX;
	}

	public void setFlipX(boolean flipX) {
		this.flipX = flipX;
	}

	public boolean isFlipY() {
		return flipY;
	}

	public void setFlipY(boolean flipY) {
		this.flipY = flipY;
	}
	
}
