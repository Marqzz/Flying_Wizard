package MyGame.Game;

import MyGame.Entities.Entity;
import MyGame.Game.Game;

public class GameCamera {

    private float xOffset,yOffset;
    private Game game;
    private Handler handler;
    public GameCamera(Game game, Handler handler, float xOffset, float yOffset){
        this.game=game;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handler=handler;
    }

    public void move(float xAmt,float yAmt){

        //camera is rolling until it reaches the bounds of the map
        //handler.getWorld().getWidth() * 7 -27 -> this value is made by me to fit for the game
        if(handler.getWorld().getWidth() * 7 -27 > xOffset){
            xOffset+=xAmt;
            yOffset+=yAmt;
        }

    }

    public void reset(){
        this.setxOffset(0);
        this.setyOffset(0);
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setxOffset(float x) {
        this.xOffset = x;
    }

    public void setyOffset(float y){
        this.yOffset=y;
    }
}
