
package tetris;
import java.awt.*;
public class BoardCanvas extends Canvas{
    public Color color;
    private static int [][] printBoard = new int [8][8];
    private static boolean gameOver = false;
    BoardCanvas(){
    }
    public static void setBoard(TetrisPrint tempboard){
        printBoard = tempboard.board;
    }
    public static void setGameOver(boolean a){
        gameOver = a;
    }
    @Override
    public void paint(Graphics g){
       g.setColor(getBackground());
       g.drawRect(0, 0,getWidth(), getHeight());
       for(int i = 0;i<400;i=i+50){
           for(int j = 0;j<400;j=j+50){
           g.setColor(Color.black);
           g.drawRect(i, j, 50, 50);
           if(printBoard[j/50][i/50] == 1){
           g.setColor(Color.blue);
           g.fillRect(i+1, j+1, 49, 49);
           }else{
           g.setColor(getBackground());
           g.fillRect(i+1, j+1, 49, 49);
           }
         }    
       }
     if(gameOver){
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawString("GameOver", 75, 200);
     }
     }

    }


