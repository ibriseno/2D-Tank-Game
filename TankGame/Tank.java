package TankGame;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import static javax.imageio.ImageIO.read;

/**
 *
 * @author
 */
public class Tank extends GameObject {


    private int x;
    private int y;
    private int vx;
    private int vy;
    private int angle;
    private int shoot, damage;

    private BufferedImage bulletImg;
    private ArrayList<Bullet> myBulletList;


    private final int R = 2;
    private final int ROTATIONSPEED = 4;



    private BufferedImage img;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private boolean EnterPressed;

   Tank(BufferedImage img, int life, int damage, int x, int y, int vx, int vy, int angle, int shoot) {

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.damage = damage;
        this.img = img;
        this.angle = angle;
        this.shoot = shoot;
        this.myBulletList = new ArrayList<Bullet>();

        try{
            bulletImg = read(new File("Resources/Shell.gif"));
        }catch(Exception e){
            System.out.println("Exception in PlayerTank1");
        }

    }

    public int getDamage(){
       return this.damage;
    }

    public ArrayList<Bullet> getMyBulletList(){
        return myBulletList;
    }

    private void shoot(){
        Bullet blt;
        blt = new Bullet(bulletImg, x,y, vy, vx, angle, damage, Xspeed,Yspeed);
        myBulletList.add(blt);
        System.out.println("Fire\n");
        checkBorder();


    }


    void toggleUpPressed() {
        this.UpPressed = true;
    }

    void toggleDownPressed() {
        this.DownPressed = true;
    }

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void toogleEnterPressed(){this.EnterPressed = true;}



    void unToggleUpPressed() {
        this.UpPressed = false;
    }

    void unToggleDownPressed() {
        this.DownPressed = false;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    void unToggleEnterPressed(){this.EnterPressed = false;}

    public void update() {
        if (this.UpPressed) {
            this.moveForwards();
        }
        if (this.DownPressed) {
            this.moveBackwards();
        }

        if (this.LeftPressed) {
            this.rotateLeft();
        }
        if (this.RightPressed) {
            this.rotateRight();
        }
        if(this.EnterPressed){
            this.shoot();
        }

    }



    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void moveBackwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
        checkBorder();
    }

    private void moveForwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }




    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= GameWorld.SCREEN_WIDTH - 88) {
            x = GameWorld.SCREEN_WIDTH - 88;
        }
        if (y < 40) {
            y = 40;
        }
        if (y >= GameWorld.SCREEN_HEIGHT - 80) {
            y = GameWorld.SCREEN_HEIGHT - 80;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }

    /**
     * This should be used to load up the health bar for the tanks.
     * @param g
     */
    void drawImage(Graphics g) {

         AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
         rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
         Graphics2D g2d = (Graphics2D) g;
         g2d.drawImage(this.img, rotation, null);



    }

}
