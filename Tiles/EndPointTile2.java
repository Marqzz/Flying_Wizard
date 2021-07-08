package MyGame.Tiles;
import MyGame.Assets.*;

public class EndPointTile2 extends Tile {
    public EndPointTile2(int id) {
        super(Assets.endPoint1, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}