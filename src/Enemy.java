import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public BufferedImage image; // mac dinh ko khai bao truy xuat thi la publi
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;

    public Enemy() { // constructer alt+fn+insret
    }
    public void run(){
        this.x+=this.velocityX;
        this.y+=this.velocityY;
        if(this.y<0||this.y>600){
            this.velocityY=-this.velocityY;
        }
        if(this.x<0||this.x>1024){
            this.velocityX=-this.velocityX;
        }
    }
    public void render(Graphics graphics){
        if(this.image !=null)
            graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }


}
