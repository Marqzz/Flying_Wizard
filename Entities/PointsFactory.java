package MyGame.Entities;

import MyGame.Game.Handler;
import MyGame.Tiles.Tile;

//Factory---
public class PointsFactory {

    private Handler handler;

    public PointsFactory(Handler handler){
        this.handler = handler;
    }

    public Points createPoints(float x,float y){
        return new Points(this.handler,x,y, Tile.TILEWIDTH,Tile.TILEHEIGHT);
    }
}
