import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {// van la class tach roi chua dc dua vafo window
    //cach dat ten bien
    //snake case user_name
    //camel case: userName
    private Graphics graphics;
    private BufferedImage backBuffered;
    private List<Star> stars;
    private List<Enemy> enemies;
    public Player player;
    public int timeIntervalStar=0;
    public int timeIntervalEnemy=0;
    private Random random=new Random();
    public GameCanvas(){
        this.setSize(1024,600);
        this.setUpBackBuffered();
        this.setCharacter();
    }
    @Override
    protected void paintComponent(Graphics g) {// noi ve tat ca moi thu
        // ve
        g.drawImage(this.backBuffered,0,0,null);
    }
    private void playerDiChuyen(){
        this.player.run();
    }
    private void enemyDiChuyen(){
        this.enemies.forEach(enemy -> enemy.run());
    }
    private void starDiChuyen(){
        this.stars.forEach(star -> star.run());
    }
    public void runAll(){
        this.enemyDiChuyen();
        this.starDiChuyen();
        this.playerDiChuyen();
    }
    public void createAll(){
        this.createStar();
        this.createEnemy();
    }
    public void renderAll(){
        //1 ve nen
        this.renderBackground();
        this.stars.forEach(star ->star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.repaint();// goi luon ham ve laij man hinh trong renderAll
    }
    private void renderBackground(){
        this.graphics.setColor(Color.BLACK); // set mau
        graphics.fillRect(0,0,1024,600);  // set hinh dang x, y , width,height
    }
    private BufferedImage loadImage(String path){
        try{
            return ImageIO.read((new File(path)));
        }catch (IOException e){
            return  null;
        }
    }
    private void createPlayer(){
        player=new Player();
        player.x[0]=500;
        player.y[0]=300;
        player.x[1]=player.x[0]+60;
        player.y[1]=player.y[0];
        player.x[2]=(player.x[0]+player.x[1])/2;
        player.y[2]=player.y[0]+50;
        player.velocityX=15;
        player.velocityY=15;
    }


    private void createEnemy(){
        if(this.timeIntervalEnemy==30){
            Enemy enemy=new Enemy();
            enemy.x=1020;
            enemy.y=this.random.nextInt(590);
            enemy.image=this.loadImage("resources-rocket-master/resources/images/circle.png");
            enemy.velocityX=random.nextInt(10);
            enemy.velocityY=enemy.velocityX;
            enemy.width=random.nextInt(40)+10;
            enemy.height=enemy.width;
            this.enemies.add(enemy);
            this.timeIntervalEnemy=0;
        }
        else{
            this.timeIntervalEnemy++;
        }
    }
    private  void createStar(){
        if(this.timeIntervalStar==10){
            Star star=new Star();
            star.x=1024;
            star.y=this.random.nextInt(600);
            star.height=5;
            star.width=5;
            star.image=this.loadImage("resources-rocket-master/resources/images/star.png");
            star.velocityX=random.nextInt(10)+1;
            this.stars.add(star);
            this.timeIntervalStar=0;
        }else{
            this.timeIntervalStar++;
        }
    }
    private void setUpEnemies(){
        this.enemies=new ArrayList<>();
    }
    private void setUpStar(){
        this.stars=new ArrayList<>();
    }
    private void setUpBackBuffered(){
        this.backBuffered=new BufferedImage(1024,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics=this.backBuffered.getGraphics();// co ve sex ve len backbuffer
    }
    private void setCharacter(){
        this.setUpStar();
        this.setUpEnemies();
        this.createPlayer();
    }
}
