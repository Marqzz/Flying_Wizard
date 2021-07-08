package MyGame.Game;

import javax.swing.JFrame;
import java.awt.*;

public class Display {
    //our frame
    private JFrame frame;
    //canvas-for drawing our images ; canvas -> frame
    private Canvas canvas;

    private String title;
    private int width,height;//in pixels

    public Display(String title,int width,int height){
        this.title = title;
        this.width=width;
        this.height=height;

        createDisplay();
        //initialize canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        //maximum+minimum->to make sure it stays that way
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        //adding canvas to frame
        frame.add(canvas);
        //resize our window to see all of canvas
        frame.pack();
    }

    private void createDisplay(){
        //initialize JFRAME
        frame = new JFrame(title);
        frame.setSize(width,height);

        //for closing the game--proper closing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //not resizable
        frame.setResizable(false);

        //for the display to appear on the center of the screen
        frame.setLocationRelativeTo(null);

        //set it visible
        frame.setVisible(true);
    }

    //GETTERS
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
