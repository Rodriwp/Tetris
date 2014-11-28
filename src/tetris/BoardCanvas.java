
package tetris;
import java.awt.*;
public class BoardCanvas extends Canvas{
    public Color color;
    private int [][] printBoard;
    BoardCanvas(){
      
    }
    public void writeBoard(TetrisPrint tempboard){
        printBoard = tempboard.
    }
    @Override
    public void paint(Graphics g){
       g.setColor(getBackground());
       g.drawRect(0, 0,getWidth(), getHeight());
       for(int i = 0;i<400;i=i+50){
           for(int j = 0;j<400;j=j+50){
           g.setColor(Color.blue);
           g.drawRect(i, j, 50, 50);
           }
           
       }

     }
    public void setColor(int r,int g,int b){
        color = new Color(r,g,b);
      }

    }


