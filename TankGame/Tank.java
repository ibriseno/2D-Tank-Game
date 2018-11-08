package TankGame;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
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
    private int shoot;
    private int damage;
    private int i = 0;

    private BufferedImage bulletImg;
    private ArrayList<Bullet> myBulletList;
    private Bullet bullet;

    private final int R = 2;
    private final int ROTATIONSPEED = 4;



    private BufferedImage img;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private boolean EnterPressed;

   Tank(BufferedImage img, int health, int damage, int x, int y, int vx, int vy, int angle, int shoot) {

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
       // this.damage = damage;
        this.img = img;
        this.bullet = bullet;
        this.angle = angle;
       // this.shoot = shoot;
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

    /*Toggles*/
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


    /*Untoggles*/
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

    /**
     * Creates a rectangle health bar that is fixed with the tank
     * The health bar follows the tank around.*/
    public void tankHealth(Graphics2D g2){
        int health = 0;
        int maxHealth = 100;
        double hp = 0.0;
        double maxHP = 100.0;

        g2.setColor(Color.blue);
        g2.fill(new Rectangle2D.Double(x-30, y+50, 60,10));

    }

    /**
     * This section has all the actions of the tank
     * @return
     */
    public ArrayList<Bullet> getMyBulletList(){
        return this.myBulletList;
    }


    private void shoot(){
        if(i == 0 && i%50 == 0) {
            Bullet blt;
            blt = new Bullet(bulletImg, x , y, angle, 0, vx, vy);
            myBulletList.add(blt);
            System.out.println("Fire\n" + getMyBulletList().size());
            // checkBorder();
        }else{
            i = 0;
        }
    }
    public int getX(){
        return vx;
    }
    public int getY(){
        return vy;
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
