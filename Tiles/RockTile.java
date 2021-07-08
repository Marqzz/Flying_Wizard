package MyGame.Tiles;
import MyGame.Assets.*;
public class RockTile extends Tile {
//this is the TILE responsable with collision
    public RockTile( int id) {
        super(Assets.rock, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
