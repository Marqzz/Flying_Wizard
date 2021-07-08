package MyGame.World;//this class is going to load our images

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class ImageLoader {

    public static BufferedImage loadImage(String path){

        //this is how we load an image
        try{
            //return ImageIO.read(MyGame.MyGame.World.World.ImageLoader.class.getResource(path));-doesn't work..
            return ImageIO.read(new File(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
