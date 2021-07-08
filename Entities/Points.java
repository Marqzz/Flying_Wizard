package MyGame.Entities;

import MyGame.Assets.Assets;
import MyGame.Game.Handler;
import MyGame.Tiles.Tile;

import java.awt.*;

public class Points extends StaticEntity {
    private boolean visible=true;

    public Points(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

        //setting the hitbox of our points
        bounds.x=8;//8
        bounds.y=8;//16
        bounds.width=16;
        bounds.height=16;
    }

    public void setVisible(boolean visible){
        this.visible=visible;
    }

    public void die(){
        //making Perimetru(hitbox) = 0
        this.bounds.x=0;
        this.bounds.y=0;
        this.bounds.width=0;
        this.bounds.height=0;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(visible){
            g.drawImage(Assets.point,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
        }
        //fillingRect so we can see the point`s hitBox
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
        //bounds.width,bounds.height);
    }
}

