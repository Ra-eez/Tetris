package com.Tetris.game;

//class that holds all the information and methods necessary per block
public class Block {

	int grid[][];
	int x, y;
	boolean bomb=false;
	
	Block(int[][] g, int xvar, int yvar){
		grid = g;
		x = xvar;
		y = yvar;
	}
	Block(int[][] g, int xvar, int yvar, boolean bombvar){
		grid = g;
		x = xvar;
		y = yvar;
		bomb = bombvar;
	}
	
	void Show(){
		grid[x][y]=2;
	}
	void ShowExplosion(){
		grid[x][y]=3;
	}
	void Delete(){
		grid[x][y]=0;
	}
	
	//Movements
	boolean isTouchingTop(){
		if (y==18){
			return true;
		}
		else
			return false;
	}
	boolean canMovedown(){
		if (grid[x][y-1]==0){
			return true;
		}
		
		else{
			return false;
	}
	}
	boolean canMoveright(){
		if(grid[x+1][y]==0)
			return true;
		else
			return false;
	}
	boolean canMoveleft(){
		if(grid[x-1][y]==0)
			return true;
		else
			return false;
	}
	void Movedown(){
		if(grid[x][y-1]==0){
			this.Delete();
			y--;
			if (bomb){
				this.ShowExplosion();
			}
			else
				this.Show();
		}
	}
	
	void Moveright(){
		if(grid[x+1][y-1]==0){
			this.Delete();
			x++;
			y--;
			if (bomb){
				this.ShowExplosion();
			}
			else
				this.Show();
		}
	}
	void Moveleft(){
		if(grid[x-1][y-1]==0){
			this.Delete();
			x--;
			y--;
			if (bomb){
				this.ShowExplosion();
			}
			else
				this.Show();
		}
	}

void adjust(int ax, int ay){
	if(grid[x+ax][y+(ay-1)]==0){
	this.Delete();
	x+=ax;
	y+=(ay-1);
	this.Show();}
}
}