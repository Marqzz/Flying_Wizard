package MyGame.Game;

import MyGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed,rightPressed;
    private int mouseX,mouseY;
    private UIManager uiManager;//manager for holding all of our UIObjects

    public MouseManager(){

    }

    public void setUiManager(UIManager uiManager){
        this.uiManager=uiManager;
    }



    //Implemented methods
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){//BUTTON1 = left click
            leftPressed = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){//BUTTON3 = right click
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){//BUTTON1 = left click
            leftPressed = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){//BUTTON3 = right click
            rightPressed = false;
        }

        if(uiManager != null){
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null){
            uiManager.onMouseMove(e);
        }
    }
}
