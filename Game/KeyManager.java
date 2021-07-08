package MyGame.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    //every key on the KeyBoard has a specific ID
    private boolean[] keys;
    public boolean up,down,left,right,reset,exit;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_SPACE];
        left = keys[KeyEvent.VK_A];
        reset = keys[KeyEvent.VK_R];
        exit = keys[KeyEvent.VK_E];
    }

    //methods to implement because " class KeyManager implements KeyListener "
    @Override
    public void keyTyped(KeyEvent e) {
        //later
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
