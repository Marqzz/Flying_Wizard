package MyGame.Tiles;
import MyGame.Assets.*;

public class EndPointTile4 extends Tile {
    public EndPointTile4(int id) {
        super(Assets.endPoint3, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}