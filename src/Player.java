import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
   // public BufferedImage image; // mac dinh ko khai bao truy xuat thi la publi
    public int[] x=new int[3] ;
    public int[] y=new int[3];
    public int velocityX;
    public int velocityY;
    private Random random=new Random();
    public Player() { // constructer alt+fn+insret

    }

    public void run(){
        if(x[0]<0){
            y[0]=random.nextInt(500);
            x[0]= 950;
        }
        if(x[0]>950){
            y[0]=random.nextInt(500);
            x[0]= 0;
        }
        if(y[0]>500){
            y[0]= 0;
            x[0]= random.nextInt(950);
        }
        if(y[0]<0){
            x[0]=random.nextInt(950);
            y[0]= 500;
        }
        x[1]=(x[0]+60+1024)%1024;
        y[1]=(y[0]+600)%600;
        x[2]=((x[0]+x[1])/2+1024)%1024;
        y[2]=(y[0]+50+600)%600;
    }
    public void render(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.drawPolygon(x,y,3);
    }

}
