package com.cap4053.perspective.models2D.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.cap4053.perspective.models2D.PerspectiveItem;
import com.cap4053.perspective.models2D.PerspectiveObject;

public class Heart extends PerspectiveItem {

	private Heart(Texture texture, int row, int column) {
		
		super(texture, row, column);
	}
	
	public static Heart create(int row, int column){
		
		Texture texture = new Texture(Gdx.files.internal("data/items/item_heart.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		return new Heart(texture, row, column);
	}

	@Override
	public void onMoveOver(PerspectiveObject collidedObject) {
		
		
	}
}
