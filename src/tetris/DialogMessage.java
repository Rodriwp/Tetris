
package tetris;

import javax.swing.*;


/**
 * @author Rodrigo Mompo
 */
public class DialogMessage extends JFrame {
    DialogMessage(Tetris frame,int type){
        if(type == 0)
        JOptionPane.showMessageDialog(frame, 
                  "\n Arrows||   ASWD    "
                + "\n Left: \u2962 ||Left:    A  "
                + "\n Right:\u2964 ||Right:   D  "
                + "\n Down: \u2965||Down:    S  "
                + "\n Drop: \u2963 ||Drop:    W  "
                + "\n Rotate: Z||Rotate:  L  "
                + "\n*************************"
                + "\n Pause: P  "
                ,"Controls",JOptionPane.INFORMATION_MESSAGE);
        else{
           JOptionPane.showMessageDialog(frame, "Tetris Beta 2.0 \n by Rodrigo Mompo Redoli\n and Oscar Jimenez Rama\n controlrobotics@rodrigomompo.com "
                ,"About",JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
}
