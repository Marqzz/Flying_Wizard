package MyGame.States;

import MyGame.Assets.Assets;
import MyGame.Entities.Points;
import MyGame.Game.Handler;
import MyGame.UI.ClickListener;
import MyGame.UI.UIImageButton;
import MyGame.UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuState extends State {

    private BufferedImage startImage;

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        startImage = Assets.startImage;

        //start button
        uiManager.addObject(new UIImageButton(700, 50, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().initGameState();
                State.setState(handler.getGame().gameState);
            }
        }));
        //load lvl1
        uiManager.addObject(new UIImageButton(700, 50+64, 128, 64, Assets.btn_load1, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().initGameState();
                State.setState(handler.getGame().gameState);
            }
        }));
        //load lvl2
        uiManager.addObject(new UIImageButton(700, 50+64+64, 128, 64, Assets.btn_load2, new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("ai apasat butonul lv2 MenuState.java");
                handler.getGame().initSecondState();
                State.setState(handler.getGame().secondLevelState);
            }
        }));
        //load lvl3
        uiManager.addObject(new UIImageButton(700, 50+64+64+64, 128, 64, Assets.btn_load3, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().initThirdState();
                State.setState(handler.getGame().thirdLevelState);
            }
        }));
        //load lvl4
        uiManager.addObject(new UIImageButton(700, 50+64+64+64+64, 128, 64, Assets.btn_load4, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().initFourthState();
                State.setState(handler.getGame().fourthLevelState);
            }
        }));
        //load lvl5
        uiManager.addObject(new UIImageButton(700, 50+64+64+64+64+64, 128, 64, Assets.btn_load5, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().initFifthState();
                State.setState(handler.getGame().fifthLevelState);
            }
        }));
        uiManager.addObject(new UIImageButton(700 + 130, 50 + 64 + 64 + 64 + 64 + 64, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Exitted from menu!...");
                System.exit(0);
            }
        }));
    }

    @Override
    public Points[] getPoints() {
        return new Points[0];//basically does nothing since Menu doesn t have any points
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(startImage,0,0,1920,480,null);
        uiManager.render(g);
    }
}
