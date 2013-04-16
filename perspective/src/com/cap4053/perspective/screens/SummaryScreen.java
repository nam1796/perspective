package com.cap4053.perspective.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cap4053.perspective.backends.LevelManager;
import com.cap4053.perspective.backends.Plane;
import com.cap4053.perspective.models2D.PerspectiveCollection;

public class SummaryScreen extends Image {
	
	private Plane level2D;
	private int stars;
	private int hearts;
	
	private SummaryScreen(Texture texture, final Plane level2D, final int stars, final int hearts) {
		
		// Call the super constructor
		super(texture);	
		
		this.level2D = level2D;
		this.stars = stars;
		this.hearts = hearts;
		
		SequenceAction sequence = new SequenceAction();
		
		// Add stars to sequence
		//final PerspectiveCollection starCollection = PerspectiveCollection.create(level2D, "Summary-Stars", 0, 4, -60, 152, false, 256, -197);
		sequence = addItemsToSequence(sequence, level2D, "Summary-Stars", stars, 4, -60, 152, 256, -197);
		
		sequence = addItemsToSequence(sequence, level2D, "Summary-Hearts", hearts, 3, -27, 41, 256, -197);
		
		
		this.addAction(sequence);

	}
	
	public SequenceAction addItemsToSequence(final SequenceAction sequence, final Plane level2D, final String items, final int numItems, final int maxItems, final int startX, final int startY, final int objSize, final int objSpacing){
		//sequence.addAction(Actions.delay(0.7f));
		
		sequence.addAction(Actions.run(
				new Runnable(){ 
					public void run () {
						final PerspectiveCollection collection = PerspectiveCollection.create(level2D, items, 0, maxItems, startX, startY, false, objSize, objSpacing);
						
						final float duration = 0.35f;
						
						sequence.addAction(Actions.delay(0.7f));
						
						//SequenceAction sequence = new SequenceAction();
						if(numItems > 0){
							sequence.addAction(Actions.run(
									new Runnable(){ 
										public void run () {
											collection.update(1);
						            }}));
							sequence.addAction(Actions.delay(duration));
						}
						if(numItems > 1){
							sequence.addAction(Actions.run(
									new Runnable(){ 
										public void run () {
											collection.update(2);
						            }}));
							sequence.addAction(Actions.delay(duration));
						}
						if(numItems > 2){
							sequence.addAction(Actions.run(
									new Runnable(){ 
										public void run () {
											collection.update(3);
						            }}));
							sequence.addAction(Actions.delay(duration));
						}
						if(numItems > 3){
							sequence.addAction(Actions.run(
									new Runnable(){ 
										public void run () {
											collection.update(4);
						            }}));
							sequence.addAction(Actions.delay(duration));
						}
						
					
				}}));
		
		return sequence;
	}
	
	public static SummaryScreen create(Plane level2D, int stars, int hearts){
		
		// Create the new Texture 
		Texture texture = new Texture(Gdx.files.internal("data/Summary-BG.png"));
		
		// Set the Linear filter for proper interpolation
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		// Return the Texture
		return new SummaryScreen(texture, level2D, stars, hearts);
	}

}
