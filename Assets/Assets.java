package MyGame.Assets;//any image,sound,muzic,etc

import MyGame.World.*;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=32,height=32;

    public static BufferedImage grass,air,rock,endPoint0,endPoint1,endPoint2,endPoint3,endPoint4,point,finishedImage,startImage;
    public static BufferedImage[] player_flying,btn_start,btn_load1,btn_load2,btn_load3,btn_load4,btn_load5,btn_exit;

    public static void init(){
        //sheets that we will use
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\TileSet01.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\player.png"));

        //buttons
        btn_start = new BufferedImage[2];
        btn_start[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\startBtn.png");
        btn_start[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\startBtnHovered.png");
        btn_load1 = new BufferedImage[2];
        btn_load1[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl1Button.png");
        btn_load1[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl1ButtonHovered.png");
        btn_load2 = new BufferedImage[2];
        btn_load2[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl2Button.png");
        btn_load2[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl2ButtonHovered.png");
        btn_load3 = new BufferedImage[2];
        btn_load3[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl3Button.png");
        btn_load3[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl3ButtonHovered.png");
        btn_load4 = new BufferedImage[2];
        btn_load4[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl4Button.png");
        btn_load4[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl4ButtonHovered.png");
        btn_load5 = new BufferedImage[2];
        btn_load5[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl5Button.png");
        btn_load5[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\lvl5ButtonHovered.png");
        btn_exit = new BufferedImage[2];
        btn_exit[0] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\ExitButton.png");
        btn_exit[1] = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\ExitButtonHovered.png");

        //points
        point = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\Points.png");

        //end-game pop up + StartImage to Menu
        //finishedImage = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\GameFinished.png");
        startImage = ImageLoader.loadImage("C:\\Users\\user\\Desktop\\MyProjects\\MySeriousGame\\assets\\StartMenu.png");

        //player animations
        player_flying = new BufferedImage[4];
        player_flying[0] = sheet2.crop(0,0,width,height);
        player_flying[1] = sheet2.crop(32,0,width,height);
        player_flying[2] = sheet2.crop(32*2,0,width,height);
        player_flying[3] = sheet2.crop(32*3,0,width,height);

        //map tiles
        grass = sheet.crop(0,0,width,height);
        air = sheet.crop (32,0,width,height);
        rock = sheet.crop(32*2,0,width,height);
        endPoint0 = sheet.crop(32*3,0,width,height);
        endPoint1 = sheet.crop(32*4,0,width,height);
        endPoint2 = sheet.crop(32*5,0,width,height);
        endPoint3 = sheet.crop(32*6,0,width,height);
        endPoint4 = sheet.crop(32*7,0,width,height);

    }
}
