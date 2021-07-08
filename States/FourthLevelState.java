package MyGame.States;

import MyGame.Entities.Player;
import MyGame.Entities.Points;
import MyGame.Entities.PointsFactory;
import MyGame.Game.Handler;
import MyGame.World.World;

import java.awt.Graphics;

public class FourthLevelState extends State {

    private Player player;
    private World world;
    static private Points[] points;
    private PointsFactory pf;

    public FourthLevelState(Handler handler){
        super(handler);
        world = new World(handler,"C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\MyRealMap04.txt");
        handler.setWorld(world);
        player=new Player(handler,70,300);

        points = new Points[5];
        pf = new PointsFactory(handler);


        points[0] = pf.createPoints(250+800,250-125);
        points[1] = pf.createPoints(500+300,50+175);
        points[2] = pf.createPoints(1200-400,70+100);
        points[3] = pf.createPoints(1200-650,280);
        points[4] = pf.createPoints(100+100,100+100);
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
    public Points[] getPoints(){
        return points;
    }
    @Override
    public void tick() throws InterruptedException {
        world.tick();
        player.tick();

        handler.getGameCamera().move(1,0);
    }
}
