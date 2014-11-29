
package tetris;
import java.awt.*;
public class BoardCanvas extends Canvas{
    public int squareWidth;
    private final Font FONT = new Font("TimesRoman", Font.BOLD, 50);
    private static int [][] printBoard;
    private static boolean gameOver = false;
    BoardCanvas(TetrisGameFunctions gameBoard){
        printBoard = new int [20][20];
        BoardCanvas.setBoard(gameBoard.tempBoard);
        this.repaint();
    }
    public static void setBoard(TetrisPrint tempboard){
        printBoard = tempboard.board;
    }
    public  static void setGameOver(boolean a){
        gameOver = a;
    }
    public static boolean getGameOver(){
        return gameOver;
    }
    @Override
    public void paint(Graphics g){
       squareWidth = getWidth()/printBoard.length;
       g.setColor(getBackground());
       g.drawRect(0, 0,getWidth(), getHeight());
       for(int i = 0;i<400;i=i+squareWidth){
           for(int j = 0;j<400;j=j+squareWidth){
           g.setColor(Color.black);
           g.drawRect(i, j, squareWidth, squareWidth);
           if(printBoard[j/squareWidth][i/squareWidth] != 0){
               switch(printBoard[j/squareWidth][i/squareWidth]){
                    case 1:
                        g.setColor(Color.blue);
                        break;
                    case 2:
                        g.setColor(Color.green);     
                        break;
                    case 3:
                        g.setColor(Color.cyan);                                                 
                        break;
                    case 4:
                        g.setColor(Color.orange);          
                        break;
                    case 5:        
                        g.setColor(Color.yellow);      
                        break;
                    case 6:         
                        g.setColor(Color.magenta);                                         
                        break;
                    case 7:
                        g.setColor(Color.blue);                                        
                        break;           
               }   
              g.fillRect(i+1, j+1, squareWidth-1, squareWidth-1);
              }else{
              g.setColor(getBackground());
              g.fillRect(i+1, j+1, squareWidth-1, squareWidth-1);
              }
          }    
        }
      if(gameOver){
        g.setColor(Color.red);
        g.setFont(FONT);
        g.drawString("GameOver", 75, 200);
       }
     }

    }


