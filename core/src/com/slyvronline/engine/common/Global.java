package com.slyvronline.engine.common;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.slyvronline.engine.common.objects.Img;

public class Global {

	FileLibrary lib;
	
	public Global() {
		lib = new FileLibrary();
		lib.loadTextures();
	}
	
	public Texture getTexByName(String name) {
		return lib.getTex(name);
	}
	
}
