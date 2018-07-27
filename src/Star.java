import java.awt.*;
import java.awt.image.BufferedImage;
public class Star {
    public BufferedImage image; // mac dinh ko khai bao truy xuat thi la publi
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public int velocityY;
    public Star() { // constructer alt+fn+insret
    }
    public void run(){
        this.x=(this.x+this.velocityX+1000)%1000;
    }
    public void render(Graphics graphics){
        if(this.image !=null)
            graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }
}
