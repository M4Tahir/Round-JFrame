import javax.swing.*;
import java.awt.*;

/**
 * This is a simple java swing application to create a round-edge JFrame use Graphics2D to make the edges smoother.
 * @author ~MT
 * @version 1.0
 */

public class MyFrame  extends JFrame {
    MyFrame(){
        this.setUndecorated(true); // to remove the default decoration
        this.setDefaultCloseOperation(3); // 3 is for JFrame.EXIT_ON_CLOSE
        this.setBackground(new Color(0,0,0,0)); // making the background Transparent so only the round panel is visible
        this.add(new MyPanel(800,400,100,100,new Color(0xB431FF)));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new MyFrame()); // making sure that the frame run after the program opens
    }
}
