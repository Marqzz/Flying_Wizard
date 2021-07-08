package MyGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //STATIC STUFF
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile rockTile = new RockTile(2);
    public static Tile airTile = new AirTile(1);
    public static Tile endPoint0 = new EndPointTile(3);
    public static Tile endPoint1 = new EndPointTile2(4);
    public static Tile endPoint2 = new EndPointTile3(5);
    public static Tile endPoint3 = new EndPointTile4(6);
    public static Tile endPoint4 = new EndPointTile5(7);


    //CLASS

    public static final int TILEWIDTH=32,TILEHEIGHT=32;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;

        tiles[id]=this;
    }

    public void tick(){

    }

    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return this.id;
    }
}
