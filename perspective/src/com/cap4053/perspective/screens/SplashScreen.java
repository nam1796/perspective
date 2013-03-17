package com.cap4053.perspective.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.cap4053.perspective.Cube;
import com.cap4053.perspective.Perspective;

public class SplashScreen extends PerspectiveScreen{

	private Cube mCube;
	
	private boolean mTranslucentBackground;
    private float mAngle;
	
    public SplashScreen(Perspective game){
    	
    	super(game);
    }
    
	@Override
	public void render(float delta) {
		
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        //	We begin drawing the 3D objects here

		Gdx.gl10.glMatrixMode(GL10.GL_MODELVIEW);
		Gdx.gl10.glLoadIdentity();

		Gdx.gl10.glTranslatef(0, 0, -3.0f);
		
		//Controls horizontal rotation
		Gdx.gl10.glRotatef(mAngle, 0, 1, 0);
		
		//Controls vertical rotation
		Gdx.gl10.glRotatef(mAngle,  1, 0, 0);

		Gdx.gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		Gdx.gl10.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
        mCube.draw();

        Gdx.gl10.glRotatef(mAngle*2.0f, 0, 1, 1);
        Gdx.gl10.glTranslatef(0.5f, 0.5f, 0.5f);

//        mCube.draw();

        mAngle += 1.0f;
	}

	@Override
	public void resize(int width, int height) {
		
		float ratio = (float) width / height;
		 
        Gdx.gl10.glMatrixMode(GL10.GL_PROJECTION);
        Gdx.gl10.glLoadIdentity();
        Gdx.gl10.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
	}

	@Override
	public void show() {
		
		mCube = new Cube();
		
		Gdx.gl10.glDisable(GL10.GL_DITHER);

        /*
         * Some one-time OpenGL initialization can be made here
         * probably based on features of this particular context
         */
        Gdx.gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                 GL10.GL_FASTEST);

	    if (mTranslucentBackground) {
	    	
	    	Gdx.gl10.glClearColor(0, 0, 0, 0);
	    } 
	    else {
	    	
	    	Gdx.gl10.glClearColor(1, 1, 1, 1);
	    }
	    
	    Gdx.gl10.glEnable(GL10.GL_CULL_FACE);
	    Gdx.gl10.glShadeModel(GL10.GL_SMOOTH);
	    Gdx.gl10.glEnable(GL10.GL_DEPTH_TEST);
	}
}
