package MyGame.Tiles;
import MyGame.Assets.*;

public class EndPointTile extends Tile {
    public EndPointTile(int id) {
        super(Assets.endPoint0, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}