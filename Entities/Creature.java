package MyGame.Entities;

import MyGame.Game.*;
import MyGame.States.FifthLevelState;
import MyGame.Tiles.Tile;

public abstract class Creature extends Entity {

    //variabile constante utilizate
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=32;
    public static final int DEFAULT_CREATURE_HEIGHT=32;

    protected float speed;
    protected float xMove,yMove;

    public Creature(Handler handler, float x , float y, int width, int height){

        super(handler,x,y,width,height);
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    //functia de miscare pe axa OX
    public void moveX() throws InterruptedException {
        if(x > 0){//Moving right

            int tx = (int) (x+xMove+bounds.x+bounds.width)/Tile.TILEHEIGHT;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
                !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)){
               x+=xMove;x+=2;
            }else{
                //in acest else , jucatorul ar putea fi impins inapoi din cauza coliziunilor
                //pentru cazul nostru , nu este nevoie de asa ceva
            }
        }else if(x<0){//Moving left
            int tx = (int) (x+xMove+bounds.x)/Tile.TILEHEIGHT;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)){
                x+=xMove;x+=2;
            }else{
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    //functia de miscare pe axa OY
    public void moveY() throws InterruptedException {
        if(y<0){//Up
            int ty=(int)(y+yMove+bounds.y)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)){
                y+=yMove;y++;
            }else{
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        }else if(y>0){//Down
            int ty=(int)(y+yMove+bounds.y+bounds.height)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)){
                y+=yMove;y++;
            }else{
                //in acest else , jucatorul ar putea fi impins inapoi din cauza coliziunilor
                //pentru cazul nostru , nu este nevoie de asa ceva
            }
        }
    }

    //metoda de coliziune cu un tile;
    //tot in aceasta metoda , schimbam variabila Player.levels[] , in functie de ce tile intersectam
    //punctele de trecere dintre nivele sunt niste Tileuri , de asta facem aici schimbarea
    protected boolean collisionWithTile(int x,int y) throws InterruptedException {
        if(handler.getWorld().getTile(x,y) == Tile.endPoint0){
            Player.levels[0] = true;
            Player.level++;
        }else if(handler.getWorld().getTile(x,y) == Tile.endPoint1){
            Player.levels[1] = true;
            Player.level++;
        }else if(handler.getWorld().getTile(x,y) == Tile.endPoint2){
            Player.levels[2] = true;
            Player.level++;
        }else if(handler.getWorld().getTile(x,y) == Tile.endPoint3){
            Player.levels[3] = true;
            Player.level++;
        }else if(handler.getWorld().getTile(x,y) == Tile.endPoint4){
            Player.levels[4] = true;
            Player.level++;
            FifthLevelState.okTrue();
        }

        return handler.getWorld().getTile(x,y).isSolid();
    }

}
