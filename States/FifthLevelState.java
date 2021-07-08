package MyGame.States;

import MyGame.Assets.Assets;
import MyGame.Database.DataBase;
import MyGame.Entities.Player;
import MyGame.Entities.Points;
import MyGame.Entities.PointsFactory;
import MyGame.Game.Handler;
import MyGame.World.World;

import java.awt.Graphics;

public class FifthLevelState extends State {

    private Player player;
    private World world;
    private static Boolean ok=false;//daca am terminat jocul
    static private Points[] points;
    private PointsFactory pf;

    public static boolean getOk(){
        return ok;
    }

    public static void okTrue(){
        ok = true;
    }

    public static void okFalse(){
        ok = false;
    }

    public FifthLevelState(Handler handler){
        super(handler);
        world = new World(handler,"C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\MyRealMap05.txt");
        handler.setWorld(world);
        player=new Player(handler,70,300);
        ok = false;

        points = new Points[5];
        pf = new PointsFactory(handler);


        points[0] = pf.createPoints(250,250);
        points[1] = pf.createPoints(500,50+175);
        points[2] = pf.createPoints(1200,150);
        points[3] = pf.createPoints(1200-375,280);
        points[4] = pf.createPoints(100+375,100+100);
    }
    @Override
    public Points[] getPoints(){
        return points;
    }
    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);

        for (int i=0;i<5;i++){
            if(points[i] != null)
                points[i].render(g);
        }

    }

    @Override
    public void tick() throws InterruptedException {
        world.tick();
        player.tick();

        handler.getGameCamera().move(1,0);

        //codul pt a face trecerea dintre last level -> menu state;
        if(ok){
            //resetam points counter,player,camera;
            player.diePlayer();
            handler.getGame().initMenuState();
            player.setLevel(4,false);
            ok =false;
            System.out.println("am ajuns la final din FIFTHLEVELSTATE.JAVA");
            player = new Player(handler,70,300);

            //inseram timestamp in DB
            DataBase.insertTimestamp();

            //schimbam starea
            State.setState(handler.getGame().menuState);
            handler.getGameCamera().reset();
            Player.counter=0;
            ok =false;

        }
    }
}
