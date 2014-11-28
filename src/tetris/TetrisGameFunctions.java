package tetris;

import java.util.Scanner;
import tetrispieces.LeftPiece;
import tetrispieces.LeftSPiece;
import tetrispieces.LinePiece;
import tetrispieces.RightPiece;
import tetrispieces.RightSPiece;
import tetrispieces.SquarePiece;
import tetrispieces.TPiece;
import tetrispieces.TetrisPiece;

public class TetrisGameFunctions {
    //Variables for the game
    private boolean boardSpaceLeft = true;
    private TetrisPiece currentPiece;
    private String button;
    private boolean board [][] = new boolean  [8][8];
    private boolean auxboard [][] = new boolean  [8][8];
    public TetrisPrint tempBoard = new TetrisPrint(board);	//Check visibility
    private int rowcompletenumber = -1;
    private int numberPieces=0;
    private int score = 0;
   TetrisGameFunctions(){
        
        currentPiece = randomPiece();
        //FIXME: change for a graphical interface
        tempBoard.insertNewPiece(currentPiece);
        tempBoard.printBoard();
   } 
        public int getScore(){return score;}
        public int getSNumberPieces(){return numberPieces;}
        public void writeButton(String buttonin){
            this.button = buttonin;
        }
   	private boolean boardSpaceLeft(){
		for(int row = 0; row<3;row++){
			for(int col=0; col<3;col++){
				if(this.board[row][col]){
				return false;	
				}
			}
		} 
		return true;
	}
	private  void insertNewPieceBoard(TetrisPiece currentPiece, boolean[][] board ){
	    	int x = currentPiece.getPositionX();
	    	int y = currentPiece.getPositionY();
	    	
	    	for(int row = 0; row<=2;row++){
	    		x = currentPiece.getPositionX();
				for(int col=0; col< 3;col++){
					if(currentPiece.pieceGraph[row][col]&&x>=0&&y>=0&&x<board.length && y<board[0].length){
					        board[y][x] = true;
					}
					x++;
				}
				y++;
			}
	    }
        private  TetrisPiece randomPiece(){
	  TetrisPiece currentPiece;
	  double random = Math.random()*0.9;		
      random *= 8;
	  int result = (int)random;
      switch(result){
      case 1:
      	currentPiece = new LinePiece();
    	  break;
      case 2:
    	currentPiece = new TPiece();
    	break;
      case 3:
    	currentPiece = new LeftPiece();
    	break;
      case 4:
    	currentPiece = new RightPiece();
    	break;
      case 5:
    	currentPiece = new RightSPiece();
    	break;
      case 6:
    	currentPiece = new LeftSPiece();
    	break;
      case 7:
    	currentPiece = new SquarePiece();
    	break;
      default:
    	currentPiece = new LinePiece();
    	break;
       }
      return currentPiece;
	}
	private  int isRowComplete(boolean[][] board){
		int currentrow = -1;
		int counter;
		for(int row=board.length-1;row>=0;row--){
			counter = 0;
			for(int col=0;col<board[0].length;col++){
				if(board[row][col]==true){
					counter += 1;
				}else{
					break;
				}
			}
		if(counter == board.length){
			currentrow = row;
			return currentrow;
		}
	  }
		return -1;
	}
        private boolean movePiece(){
            switch(button){
    		   case "A" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: a");//For debugging
    			   currentPiece.goLeft(board);
    			   tempBoard.insertNewPiece(currentPiece);
                           
    			   break;
    		   case "S" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: s");//For debugging
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "D" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: d");//For debugging
    			   currentPiece.goRight(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "W" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: w");//For debugging
    			   while(!currentPiece.cantMoveMore){
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   }
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "L" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: l");//For debugging
    			   currentPiece.rotate();
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   default:
    		          //System.out.println("The button is not valid"
                          //+", try again");//For debuging
    			   break;   
    		   }
    		    
    	   //End of selection of movement
       
        return currentPiece.cantMoveMore;
     }
        private void changeRowComplete(){
           rowcompletenumber = isRowComplete(board);
           auxboard = board;
    	   while(!(rowcompletenumber == -1)){
    		rowcompletenumber = isRowComplete(board);
                auxboard = board;
    		if(!(rowcompletenumber==-1)){
    			for(int i = rowcompletenumber; i >0;i--){
    				for(int col=0;col<auxboard[0].length;col++){
    					if((i-1) >0){
    					board[i][col] = auxboard[i-1][col];
    					}
    				}
    			}
    			auxboard = board;
    			score +=5;
    			tempBoard = new TetrisPrint(board) ;
    		}
           }
        }
    //This is the principal method
    public  boolean iteration(String buttonin){
    	   this.writeButton(buttonin);
           if(this.movePiece()){
              if(boardSpaceLeft()){
              numberPieces +=1;
              score+=1;
              insertNewPieceBoard(currentPiece,board);
              this.changeRowComplete();
              currentPiece =this.randomPiece();
              tempBoard = new TetrisPrint(board) ;
              tempBoard.insertNewPiece(currentPiece);
              }else{
               return false;
             }
           }
           //FIXME: change for a graphical interface
           
           tempBoard.printBoard();
       return true;
    }
}
        
	

