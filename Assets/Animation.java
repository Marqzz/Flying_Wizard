package MyGame.Assets;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed,index;
    private long lastTime,timer;//aceste variabile ne ajuta sa schimbam frameurile animatiei;
    private BufferedImage[] frames;//vector de frames;

    public Animation(int speed,BufferedImage[] frames){
        this.speed=speed;
        this.frames=frames;
        index = 0;
        lastTime = System.currentTimeMillis();
        timer = 0;
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){//daca a trecut mai mult timp decat era stabilit , atunci se schimba frame
            index++;
            timer = 0;
            if( index >= frames.length){
                index = 0;//restart animation
            }
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
