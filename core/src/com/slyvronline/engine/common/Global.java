package com.slyvronline.engine.common;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.slyvronline.engine.common.objects.Img;

public class Global {

	private ArrayList<Img> imgs;
	
	public Global() {
		imgs = new ArrayList<Img>();
		
		//This logic should normally go somewhere else like a LoadImagesSystem
		Img image = new Img();
		image.setName("badlogic");
		image.setTexture(new Texture(Gdx.files.internal("badlogic.jpg")));
		imgs.add(image);
	}
	
	public Img getImgByName(String name) {
		for(Img img : imgs)
			if (img.getName().equals(name)) return img;
		return null;
	}
	
	public ArrayList<Img> getImgs() {
		return imgs;
	}

	public void setImgs(ArrayList<Img> imgs) {
		this.imgs = imgs;
	}
	
	
}
