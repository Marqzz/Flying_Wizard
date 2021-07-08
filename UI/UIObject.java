package MyGame.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x,y;
    protected int width,height;
    protected boolean hovered = false;
    protected Rectangle bounds;

    public UIObject(float x,float y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds = new Rectangle((int)x,(int)y,width,height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        //here we check if we are hovering a button
        if(bounds.contains(e.getX(),e.getY())){
            hovered = true;
        }
        else{
            hovered = false;
        }
    }

    public void onMouseRelease(MouseEvent e){
        //here we see if we clicked or not
        if(hovered == true){
            onClick();//do the action of the button
        }
    }

}
