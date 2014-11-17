package tetris;
import tetrispieces.*;

public class TetrisPrint {
	protected  String [][]board; 
	TetrisPrint(boolean [][] gameBoard){
		board = new String[gameBoard.length][gameBoard[0].length];
		for(int row = 0; row<board.length;row++){
			for(int col=0; col<board[0].length;col++){
				if(gameBoard[row][col]){
					board [row][col] = "*";
				}else{
					board [row][col] = "0";
				}
			}
		}
		
		
	}
    public void printBoard(){
		for(int row = 0; row<this.board.length;row++){
			for(int col=0; col<this.board.length;col++){
				if(this.board[row][col].equals("*")){
					System.out.print("\u25A0  ");
				}else{
					System.out.print("\u25A1  ");
				}
			}
			System.out.println();	
		} 
    }
    public void insertNewPiece(TetrisPiece currentPiece){
    	int x = currentPiece.getPositionX();
    	int y = currentPiece.getPositionY();
    	
    	for(int row = 0; row<=2;row++){
    		x = currentPiece.getPositionX();
			for(int col=0; col< 3;col++){
				if(currentPiece.pieceGraph[row][col]&&x>=0&&y>=0&&x<this.board.length && y<this.board[0].length){
				        this.board[y][x] = "*";
				}
				x++;
			}
			y++;
		}
    }
}
