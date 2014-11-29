/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;
import java.awt.*;
/**
 *
 * @author Rodrigo Mompo
 */
public class SpeedRunnable implements Runnable {
    private TetrisGameFunctions gameBoard;
    SpeedRunnable(TetrisGUI frame,TetrisGameFunctions gameBoardin){
        gameBoard = gameBoardin;
        //canvas2 = frame.canvas2;
        
    }
    public void run() {
        while(true){
                    try{Thread.sleep(1000);}catch(Exception e){};
                    System.out.println("Hello from a thread!");
                    gameBoard.iteration("S");
                    //BoardCanvas.setBoard(gameBoard.tempBoard);
                    //BoardCanvas.repaintCanvas(canvas2);
                }
        
    }
}
