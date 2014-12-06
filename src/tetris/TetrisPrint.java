/*
*This class convert the boolean matrix wich is use in the game
*and converts it into a integer matrix which is use for print the game
*in the canavas object 
*
*/


package tetris;
import tetrispieces.*;

public class TetrisPrint {
	protected int [][]board;
    private  int [][]auxboard;
	TetrisPrint(int dimensionBoard){
            board=new int[dimensionBoard][dimensionBoard];
            auxboard=new int[dimensionBoard][dimensionBoard];
            for(int row = 0; row<board.length;row++){
	        for(int col=0; col<board[0].length;col++){
                    board [row][col]= 0;	
	            auxboard[row][col] = 0;
		}
	    }
         
        }

    public void update(){
        for(int row = 0; row<board.length;row++){
            for(int col=0; col<board[0].length;col++){
                this.board[col][row] = this.auxboard[col][row];
            }
        }
    } 
    public void updateRowFill(int rowcompletenumber){
        for(int row = 0; row<board.length;row++){
            for(int col=0; col<board[0].length;col++){
                 this.auxboard[col][row] = this.board[col][row];
             }
        }
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
       
      }
    }
    public void insertNewPiece(TetrisPiece currentPiece){
    	int x= currentPiece.getPositionX(); 
    	int y = currentPiece.getPositionY();
    	
    	for(int row = 0; row<=2;row++){
    		x = currentPiece.getPositionX();
			for(int col=0; col< 3;col++){
				if(currentPiece.pieceGraph[row][col]&&x>=0&&y>=0&&x<this.board.length && y<this.board[0].length){   
                                        switch(currentPiece.getType()){
                                            case 1:
                                               this.board[y][x] = 1; 
                                                break;
                                            case 2:
                                               this.board[y][x] = 2; 
                                                break;
                                            case 3:
                                               this.board[y][x] = 3; 
                                                break;
                                            case 4:
                                               this.board[y][x] = 4; 
                                                break;
                                            case 5:
                                               this.board[y][x] = 5; 
                                                break;
                                            case 6:
                                               this.board[y][x] = 6; 
                                                break;
                                            case 7:
                                               this.board[y][x] = 7; 
                                                break;           
                                        }
                                     
				}
				x++;
			}
			y++;
		}
        }
    public void insertNewPieceAux(TetrisPiece currentPiece){
    	int x= currentPiece.getPositionX(); ;
    	int y = currentPiece.getPositionY();
    	
    	for(int row = 0; row<=2;row++){
            x = currentPiece.getPositionX();
			for(int col=0; col< 3;col++){
				if(currentPiece.pieceGraph[row][col]&&x>=0&&y>=0&&x<this.board.length && y<this.board[0].length){   
                                        switch(currentPiece.getType()){
                                            case 1:
                                               this.auxboard[y][x] = 1; 
                                                break;
                                            case 2:
                                               this.auxboard[y][x] = 2; 
                                                break;
                                            case 3:
                                               this.auxboard[y][x] = 3; 
                                                break;
                                            case 4:
                                               this.auxboard[y][x] = 4; 
                                                break;
                                            case 5:
                                               this.auxboard[y][x] = 5; 
                                                break;
                                            case 6:
                                               this.auxboard[y][x] = 6; 
                                                break;
                                            case 7:
                                               this.auxboard[y][x] = 7; 
                                                break;           
                                        }
                                     
				}
				x++;
			}
			y++;
		}
         }
    
    }

