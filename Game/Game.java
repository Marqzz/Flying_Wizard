package MyGame.Game;//MyGame.Game.Game class will be the MAIN class
//it will hold all of our base code

import MyGame.Assets.Assets;
import MyGame.Entities.Player;
import MyGame.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.time.Instant;

//thread - un program to run separat fata de celelalte(?)
//synchronized->you put this when you use Threads

public class Game implements Runnable{

    //Singleton
    private static Game instance = null;

    private Display display;
    private int width,height;
    public String title;

    private boolean isRunning = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States -- better in private
    public State gameState;
    public State menuState;
    public State secondLevelState;
    public State thirdLevelState;
    public State fourthLevelState;
    public State fifthLevelState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //MyGame.Game.Handler
    private Handler handler;

    //times
    public static Instant start;
    private Instant end;

    public Game(String title,int width,int height){
        this.width=width;
        this.height=height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public static Game getInstance(String title,int width,int height){
        if(instance == null){
            instance = new Game(title,width,height);
        }
        return instance;
    }



    private void init(){
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        //to make sure we have mouse events - JFrame is not enough so we put in in canvas too
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        start = Instant.now();

        handler = new Handler(this);
        gameCamera = new GameCamera(this,handler,0,0);

        //init with firstLevelState
        //gameState = new GameState(handler);
        //State.setState(gameState);
        menuState = new MenuState(handler);
        State.setState(menuState);

    }

    private void tick() throws InterruptedException {
        keyManager.tick();

        //code for changing states
        if(Player.levels[0]){

            //abia daca ajungem la urmatorul nivel, instantiem starea urmatoare
            System.out.println("CHECK FROM PASSING LVL1 -- Game.java");
            secondLevelState = new SecondLevelState(handler);

            //setam STATE si WORLD
            State.setState(secondLevelState);
            secondLevelState.handler.setWorld(secondLevelState.handler.getWorld());

            //resetam camera
            gameCamera.setxOffset(0);
            gameCamera.setyOffset(0);

            //resetam levelPass pt a nu intra din nou
            //mergem pe presupunearea ca daca am trecut de un nivel , nu am NICIO cale de intoarcere , deci putem sa resetam linistiti
            Player.levels[0]=false;

        }
        else if(Player.levels[1]){//se aplica ca la primul nivel,adaptat.
            System.out.println("CHECK FROM PASSING LVL2-- Game.java");

            thirdLevelState = new ThirdLevelState(handler);

            State.setState(thirdLevelState);

            thirdLevelState.handler.setWorld(thirdLevelState.handler.getWorld());

            gameCamera.setxOffset(0);
            gameCamera.setyOffset(0);

            Player.levels[1]=false;

        }
        else if(Player.levels[2]){
            System.out.println("CHECK FROM PASSING LVL3-- Game.java");

            fourthLevelState = new FourthLevelState(handler);

            State.setState(fourthLevelState);

            fourthLevelState.handler.setWorld(fourthLevelState.handler.getWorld());

            gameCamera.setxOffset(0);
            gameCamera.setyOffset(0);

            Player.levels[2]=false;
        }
        else if(Player.levels[3]){
            System.out.println("CHECK FROM PASSING LVL4-- Game.java");

            fifthLevelState = new FifthLevelState(handler);

            State.setState(fifthLevelState);

            fifthLevelState.handler.setWorld(fifthLevelState.handler.getWorld());

            gameCamera.setxOffset(0);
            gameCamera.setyOffset(0);

            Player.levels[3]=false;
        }
        else if(Player.levels[4]){
            g.drawImage(Assets.finishedImage,100,100,860,348,null);
            System.out.println("FINAL DE JOC URA !...-- Game.java");
        }

        //end--changing states

        if(State.getState()!=null){
            State.getState().tick();
        }
    }

    private void render() throws InterruptedException {
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            //we have to create one if it bs == null
            display.getCanvas().createBufferStrategy(3);//3 buffers
            return;
        }

        g = bs.getDrawGraphics();

        //Clear screen
        g.clearRect(0,0,width,height);
        //Draw here--

        if(State.getState()!=null){
            State.getState().render(g);
        }

        //End drawing--

        //Tell Java we stopped drwaing
        bs.show();

        //make sure our graphics object gets done with properly
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        //.nanoTime()=returns the time in nanoSeconds that our Computer is running at
        long timer = 0;
        int ticks = 0;

        while(isRunning){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                try {
                    tick();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticks++;
                delta--;
            }

            if(timer >=1000000000){
                System.out.println("Ticks and Frames:"+ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public void initMenuState(){
        menuState = new MenuState(handler);
    }

    public void initGameState(){
        gameState = new GameState(handler);
    }

    public void initSecondState(){
        secondLevelState = new SecondLevelState(handler);
    }
    public void initThirdState(){
        thirdLevelState = new ThirdLevelState(handler);
    }
    public void initFourthState(){
        fourthLevelState = new FourthLevelState(handler);
    }
    public void initFifthState(){
        fifthLevelState = new FifthLevelState(handler);
    }
    public KeyManager getKeyManager(){

        return keyManager;
    }

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return width;
    }

    public Handler getHandler(){
        return handler;
    }

    public int getHeight(){
        return height;
    }

    //the method to START the Thread
    public synchronized void start(){
        if(isRunning)//to make sure isRunning = false so we will not overlap threads
            return;
        isRunning = true;
        thread = new Thread(this);
        this.start = Instant.now();
        thread.start();// it will call "run" method
    }

    //the method to STOP the Thread
    public synchronized void stop(){
        if(!isRunning)
            return ;
        isRunning=false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
