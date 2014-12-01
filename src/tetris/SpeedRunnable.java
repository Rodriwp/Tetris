/*
 * This class is for automovingdown thread 
 */

package tetris;
import java.awt.*;
/**
 *
 * @author Rodrigo Mompo
 */
public class SpeedRunnable extends Thread implements Runnable {
    private Canvas canvas2;
    private boolean isRunning = true;
    private boolean running ;
    private TetrisGameFunctions gameBoard;
    private int gameSpeed=1500;
    SpeedRunnable(Tetris frame,TetrisGameFunctions gameBoardin){
        gameBoard = gameBoardin;
        canvas2 = frame.canvas2; 
        running = false;    
        
    }
    public void setSpeed(int speedin) {
        this.gameSpeed = speedin;
    }
    public void pauseThread() throws InterruptedException{
        this.running = false;
    }

     public void resumeThread(){
        this.running = true;
    } 
    public void run() {
      while(true){
         
        try{Thread.sleep(gameSpeed/2);}catch(Exception e){};
        if(this.running){      
                    isRunning = gameBoard.iteration();
                    if(!isRunning){
                    BoardCanvas.setGameOver(true);
                    }
                    BoardCanvas.setBoard(gameBoard.tempBoard);
                    BoardCanvas.repaintCanvas(canvas2);  
            }
        try{Thread.sleep(gameSpeed/2);}catch(Exception e){};
        }
        
    }
}
