package MyGame.Entities;

import MyGame.Assets.Animation;
import MyGame.Assets.Assets;
import MyGame.Game.Handler;
import MyGame.States.State;
import MyGame.Utils.MyException;

import java.awt.*;

public class Player extends Creature {

    //Animations
    private Animation animFly;

    public static boolean[] levels = {false,false,false,false,false};//we have levels as an array of boolean
    public static int level = 0;//current level
    public static int counter = 0;//counter of points

    //method to "delete" the player
    public void diePlayer(){
        bounds.x=0;
        bounds.y=0;
        bounds.width=0;
        bounds.height=0;
    }

    //method to activate/deactivate a specified level
    public void setLevel(int index,boolean value){
        levels[index]=value;
    }

    public Player(Handler handler, float x, float y){
        super(handler,x,y,Creature.DEFAULT_CREATURE_WIDTH +12,Creature.DEFAULT_CREATURE_HEIGHT+12);

        bounds.x=8+4;
        bounds.y=8+2;
        bounds.width=16+4;
        bounds.height=16+12;

        //Animations init
        animFly = new Animation(50,Assets.player_flying);
    }

    @Override
    public void tick() throws InterruptedException {
        //Anim tick
        animFly.tick();

        //moving
        getInput();
        move();
    }

    //method to get input from keyboard
    private void getInput(){
        xMove=0;
        yMove=0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
        if(handler.getKeyManager().exit){
            System.out.println("You exitted the game!...");
            System.exit(0);
        }
        if(handler.getKeyManager().reset){
            handler.getGame().initMenuState();
            this.diePlayer();
            handler.getGameCamera().reset();
            counter = 0;
            State.setState(handler.getGame().menuState);
        }
    }

    //checking if the entity that we have is colliding with another one
    public boolean checkEntityCollisions(float xOffset,float yOffset) {
        for(int i=0;i<5;i++) {//we will always have 5 points on each level
            try {
                if (State.getState().getPoints()[i] != null) {
                    //folosim .intersects() ca sa vedem daca jucatorul intersecteaza cu vreun punct
                    if (State.getState().getPoints()[i].getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0, 0))) {
                        State.getState().getPoints()[i].setVisible(false);
                        counter++;//incrementam counter de puncte
                        State.getState().getPoints()[i].die();
                        return true;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("eroare from Player.java (checkEntityCollisions)");//aici putem creea noi exceptia noastra pt a primi punctaj :)
            }
        }

        return false;
    }

    //this method is going to return the CollisionBounds as a Rectangle(so we can use .intersects)
    @Override
    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int) (x+bounds.x+xOffset),(int) (y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public void move() throws InterruptedException {
        //daca NU se intersecteaza cu ceva pe axa OX , atunci poate sa se miste
        if(!checkEntityCollisions(x,0f)) {
            moveX();
        }
        //daca NU se intersecteaza cu ceva pe axa OY , atunci poate sa se miste
        if(!checkEntityCollisions(0f,y)) {
            moveY();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animFly.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

        //codul de mai jos ne arata hitbox-ul playerului
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
         //           bounds.width,bounds.height);

    }

}
