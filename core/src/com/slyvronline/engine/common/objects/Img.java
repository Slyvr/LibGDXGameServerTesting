package com.slyvronline.engine.common.objects;

import com.badlogic.gdx.graphics.Texture;

public class Img {

	private String name;
	private String fullpath;
	private Texture texture;
	
	public Img() {
		
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

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	
}
