package MyGame.UI;

import MyGame.Game.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

//manager for our UIOBjects , so we can have them all stored in a collection
public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;//stored in a collection

    public UIManager(Handler handler){
        this.handler= handler;
        objects = new ArrayList<UIObject>();
    }

    public void tick(){
        for(UIObject o : objects){
            o.tick();
        }
    }

    public void render(Graphics g){
        for(UIObject o : objects){
            o.render(g);
        }
    }

    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseRelease(e);
        }
    }

    public void addObject(UIObject o){
        objects.add(o);
    }

    public void removeObject(UIObject o){
        objects.remove(o);
    }
}
