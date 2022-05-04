package com.slyvronline.engine.common;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class FileLibrary {

	Map<String, Texture> textures;
	
	public void loadTextures() {
		textures = new HashMap<String, Texture>();
		for(FileHandle file : Gdx.files.internal("imgs").list()) {
			System.out.println(file.name());
			if (!file.isDirectory()) {
				if (file.extension().equals("jpg") | file.extension().equals("png")) {
					textures.put(file.nameWithoutExtension(), new Texture(file));
				}
			}
		}
	}
	
	public Texture getTex(String name) {
		return textures.get(name);
	}
}
