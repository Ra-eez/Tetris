package com.Tetris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen implements Screen{
	
	SpriteBatch batch;
	Texture img, border, block, up, down, left, right, bomb;
	int[][] grid = new int[12][22];
	Block myblock;
	float time = System.nanoTime();
	boolean pressed = false;
	BitmapFont font = new BitmapFont();
	Shape currentShape;
	int counter = 0;
	int score = 0;
	
	public GameScreen(Game g){
		
		batch = new SpriteBatch();
		img = new Texture("Blocks_01_64x64_Alt_04_002.png");
		border = new Texture("Blocks_01_64x64_Alt_04_006.png");
		block = new Texture("Blocks_01_64x64_Alt_04_005.png");
		up = new Texture("uparrow.png");
		down = new Texture("downarrow.png");
		left = new Texture("leftarrow.png");
		right = new Texture("if_arrow-right-outline_216091.png");
		bomb = new Texture("Blocks_01_64x64_Alt_02_004.png");
		SoundManager.create();
		SoundManager.background.setLooping(true);
		SoundManager.background.setVolume(0.5f);
		SoundManager.background.play();
		
		reset();
	}
	public void reset(){
		//set up grid
		for (int y = 0; y < 22; y++){
			for (int x = 0; x < 12; x++){
				if(x==0||x==11||y==0||y==21){
					grid[x][y] = 1;
				}
				else 
					grid[x][y]=0;
			}
		}
		score =0;
		
		//make initial block
		makeNewShape();
		currentShape.shapeShow();
	}
	@Override
	public void render(float delta) {
		
		// movements
		
		// move right
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			if (currentShape.canMoveShapeRight()==true)
				currentShape.MoveShapeRight();		
			}
		
		// move left
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			if (currentShape.canMoveShapeLeft())
				currentShape.MoveShapeLeft();
			}
		
		//rotate block
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			if (currentShape.canRotate()){
				currentShape.Rotate();
			}
		}
		
		//move down
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			if (currentShape.canMoveShapeDown()==true){
				currentShape.MoveShapeDown();}
			else{
				if(currentShape.shapeType==8){

					int column = currentShape.coreBlock.x;
					for (int i =0; i<21;i++){
						if (grid[column][i]!=1)
							grid[column][i]=0;
					}
				}
				makeNewShape();
				currentShape.shapeShow();
				score += 5;
			}
		}
			
		//move down over time
		if ((System.nanoTime()-time)/(1000)>500000){// maybe change (1000) to a variable like x and then speed up as time goes on
			time = System.nanoTime();
			if (currentShape.canMoveShapeDown()==true){
				currentShape.MoveShapeDown();
				}
			else{
				if(currentShape.shapeType==8){

					int column = currentShape.coreBlock.x;
					for (int i =0; i<21;i++){
						if (grid[column][i]!=1)
							grid[column][i]=0;
					}
				}
				makeNewShape();
				currentShape.shapeShow();
				score += 5;
				}
		}
		
		//reset game once the blocks reach the top
		if (currentShape.TouchingTop()==true){
			this.reset();
		}
		
		//destroy a row
		for (int y = 0; y< 22;y++){
			for (int x = 0; x < 12; x++){
				if (grid[x][y]==2||grid[x][y]==3){
					counter++;}
			}
			if (counter >= 10){
				score += 100;
				for (int i = 1; i<11;i++){
					if (grid[i][y]==3){
						for (int l = 0; l<22;l++){
								grid[i][l]=0;
						}
					}
					grid[i][y] = 0;}
				for (int j = y;j<22-y;j++){
					for (int k = 0; k<12;k++){
						if (grid[k][j]==2||grid[k][j]==3){
							grid[k][j]=0;
							grid[k][j-1]=2;}
					}
				}
			}
			counter = 0;
		}

		
		//draw/update screen
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		for (int y = 0; y < 22; y++){
			for (int x = 0; x < 12; x++){
				if (grid[x][y]==1)
					batch.draw(border, x * 20 + 100, y * 20);
				
				else if (grid[x][y]==0)
					batch.draw(img, x * 20 + 100, y * 20);
				else if (grid[x][y]==3)
					batch.draw(bomb, x*20+100, y*20);
				
				else{
					batch.draw(block, x * 20 + 100, y * 20);
					
					font.draw(batch, "Score:", 450,300);
					font.draw(batch, Integer.toString(score), 450,275);
					batch.draw(down, 375, 75);
					font.draw(batch, "-   speed up", 420,100);
					batch.draw(left, 375, 50);
					font.draw(batch, "-   move left", 420,75);
					batch.draw(right, 375, 25);
					font.draw(batch, "-   move right", 420,50);
					batch.draw(up, 374, 100);
					font.draw(batch, "-   rotate", 420,125);
					
					font.draw(batch, "Song: Wolf artist: Jeremy L", 400,25);
				}
			}
		}
		batch.end();
		
	}
	  
	public void makeNewBlock(){
		 myblock = new Block(grid, 6, 20);
	}
	public void makeNewShape(){
		currentShape = new Shape(grid, 6, 19);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
