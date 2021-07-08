package MyGame.Entities;

import MyGame.Game.Handler;
import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;//coordonates
    protected int width,height;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.handler=handler;

        bounds = new Rectangle(0,0,width,height);
    }

    //this method is going to return the CollisionBounds as a Rectangle(so we can use .intersects)
    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int) (x+bounds.x+xOffset),(int) (y+bounds.y+yOffset),bounds.width,bounds.height);

    }

    public abstract void tick() throws InterruptedException;
    public abstract void render(Graphics g);

    //GETTERS AND SETTERS----

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setX(float x){
        this.x=x;
    }

    public void setY(float y){
        this.y=y;
    }

    public void setWidth(int width){
        this.width=width;
    }

    public void setHeight(int height){
        this.height=height;
    }
}
