package MyGame.Tiles;
import MyGame.Assets.*;

public class EndPointTile3 extends Tile {
    public EndPointTile3(int id) {
        super(Assets.endPoint2, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}