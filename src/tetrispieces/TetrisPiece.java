/*
*This package have all the types of pieces and all the methods needed for move 
*the pieces in the gameBoard.
*/

package tetrispieces;

public abstract class TetrisPiece {
//Variables for managing the functions of the pieces only 
    protected int type;
    protected int positionx;
    protected int positiony;
    protected int dimensionx;
    protected int dimensiony;
    protected int currentSkin;
    protected int maxSkin;
    protected boolean [][] skin0;
    protected int skin0DimX;
    protected int skin0DimY;
    protected boolean [][] skin1;
    protected int skin1DimX;
    protected int skin1DimY;
    protected boolean [][] skin2;
    protected int skin2DimX;
    protected int skin2DimY;
    protected boolean [][] skin3;
    protected int skin3DimX;
    protected int skin3DimY;
 //Variables that can we used by the program    
    public boolean cantMoveMore;
    public boolean [][] pieceGraph = new boolean[3][3];

// Methods for getting and modifying the position of the piece, the reference is the left-lowercorner
	public int getPositionX(){return  this.positionx;}
	public int getPositionY(){return  this.positiony;}
        public int getType(){return  this.type;}
	public void setPositionX(int x){this.positionx = x;}
	public void setPositionY(int y){this.positiony = y;}
// End for getting and modifying the position of the piece, the reference is the left-lowercorner
//For rotating
    protected void updateDimension(int x ,int y){
	this.dimensionx = x;
	this.dimensiony = y;
    }
    public  void rotate(boolean[][] board){
    	int number;
    	//Select the skin that you have to put in the piece
    	if(this.currentSkin == 0){
    		number = this.maxSkin;
    	}else{
    	number = this.currentSkin -1;
    	}
    	//Update the skin and the variables of the piece
          switch(number){
          case 0:
              if(this.canRotate(board,skin0DimX,skin0DimY)){
        	   this.pieceGraph = this.skin0;
   		   updateDimension(skin0DimX,skin0DimY);
   		   this.currentSkin = 0;
              }
        	  break;
              
          case 1:
              if(this.canRotate(board,skin1DimX,skin1DimY)){
        	  this.pieceGraph = skin1;
   		   updateDimension(skin1DimX,skin1DimY);
   		   this.currentSkin = 1;
                    }
        	  break; 
                   
          case 2:
               if(this.canRotate(board,skin2DimX,skin2DimY)){
        	  this.pieceGraph = this.skin2;
   		   updateDimension(skin2DimX,skin2DimY);
   		   this.currentSkin = 2;
                }
        	  break;
                   
          case 3:
               if(this.canRotate(board,skin3DimX,skin3DimY)){
        	  this.pieceGraph = skin3;
   		   updateDimension(skin3DimX,skin3DimY);
   		   this.currentSkin = 3;
                }
        	  break; 
                   
        		  
          }
    	
    }
   protected boolean canRotate(boolean [][] board,int skinx,int skiny){
       for(int row = this.getPositionY(); row<this.getPositionY()+skiny;row++){
	    for(int col=this.getPositionX(); col<this.getPositionX()+skinx;col++){
		if(row>=board.length||col>=board[0].length||board[row][col]){
                      return false;          
		}
	    }
       }
       return true;
   }
 //End of functions for rotating
 //Method for moving
   public boolean goDown(boolean[][]board){

	   if(!isTouchingLastLine(board)&&!isTouchingOtherPieceDown(board)){
		   this.positiony += 1;
		   return false;
	   }
	   return true;
   }
   public void goLeft(boolean [][]board){
	   if(!isTouchingLeftLine()&& !isTouchingOtherPieceLeft(board))this.positionx -= 1;
   }
   public void goRight(boolean[][]board){
	   if(!isTouchingRightLine(board)&&!isTouchingOtherPieceRight(board))this.positionx+= 1;
   }
//Loop for cheek conditions
   protected boolean isTouchingLastLine(boolean[][]board){
	   if(this.positiony+this.dimensiony==board.length)return true;
	return false;
	   
   }
   protected boolean isTouchingLeftLine(){
	   if(this.positionx==0)return true;
	return false;
  }
   protected boolean isTouchingRightLine(boolean[][]board){
	   if(this.positionx+this.dimensionx==board[0].length)return true;
	return false;
  }
   protected boolean isTouchingOtherPieceDown(boolean[][]board){
	   for(int x = 0; x<this.dimensionx; x++){
		   if(this.pieceGraph[this.dimensiony-1][x]){
			   if(board[this.positiony+this.dimensiony][this.positionx+x])return true;
		   }else if(this.pieceGraph[this.dimensiony-2][x]){
			   if(board[this.positiony+this.dimensiony-1][this.positionx+x])return true;
		   }else if(this.pieceGraph[this.dimensiony-3][x]){
			   if(board[this.positiony+this.dimensiony-2][this.positionx+x])return true;
		   }
	   } 
	  return false;
   }
   protected boolean isTouchingOtherPieceLeft(boolean[][]board){
	   for(int y = 0;y<this.dimensiony; y++){
		   if(this.pieceGraph[y][0]){
			   if(board[this.positiony+y][this.positionx-1])return true;
		   }else if(this.pieceGraph[y][1]){
			   if(board[this.positiony+y][this.positionx])return true;
		   }else if(this.pieceGraph[y][2]){
			   if(board[this.positiony+y][this.positionx+1])return true;
		   }
	   } 
	  return false;
   }
   protected boolean isTouchingOtherPieceRight(boolean[][]board){
	   for(int y = 0;y<this.dimensiony; y++){
		   if(this.pieceGraph[y][dimensionx-1]){
			   if(board[this.positiony+y][this.positionx+this.dimensionx])return true;
		   }else if(this.pieceGraph[y][dimensionx-2]){
			   if(board[this.positiony+y][this.positionx+this.dimensionx-1])return true;
		   }else if(this.pieceGraph[y][dimensionx-3]){
			   if(board[this.positiony+y][this.positionx+this.dimensionx-2])return true;
		   }
	   } 
	  return false;
   }
//End of loops for check conditions
}

  

