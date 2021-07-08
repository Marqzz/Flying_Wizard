package MyGame.Tiles;
import MyGame.Assets.*;

public class EndPointTile5 extends Tile {
    public EndPointTile5(int id) {
        super(Assets.endPoint4, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}