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
import java.awt.Component;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;







import tetrispieces.*;


public class TetrisGame extends JPanel{
	 private static Scanner in;
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
	
	public static void game(){
		JFrame frame = new JFrame("Mini Tennis");
		MyKeyListener input = new MyKeyListener();
		frame.add(input);
		frame.setSize(200, 200);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		in = new Scanner(System.in);
	    boolean boardSpaceLeft = true;
	    TetrisPiece currentPiece;
	    String button;
	    
		boolean board [][] = new boolean  [8][8];
		TetrisPrint tempBoard = new TetrisPrint(board);	
		System.out.println("Starting the game");//FIXME: Improve intro menu (Start opcion);
        while(boardSpaceLeft){
        	//FIXME: select a random piece for new piece 
        	double random = Math.random()*0.9;		
    		random *= 8;
    		//random += 0;
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
        currentPiece = new TPiece();
    	tempBoard.insertNewPiece(currentPiece);
    	   while(!currentPiece.cantMoveMore){//
    		   tempBoard.printBoard();
    		   System.out.print("\nInsert your next movement: ");
    		   button = in.next();
    		   switch(button){
    		   case "a" :
    			   tempBoard = new TetrisPrint(board) ;
    			   System.out.println("Debug: a");
    			   currentPiece.goLeft(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "s" :
    			   tempBoard = new TetrisPrint(board) ;
    			   System.out.println("Debug: s");
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "d" :
    			   tempBoard = new TetrisPrint(board) ;
    			   System.out.println("Debug: d");
    			   currentPiece.goRight(board);
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "w" :
    			   tempBoard = new TetrisPrint(board) ;
    			   System.out.println("Debug: w");
    			   while(!currentPiece.cantMoveMore){
    			   currentPiece.cantMoveMore = currentPiece.goDown(board);
    			   }
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "l" :
    			   tempBoard = new TetrisPrint(board) ;
    			   System.out.println("Debug: l");
    			   currentPiece.rotate();
    			   tempBoard.insertNewPiece(currentPiece);
    			   break;
    		   case "":
    			   break;
    		   default:
    		       System.out.println("The button is not valid, try again");
    			   break;   
    		   }
    		   
    	   }
    	  
    	   insertNewPieceBoard(currentPiece,board);
          
    	   //FIXME:Check if a line is complete and execute 
    	   boardSpaceLeft = boardSpaceLeft(board);
    	  
        }
        System.out.println("Game Over");
	}
  public static void debug(){
	    JFrame frame = new JFrame("Tetris");
		TetrisKeyListener keyboardExample = new TetrisKeyListener();
		frame.add(keyboardExample);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
	public static void main(String[] args){
		/*(new Thread() {
			  public void run() {
			    while(true){
			    	System.out.println(System.currentTimeMillis());
			    	button = "s";
			    	try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    }
			  }
			 }).start();*/
	  //debug();  
		game();
	  
	}

}
