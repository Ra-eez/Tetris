package com.Tetris.game;

//class that holds all the shapes information and neccessary methods
public class Shape {

	Block coreBlock;
	Block block1;
	Block block2;
	Block block3;
	int shapeType;
	int rotationNo;
	int[][] graph;
	
	// type 1 - 7
	public Shape (int[][] g, int xvar, int yvar){
		
		graph = g;
		double type = Math.floor(Math.random()*8+1);
		//double type = 8.0;
		rotationNo=1;
		//12o3
		if (type == 1.0){
			block1 = new Block(g, xvar-2, yvar);
			block2 = new Block(g, xvar-1, yvar);
			block3 = new Block(g, xvar+1, yvar);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=1;
		}
		
		// 32
	    // 1o
		if (type == 2.0){
			block1 = new Block(g, xvar-1, yvar);
			block2 = new Block(g, xvar, yvar+1);
			block3 = new Block(g, xvar-1, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=2;
			}
		
		//  3
	    // 1o2
		if (type == 3.0){
			block1 = new Block(g, xvar-1, yvar);
			block2 = new Block(g, xvar+1, yvar);
			block3 = new Block(g, xvar, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=3;
			}
		
		// 3
	    // 1o2
		if (type == 4.0){
			block1 = new Block(g, xvar-1, yvar);
			block2 = new Block(g, xvar+1, yvar);
			block3 = new Block(g, xvar-1, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=4;
			}
		
		//   3
	    // 1o2
		if (type == 5.0){
			block1 = new Block(g, xvar-1, yvar);
			block2 = new Block(g, xvar+1, yvar);
			block3 = new Block(g, xvar+1, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=5;
			}
		
		// 32
	    //  o1
		if (type == 6.0){
			block1 = new Block(g, xvar+1, yvar);
			block2 = new Block(g, xvar, yvar+1);
			block3 = new Block(g, xvar-1, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=6;
			}
		
		//  23
	    // 1o
		if (type == 7.0){
			block1 = new Block(g, xvar-1, yvar);
			block2 = new Block(g, xvar, yvar+1);
			block3 = new Block(g, xvar+1, yvar+1);

			coreBlock = new Block(g, xvar, yvar);
			shapeType=7;
			}
		if (type == 8.0){

			coreBlock = new Block(g, xvar, yvar,true);
			shapeType = 8;
			
		}
	}
	
		void shapeShow(){
		if (shapeType!=8){
		coreBlock.Show();
		block1.Show();
		block2.Show();
		block3.Show();}
		else
			coreBlock.ShowExplosion();
	}
	boolean TouchingTop(){
		if (coreBlock.isTouchingTop()){
			if (this.canMoveShapeDown())
				return false;
			return true;
		}
		if ((shapeType!=8)&&block1.isTouchingTop()){
			if (this.canMoveShapeDown())
				return false;
			return true;
		}
		if ((shapeType!=8)&&block2.isTouchingTop()){
			if (this.canMoveShapeDown())
				return false;
			return true;
		}
		if ((shapeType!=8)&&block3.isTouchingTop()){
			if (this.canMoveShapeDown())
				return false;
			return true;
		}
		else
			return false;
	}
	
	
		// moving methods
		void MoveShapeDown(){
		if (shapeType == 1){
			if (rotationNo == 1){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				block3.Movedown();coreBlock.Movedown();block2.Movedown();block1.Movedown();
			}
			if (rotationNo == 3){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 4){
				block1.Movedown();block2.Movedown();coreBlock.Movedown();block3.Movedown();
			}
		}
		if (shapeType == 2){
			coreBlock.Movedown();block1.Movedown();block2.Movedown();block3.Movedown();
		}
		if (shapeType == 3){
			if (rotationNo == 1){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				block2.Movedown();block3.Movedown();coreBlock.Movedown();block1.Movedown();
			}
			if (rotationNo == 3){
				block3.Movedown();coreBlock.Movedown();block2.Movedown();block1.Movedown();
			}
			if (rotationNo == 4){
				block1.Movedown();coreBlock.Movedown();block2.Movedown();block3.Movedown();
			}
		}
		if (shapeType == 4){
			if (rotationNo == 1){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				block2.Movedown();block3.Movedown();coreBlock.Movedown();block1.Movedown();
			}
			if (rotationNo == 3){
				block3.Movedown();coreBlock.Movedown();block2.Movedown();block1.Movedown();
			}
			if (rotationNo == 4){
				block1.Movedown();coreBlock.Movedown();block2.Movedown();block3.Movedown();
			}
		}
		if (shapeType == 5){
			if (rotationNo == 1){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				block2.Movedown();block3.Movedown();coreBlock.Movedown();block1.Movedown();
			}
			if (rotationNo == 3){
				block3.Movedown();coreBlock.Movedown();block2.Movedown();block1.Movedown();
			}
			if (rotationNo == 4){
				block1.Movedown();coreBlock.Movedown();block2.Movedown();block3.Movedown();
			}
		}	
		if(shapeType==6){
			if (rotationNo == 1){
				coreBlock.Movedown();block1.Movedown();block2.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				block1.Movedown();block2.Movedown();block3.Movedown();coreBlock.Movedown();
			}
			if (rotationNo == 3){
				block3.Movedown();block2.Movedown();coreBlock.Movedown();block1.Movedown();
			}
			if (rotationNo == 4){
				coreBlock.Movedown();block1.Movedown();block3.Movedown();block2.Movedown();
			}
		}
		if (shapeType == 7){
			if (rotationNo == 1){
				coreBlock.Movedown();block2.Movedown();block1.Movedown();block3.Movedown();
			}
			if (rotationNo == 2){
				coreBlock.Movedown();block1.Movedown();block3.Movedown();block2.Movedown();
			}
			if (rotationNo == 3){
				block3.Movedown();block2.Movedown();coreBlock.Movedown();block1.Movedown();
			}
			if (rotationNo == 4){
				block1.Movedown();coreBlock.Movedown();block2.Movedown();block3.Movedown();
			}
		}
		if(shapeType == 8){
			coreBlock.Movedown();
		}
	}
		void MoveShapeRight(){
			
			if (shapeType == 1){
				if (rotationNo == 1){
					coreBlock.Moveright();block2.Moveright();block1.Moveright();block3.Moveright();
				}
				if (rotationNo == 2){
					coreBlock.Moveright();block1.Moveright();block2.Moveright();block3.Moveright();
				}
				if (rotationNo == 3){
					block1.Moveright();block2.Moveright();coreBlock.Moveright();block3.Moveright();
				}
				if (rotationNo == 4){
					coreBlock.Moveright();block1.Moveright();block2.Moveright();block3.Moveright();
				}
			}
			if (shapeType == 2){
				block2.Moveright();coreBlock.Moveright();block3.Moveright();block1.Moveright();
			}
			if (shapeType == 3){
				if (rotationNo == 1){
					block2.Moveright();coreBlock.Moveright();block1.Moveright();block3.Moveright();
				}
				if (rotationNo == 2){
					block3.Moveright();block2.Moveright();coreBlock.Moveright();block1.Moveright();
				}
				if (rotationNo == 3){
					block1.Moveright();block3.Moveright();coreBlock.Moveright();block2.Moveright();
				}
				if (rotationNo == 4){
					block1.Moveright();coreBlock.Moveright();block2.Moveright();block3.Moveright();
				}
			}
			if (shapeType == 4){
				if (rotationNo == 1){
					block2.Moveright();coreBlock.Moveright();block1.Moveright();block3.Moveright();
				}
				if (rotationNo == 2){
					block2.Moveright();coreBlock.Moveright();block3.Moveright();block1.Moveright();
				}
				if (rotationNo == 3){
					block3.Moveright();block1.Moveright();coreBlock.Moveright();block2.Moveright();
				}
				if (rotationNo == 4){
					block1.Moveright();coreBlock.Moveright();block2.Moveright();block3.Moveright();
				}
			}
			if (shapeType == 5){
				if (rotationNo == 1){
					block2.Moveright();coreBlock.Moveright();block1.Moveright();block3.Moveright();
				}
				if (rotationNo == 2){
					block3.Moveright();block2.Moveright();coreBlock.Moveright();block1.Moveright();
				}
				if (rotationNo == 3){
					block3.Moveright();block2.Moveright();coreBlock.Moveright();block1.Moveright();
				}
				if (rotationNo == 4){
					block1.Moveright();coreBlock.Moveright();block2.Moveright();block3.Moveright();
				}
			}	
			if (shapeType == 6){
				if (rotationNo == 1){
					block1.Moveright();coreBlock.Moveright();block2.Moveright();block3.Moveright();
				}
				if (rotationNo == 2){
					block2.Moveright();block3.Moveright();block1.Moveright();coreBlock.Moveright();
				}
				if (rotationNo == 3){
					block3.Moveright();block2.Moveright();coreBlock.Moveright();block1.Moveright();
				}
				if (rotationNo == 4){
					coreBlock.Moveright();block1.Moveright();block3.Moveright();block2.Moveright();
				}
			}
			if (shapeType == 7){
				if (rotationNo == 1){
					coreBlock.Moveright();block1.Moveright();block3.Moveright();block2.Moveright();
				}
				if (rotationNo == 2){
					block3.Moveright();block2.Moveright();coreBlock.Moveright();block1.Moveright();
				}
				if (rotationNo == 3){
					block2.Moveright();block3.Moveright();block1.Moveright();coreBlock.Moveright();
				}
				if (rotationNo == 4){
					block1.Moveright();coreBlock.Moveright();block2.Moveright();block3.Moveright();
				}
			}
			if(shapeType == 8){
				coreBlock.Moveright();
			}
			}
		void MoveShapeLeft(){
			
			if (shapeType == 1){
				if (rotationNo == 1){
					block1.Moveleft();block2.Moveleft();coreBlock.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					coreBlock.Moveleft();block1.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 3){
					block3.Moveleft();coreBlock.Moveleft();block2.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 4){
					coreBlock.Moveleft();block1.Moveleft();block2.Moveleft();block3.Moveleft();
				}
			}
			if (shapeType == 2){
				block3.Moveleft();block1.Moveleft();block2.Moveleft();coreBlock.Moveleft();
			}
			if (shapeType == 3){
				if (rotationNo == 1){
					block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 3){
					block3.Moveleft();block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 4){
					block1.Moveleft();block3.Moveleft();coreBlock.Moveleft();block2.Moveleft();
				}
			}
			if (shapeType == 4){
				if (rotationNo == 1){
					block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 3){
					block3.Moveleft();block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 4){
					block3.Moveleft();block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();
				}
		}
			if (shapeType == 5){
				if (rotationNo == 1){
					block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					block2.Moveleft();block3.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 3){
					block3.Moveleft();block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 4){
					block1.Moveleft();coreBlock.Moveleft();block3.Moveleft();block2.Moveleft();
				}
			}	
			if (shapeType == 6){
				if (rotationNo == 1){
					coreBlock.Moveleft();block1.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 3){
					block2.Moveleft();block3.Moveleft();block1.Moveleft();coreBlock.Moveleft();
				}
				if (rotationNo == 4){
					block3.Moveleft();block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
			}
			if (shapeType == 7){
				if (rotationNo == 1){
					block1.Moveleft();coreBlock.Moveleft();block2.Moveleft();block3.Moveleft();
				}
				if (rotationNo == 2){
					coreBlock.Moveleft();block3.Moveleft();block2.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 3){
					block3.Moveleft();block2.Moveleft();coreBlock.Moveleft();block1.Moveleft();
				}
				if (rotationNo == 4){
					block2.Moveleft();block1.Moveleft();coreBlock.Moveleft();block3.Moveleft();
				}
			}
			if(shapeType == 8){
				coreBlock.Moveleft();
			}
			}
		
		boolean canMoveShapeDown(){
	
		if (shapeType == 1){
			if (rotationNo == 1){
				if (coreBlock.canMovedown() && block1.canMovedown() && block2.canMovedown() && block3.canMovedown())
					return true;
				else 
					return false;
			}
			if (rotationNo == 2){
				if (block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 3){
				if (coreBlock.canMovedown() && block1.canMovedown() && block2.canMovedown() && block3.canMovedown())
					return true;
				else 
					return false;
			}
			if (rotationNo == 4){
				if (block1.canMovedown())
					return true;
				else
					return false;
			}
		}
		else if (shapeType == 2){
			if (coreBlock.canMovedown() && block1.canMovedown())
				return true;
			else
				return false;
		}
		else if (shapeType == 3){
			if (rotationNo == 1){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block2.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 2){
				if (block2.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 3){
				if (block2.canMovedown()&&block3.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 4){
				if (block3.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
		}
		else if (shapeType == 4){
			if (rotationNo == 1){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block2.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 2){
				if (block2.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 3){
				if (block2.canMovedown()&&coreBlock.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 4){
				if (block3.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
		}
		else if (shapeType == 5){
			if (rotationNo == 1){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block2.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 2){
				if (block3.canMovedown()&&block2.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 3){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 4){
				if (block3.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
		}
		else if (shapeType == 6){
			if (rotationNo == 1){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block3.canMovedown()){
					return true;}
				else
					return false;
			}
			if (rotationNo == 2){
				if (block2.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 3){
				if (block1.canMovedown()&&block2.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 4){
				if (block3.canMovedown()&&coreBlock.canMovedown())
					return true;
				else
					return false;
			}
		}
		else if (shapeType == 7){
			if (rotationNo == 1){
				if (block1.canMovedown()&&coreBlock.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 2){
					if (block3.canMovedown()&&coreBlock.canMovedown())
						return true;
					else
						return false;
			}
			if (rotationNo == 3){
				if (block1.canMovedown()&&block2.canMovedown()&&block3.canMovedown())
					return true;
				else
					return false;
			}
			if (rotationNo == 4){
				if (block2.canMovedown()&&block1.canMovedown())
					return true;
				else
					return false;
			}
		}
		if (shapeType==8){
			if (coreBlock.canMovedown())
				return true;
				else
					return false;
		}
		return false;
}
		boolean canMoveShapeRight(){
			if (shapeType == 1){
				if (rotationNo==1){
					if (block3.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveright()&&coreBlock.canMoveright()&&block3.canMoveright()&&block2.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveright()&&coreBlock.canMoveright()&&block3.canMoveright()&&block2.canMoveright())
						return true;
					else
						return false;
			}
			}
			if (shapeType == 2){
				if(coreBlock.canMoveright()&&block2.canMoveright())
					return true;
				else
					return false;
			}
			if (shapeType == 3){
				if (rotationNo==1){
					if (block3.canMoveright()&&block2.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block3.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (coreBlock.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 4){
				if (rotationNo==1){
					if (block3.canMoveright()&&block2.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block3.canMoveright()&&block2.canMoveright()&&coreBlock.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (coreBlock.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 5){
				if (rotationNo==1){
					if (block3.canMoveright()&&block2.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block3.canMoveright()&&coreBlock.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (coreBlock.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 6){
				if (rotationNo==1){
					if (block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block3.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveright()&&coreBlock.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block3.canMoveright()&&coreBlock.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 7){
				if (rotationNo==1){
					if (block3.canMoveright()&&coreBlock.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block3.canMoveright()&&block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block2.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block3.canMoveright()&&coreBlock.canMoveright()&&block1.canMoveright())
						return true;
					else
						return false;
				}
			}
			if (shapeType==8){
				if (coreBlock.canMoveright())
					return true;
				else
					return false;
			}
			return false;
}
		boolean canMoveShapeLeft(){
			if (shapeType == 1){
				if (rotationNo==1){
					if (block1.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
			}
			}
			if (shapeType == 2){
				if(block1.canMoveleft()&&block3.canMoveleft())
					return true;
				else
					return false;
			}
			if (shapeType == 3){
				if (rotationNo==1){
					if (block1.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 4){
				if (rotationNo==1){
					if (block1.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (coreBlock.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 5){
				if (rotationNo==1){
					if (block1.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 6){
				if (rotationNo==1){
					if (coreBlock.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (block1.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
			}
			if (shapeType == 7){
				if (rotationNo==1){
					if (block1.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if (block1.canMoveleft()&&coreBlock.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if (coreBlock.canMoveleft()&&block3.canMoveleft())
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if (block1.canMoveleft()&&block3.canMoveleft()&&block2.canMoveleft())
						return true;
					else
						return false;
				}
			}
			if (shapeType==8){
				if (coreBlock.canMoveleft())
					return true;
				else
					return false;
			}
			return false;
}

		//rotation methods
		void Rotate(){
			if (shapeType == 1){
				if(rotationNo==1){
					block3.adjust(-1,-1);coreBlock.adjust(0,0);block2.adjust(1,1);block1.adjust(2,2);}
				if(rotationNo==2){
					block3.adjust(-1,1);coreBlock.adjust(0,0);block2.adjust(1,-1);block1.adjust(2,-2);}
				if(rotationNo==3){
					block1.adjust(-2,-2);block2.adjust(-1,-1);coreBlock.adjust(0,0);block3.adjust(1,1);}
				if(rotationNo==4){
					block1.adjust(-2,2);block2.adjust(-1,1);coreBlock.adjust(0,0);block3.adjust(1,-1);rotationNo=0;}
				rotationNo++;
			}
			if (shapeType == 2){
			}
			if (shapeType == 3){
				if(rotationNo==1){
					block2.adjust(-1,-1);coreBlock.adjust(0,0);block3.adjust(1,-1);block1.adjust(1,1);}
				if(rotationNo==2){
					block2.adjust(-1,1);block3.adjust(-1,-1);coreBlock.adjust(0,0);block1.adjust(1,-1);}
				if(rotationNo==3){
					block3.adjust(-1,0);coreBlock.adjust(0,0);block2.adjust(1,1);block3.adjust(0,2);block1.adjust(-1,-1);}
				if(rotationNo==4){
					block1.adjust(-1,0);coreBlock.adjust(0,0);block2.adjust(1,-1);block3.adjust(1,1);block1.adjust(0,2);rotationNo=0;}
				rotationNo++;
			}
			if (shapeType == 4){
				if(rotationNo==1){
					block2.adjust(-1,-1);coreBlock.adjust(0,0);block1.adjust(1,1);block3.adjust(2,0);}
				if(rotationNo==2){
					block2.adjust(-1,1);coreBlock.adjust(0,0);block3.adjust(0,-2);block1.adjust(1,-1);}
				if(rotationNo==3){
					coreBlock.adjust(0,0);block2.adjust(1,1);block3.adjust(-2,0);block1.adjust(-1,-1);}
				if(rotationNo==4){
					block2.adjust(1,-1);block3.adjust(0,2);block1.adjust(-1,1);coreBlock.adjust(0,0);rotationNo=0;}
				rotationNo++;
			}
			if (shapeType == 5){
				if(rotationNo==1){
					block2.adjust(-1,-1);coreBlock.adjust(0,0);block1.adjust(1,1);block3.adjust(0,-2);}
				if(rotationNo==2){
					block3.adjust(-2,0);block2.adjust(-1,1);coreBlock.adjust(0,0);block1.adjust(1,-1);}
				if(rotationNo==3){
					block1.adjust(-1,-1);coreBlock.adjust(0,0);block2.adjust(1,1);block3.adjust(0,2);}
				if(rotationNo==4){
					block1.adjust(-1,1);coreBlock.adjust(0,0);block2.adjust(1,-1);block3.adjust(2,0);rotationNo=0;}
				rotationNo++;
			}
			if (shapeType == 6){
				if(rotationNo==1){
					block1.adjust(-1,-1);coreBlock.adjust(0,0);block2.adjust(1,-1);block3.adjust(2,0);}
				if(rotationNo==2){
					block1.adjust(-1,1);block2.adjust(-1,-1);coreBlock.adjust(0,0);block3.adjust(0,-2);}
				if(rotationNo==3){
					block3.adjust(-2,0);block2.adjust(1,0);coreBlock.adjust(0,0);block1.adjust(1,1);block2.adjust(-2,2);}
				if(rotationNo==4){
					block1.adjust(1,-1);coreBlock.adjust(0,0);block2.adjust(1,1);block3.adjust(0,2);rotationNo=0;}
				rotationNo++;
			}
			if (shapeType == 7){
				if(rotationNo==1){
					block3.adjust(0,-2);block2.adjust(1,-1);coreBlock.adjust(0,0);block1.adjust(1,1);}
				if(rotationNo==2){
					block3.adjust(-2,0);block2.adjust(-1,-1);block1.adjust(1,-1);coreBlock.adjust(0,0);}
				if(rotationNo==3){
					block3.adjust(0,2);block2.adjust(-1,1);block1.adjust(-1,-1);coreBlock.adjust(0,0);}
				if(rotationNo==4){
					block3.adjust(2,0);block1.adjust(-1,0);coreBlock.adjust(0,0);block2.adjust(1,1);block1.adjust(0,2);rotationNo=0;}
				rotationNo++;
			}
		}
		boolean canRotate(){
			if (shapeType == 1){
				if (rotationNo==1){
					if ((graph[block1.x+2][block1.y+2]==0)&&(graph[block2.x+1][block2.y+1]==0)&&(graph[block3.x-1][block3.y-1]==0)){
						return true;}
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block1.x+2][block1.y-2]==0)&&(graph[block2.x+1][block2.y-1]==0)&&(graph[block3.x-1][block3.y+1]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if ((graph[block1.x-2][block1.y-2]==0)&&(graph[block2.x-1][block2.y-1]==0)&&(graph[block3.x+1][block3.y+1]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if ((graph[block1.x-2][block1.y+2]==0)&&(graph[block2.x-1][block2.y+1]==0)&&(graph[block3.x+1][block3.y-1]==0))
						return true;
					else
						return false;
			}
			}
			if (shapeType == 2){
				return true;
			}
			if (shapeType == 3){
				if (rotationNo==1){
					if ((graph[block2.x-1][block2.y-1]==0)){
						return true;}
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block2.x-1][block2.y+1]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
						return true;
				}
				if (rotationNo==4){
					if ((graph[block2.x+1][block2.y-1]==0))
						return true;
					else
						return false;
				}
			}
			if (shapeType == 4){
				if (rotationNo==1){
					if ((graph[block1.x+1][block1.y+1]==0)&&(graph[block2.x-1][block2.y-1]==0)&&(graph[block3.x+2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block1.x+1][block1.y-1]==0)&&(graph[block2.x-1][block2.y+1]==0)&&(graph[block3.x+0][block3.y-2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if ((graph[block1.x-1][block1.y-1]==0)&&(graph[block2.x+1][block2.y+1]==0)&&(graph[block3.x-2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if ((graph[block1.x-1][block1.y+1]==0)&&(graph[block2.x+1][block2.y-1]==0)&&(graph[block3.x+0][block3.y+2]==0))
						return true;
					else
						return false;
				}
			}
			if (shapeType == 5){
				if (rotationNo==1){
					if ((graph[block1.x+1][block1.y+1]==0)&&(graph[block2.x-1][block2.y-1]==0)&&(graph[block3.x+0][block3.y-2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block1.x+1][block1.y-1]==0)&&(graph[block2.x-1][block2.y+1]==0)&&(graph[block3.x-2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if ((graph[block1.x-1][block1.y-1]==0)&&(graph[block2.x+1][block2.y+1]==0)&&(graph[block3.x+0][block3.y+2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if ((graph[block1.x-1][block1.y+1]==0)&&(graph[block2.x+1][block2.y-1]==0)&&(graph[block3.x+2][block3.y+0]==0))
						return true;
					else
						return false;
				}
			}
			if (shapeType == 6){
				if (rotationNo==1){
					if ((graph[block1.x-1][block1.y-1]==0)&&(graph[block3.x+2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block1.x-1][block1.y+1]==0)&&(graph[block3.x+0][block3.y-2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if ((graph[block1.x+1][block1.y+1]==0)&&(graph[block3.x-2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if ((graph[block1.x+1][block1.y-1]==0)&&(graph[block3.x+0][block3.y+2]==0))
						return true;
					else
						return false;
				}
			}
			if (shapeType == 7){
				if (rotationNo==1){
					if ((graph[block2.x+1][block2.y-1]==0)&&(graph[block3.x+0][block3.y-2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==2){
					if ((graph[block2.x-1][block2.y-1]==0)&&(graph[block3.x-2][block3.y+0]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==3){
					if ((graph[block2.x-1][block2.y+1]==0)&&(graph[block3.x+0][block3.y+2]==0))
						return true;
					else
						return false;
				}
				if (rotationNo==4){
					if ((graph[block2.x+1][block2.y+1]==0)&&(graph[block3.x+2][block3.y+0]==0))
						return true;
					else
						return false;
				}
			}
			return false;
		}
}
