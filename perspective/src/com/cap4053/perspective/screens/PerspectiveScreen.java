package com.cap4053.perspective.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cap4053.perspective.Perspective;

public abstract class PerspectiveScreen implements Screen {

	protected Stage stage;
	protected Perspective game;
	
	public PerspectiveScreen(Perspective game){
		
		this.game = game;
		
		stage = new Stage(480, 320, true);
	}
	
	public String getName(){
		
		return getClass().getSimpleName();
	}
	
	@Override
	public void render(float delta) {
		
		stage.act(delta);
		
		// clear the screen with the given RGB color (black)
		Gdx.gl.glClearColor( 1f, 1f, 1f, 1f );
			
		
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
	    
	    // draw the actors
	    stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		stage.setViewport(width, height, true);
		
//		DEBUG
		Gdx.app.log(Perspective.TAG, "Resizing screen: " + getName() + " to: " + width + " x " + height );
	}

	@Override
	public void show() {
		
//		DEBUG
		Gdx.app.log(Perspective.TAG, "Showing screen: " + getName());
		
		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchMenuKey(true);
	}

	@Override
	public void hide() {
		
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
		stage.dispose();
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		
		return stage;
	}
}
