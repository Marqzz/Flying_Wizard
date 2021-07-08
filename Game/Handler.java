package MyGame.Game;


import MyGame.World.World;

//this class helps us to have references to the game and world classes
public class Handler {

    private Game game;
    private World world;

    public Handler(Game game){
        this.game=game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){ return game.getMouseManager();}

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public void setWorld(World world){
        this.world=world;
    }

    public Game getGame(){
        return this.game;
    }

    public World getWorld(){
        return this.world;
    }
}
