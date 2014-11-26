/*
 * Tetris Game 
 * @author Rodrigo Mompo Redoli
 * 
 * 
 * 
 * 
 * 
 */
package tetris;
import java.util.Scanner;
import tetrispieces.*;
public class Tetris {
  //Scanner for taking data V1.0
	 private static Scanner in;
  //Function
	public static boolean boardSpaceLeft(boolean [][] board){
		for(int row = 0; row<2;row++){
			for(int col=0; col<3;col++){
				if(board[row][col]){
				return false;	
				}
			}
		} 
		return true;
	}
	public static void insertNewPieceBoard(TetrisPiece currentPiece, boolean[][] board ){
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
    public static TetrisPiece randomPiece(){
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
	public static int isRowComplete(boolean[][] board){
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
    public static void game(){
		//Variables
		in = new Scanner(System.in);
	    boolean boardSpaceLeft = true;
	    TetrisPiece currentPiece;
	    String button;
		boolean board [][] = new boolean  [8][8];
		boolean auxboard [][] = new boolean  [8][8];
		TetrisPrint tempBoard = new TetrisPrint(board);	
		int rowcompletenumber = -1;
		int numberPieces=0;
		int score = 0;
		//End of declaration of variables and initialation of onjects
		System.out.println("\n.........................................."+
		                   "\n..........Starting the game..............."+
	                       "\n.........................................."+
		                   "\n............(Press Any Key)...............");
		in.next();
        while(boardSpaceLeft){
        	
    	  currentPiece = randomPiece();
    	  tempBoard.insertNewPiece(currentPiece);
    	   while(!currentPiece.cantMoveMore){//Select movement 
    		   System.out.println("You put "+numberPieces+" pieces in the board");
    		   System.out.println("Score: "+score);
    		   tempBoard.printBoard();
    		   System.out.print("\nInsert your next movement: ");
    		   button = in.next();
    		   switch(button){
    		   case "a" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: a");//For debugging
    			   currentPiece.goLeft(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "s" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: s");//For debugging
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "d" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: d");//For debugging
    			   currentPiece.goRight(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "w" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: w");//For debugging
    			   while(!currentPiece.cantMoveMore){
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   }
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "l" :
    			   tempBoard = new TetrisPrint(board) ;
    			   //System.out.println("Debug: l");//For debugging
    			   currentPiece.rotate();
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   default:
    		       System.out.println("The button is not valid, try again");
    			   break;   
    		   }
    		    
    	   }//End of selection of movement
    	  
    	   insertNewPieceBoard(currentPiece,board);
    	   numberPieces +=1;
    	   score +=1;
    	   auxboard = board;
    	   //Check if a row is complete and eliminate it 
    	   rowcompletenumber = isRowComplete(auxboard);
    	   while(!(rowcompletenumber == -1)){
    		rowcompletenumber = isRowComplete(auxboard);
    		System.out.println("rowcomplete: "+rowcompletenumber);
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
    	   //Check if the board is complete
    	   boardSpaceLeft = boardSpaceLeft(board);
    	  
        }
        System.out.println("Game Over\nScore: "+score);
	}
   //For testing new things 
    public static void debug(){
    }
	public static void main(String[] args){
		game();
	}
}
