package tetris;
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
    public  int dimensionGame ;
    private boolean boardSpaceLeft = true;
    private TetrisPiece currentPiece;
    private String button;
    private boolean board [][] ;
    private boolean auxboard [][] ;
    public TetrisPrint tempBoard;
    private int rowcompletenumber = -1;
    private int numberPieces=0;
    private int score = 0;
   TetrisGameFunctions(int dimensiongame){
        dimensionGame = dimensiongame;
        board = new boolean  [dimensionGame][dimensionGame];
        auxboard  = new boolean  [dimensionGame][dimensionGame];
        tempBoard = new TetrisPrint(dimensiongame);
        dimensionGame = dimensiongame;
        currentPiece = randomPiece();
        tempBoard.insertNewPiece(currentPiece);
     
   } 
        public int getScore(){return score;}
        public int getSNumberPieces(){return numberPieces;}
        public void writeButton(String buttonin){
            this.button = buttonin;
        }
   	private boolean boardSpaceLeft(){
		for(int row = 0; row<2;row++){
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
	  TetrisPiece piece;
	  double random = Math.random()*0.9;		
      random *= 8;
	  int result = (int)random;
      switch(result){
      case 1:
      	piece = new LinePiece();
    	  break;
      case 2:
    	piece = new TPiece();
    	break;
      case 3:
    	piece = new LeftPiece();
    	break;
      case 4:
    	piece = new RightPiece();
    	break;
      case 5:
    	piece = new RightSPiece();
    	break;
      case 6:
    	piece = new LeftSPiece();
    	break;
      case 7:
    	piece = new SquarePiece();
    	break;
      default:
    	piece = new LinePiece();
    	break;
       }
      return piece;
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
    			   tempBoard.update(); 
    			   //System.out.println("Debug: a");//For debugging
    			   currentPiece.goLeft(board);
    			   tempBoard.insertNewPiece(currentPiece);
                           
    			   break;
    		   case "S" :
    			   tempBoard.update(); 
    			   //System.out.println("Debug: s");//For debugging
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "D" :
    			   tempBoard.update(); 
    			   //System.out.println("Debug: d");//For debugging
    			   currentPiece.goRight(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "W" :
    			   tempBoard.update(); 
    			   //System.out.println("Debug: w");//For debugging
    			   while(!currentPiece.cantMoveMore){
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   }
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "L" :
    			   tempBoard.update(); 
    			   //System.out.println("Debug: l");//For debugging
    			   currentPiece.rotate(board);
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
                 for(int row = 0; row<board.length;row++){
                     for(int col=0; col<board[0].length;col++){
                        this.auxboard[col][row] = this.board[col][row];
                     }
                }
                 tempBoard.updateRowFill(rowcompletenumber);
    	         score +=5;
    	         tempBoard.update(); 
    		}
           }
        }
    //This is the principal method
    public  boolean iteration(String buttonin){
           //System.out.println("Debug: iteration");//For debugging
    	   this.writeButton(buttonin);
           if(this.movePiece()){
              numberPieces +=1;
              score+=1;
              insertNewPieceBoard(currentPiece,board);
              tempBoard.insertNewPieceAux(currentPiece);
              this.changeRowComplete();
              tempBoard.update(); 
              if(boardSpaceLeft()){
              currentPiece =this.randomPiece();
              tempBoard.insertNewPiece(currentPiece);
              }else{
               return false;
             }
           }
       return true;
    }
}
        
	

