package MyGame.World;

import MyGame.Game.Handler;
import MyGame.Tiles.Tile;
import MyGame.Utils.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width,height;//the size of the map
    private int spawnX,spawnY;
    private int[][] tiles;

    public World(Handler handler, String path){
        this.handler = handler;
        loadWorld(path);
    }

    public void tick(){

    }

    //Rendering Efficiency--now we render only the tiles that we can see
    public void render(Graphics g){

        int xStart = (int)Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth()) / Tile.TILEWIDTH +1);
        int yStart=(int)Math.max(0,handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);

        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g,(int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
            }
        }

    }

    public Tile getTile(int x,int y){
        if(x<0 || y<0 || x>=width || y>= height){
            return Tile.grassTile;//to not crash daca iese din harta
        }

        Tile t=Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.rockTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width= Utils.parseInt(tokens[0]);
        height= Utils.parseInt(tokens[1]);

        spawnX= Utils.parseInt(tokens[2]);
        spawnY= Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                tiles[j][i] = Utils.parseInt(tokens[(j+i*width)+4]);
            }
        }
    }

    public void deleteWorld() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[j][i] = 0;
            }
        }
    }

    public int getWidth(){
        return this.width;
    }
}
