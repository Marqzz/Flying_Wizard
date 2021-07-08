package MyGame.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

    private BufferedImage[] images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images,ClickListener clicker) {
        super(x, y, width, height);
        this.images=images;
        this.clicker=clicker;
    }

    @Override
    public void tick() { }

    @Override
    public void render(Graphics g) {
        if(hovered){//in functie de hovered , afisam imaginea corespunzatoare
            g.drawImage(images[1],(int)x,(int)y,width,height,null);
        }
        else{
            g.drawImage(images[0],(int)x,(int)y,width,height,null);
        }
    }

    //make it abstract so we can create more classes that can do separate actions
    //exemplu : faci buton pt load level , dar ai ca argumente STATE-ul si harta ( sau ai ceva la argumente care sa te ajute )
    // sa ma ajute sa nu creez 4 clase separate care fac putin diferit ( prototipe )
    @Override
    public void onClick() {
        //we use clicker bcs : we can create multiple buttons and just pass DIFFERENT IMAGES or DIFFERENT CLICKERS(that will perform different actions when clicked)
        clicker.onClick();
    }
}
