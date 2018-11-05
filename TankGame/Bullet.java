package TankGame;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet  {

    int Xspeed, damage, angle;
    int x, y, vx, vy;
    int Yspeed;
    boolean show;
    private BufferedImage img;

    private boolean enterPressed;

    Bullet(BufferedImage img, int x, int y, int vy, int vx, int angle, int damage, int Xspeed, int Yspeed){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
        this.Xspeed = Xspeed;
        this.Yspeed = Yspeed;
        this.damage = damage;
        this.angle = angle;
        this.show = true;
    }
    public boolean getShow(){
        return this.show;
    }
    public void setShow(boolean s){
        this.show = s;
    }
    public void update(int w, int h){
        if(y < h-40 && y > 0 && x > 0 && x < w-40 && show){
            x = x + Xspeed;
            y = y + Yspeed;
        }else{
            this.show = false;
        }
    }
    public void drawBullet(Graphics g){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        AffineTransform shoot = AffineTransform.getTranslateInstance(x, y);

        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        //Graphics2D g2d = (Graphics2D) g;
        Graphics2D b2d = (Graphics2D) g;
        b2d.drawImage(this.img, shoot, null);
    }

}
