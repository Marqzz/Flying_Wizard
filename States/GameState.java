package MyGame.States;
import MyGame.Entities.*;
import MyGame.World.*;
import MyGame.Game.Handler;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;
    static private Points[] points;
    private PointsFactory pf;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\MyRealMap01.txt");
        handler.setWorld(world);

        player = new Player(handler,70,300);
        points = new Points[5];
        pf=new PointsFactory(handler);

        //creating points with PointsFactory
        points[0] = pf.createPoints(150,250);
        points[1] = pf.createPoints(500,50);
        points[2] = pf.createPoints(1200,170);
        points[3] = pf.createPoints(1200,280);
        points[4] = pf.createPoints(250,200);

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
    }
}
