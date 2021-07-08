package MyGame.Game;

//Design Patterns - Modelul Fatada
public class Launcher {
    //MyGame.Game.Launcher class is going to be responsible to launch the game
    public static void main(String[] args){
        Game game = Game.getInstance("MyTitle",1920,480);
        game.start();
    }
}
