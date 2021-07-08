package MyGame.States;

import java.awt.Graphics;

import MyGame.Entities.Points;
import MyGame.Game.Handler;

public abstract class State {

    //----- maybe get a nested class?
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
    //-----

    //CLASS

    public Handler handler;

    public State(Handler handler){

        this.handler=handler;
    }

    //methods to be implemented by derived classes from this
    public abstract Points[] getPoints();

    public abstract void tick() throws InterruptedException;

    public abstract void render(Graphics g);

}
