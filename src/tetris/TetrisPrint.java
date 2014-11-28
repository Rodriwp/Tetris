package tetris;
import tetrispieces.*;

public class TetrisPrint {
	protected  int [][]board; 
	TetrisPrint(boolean [][] gameBoard){
		board = new int[gameBoard.length][gameBoard[0].length];
		for(int row = 0; row<board.length;row++){
			for(int col=0; col<board[0].length;col++){
				if(gameBoard[row][col]){
					board [row][col] = 1;
				}else{
					board [row][col] = 0;
				}
			}
		}
		
		
	}
    public void insertNewPiece(TetrisPiece currentPiece){
    	int x = currentPiece.getPositionX();
    	int y = currentPiece.getPositionY();
    	
    	for(int row = 0; row<=2;row++){
    		x = currentPiece.getPositionX();
			for(int col=0; col< 3;col++){
				if(currentPiece.pieceGraph[row][col]&&x>=0&&y>=0&&x<this.board.length && y<this.board[0].length){   
                                         this.board[y][x] = 1;  
				}
				x++;
			}
			y++;
		}
    }
}
