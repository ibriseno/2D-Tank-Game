package TankGame;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.imageio.ImageIO.read;

/**
 *
 * @author anthony-pc
 */
public class GameWorld extends JPanel  {

    int w = 640, h = 480;
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 960;
    public static final int TILE_SIZE = 1280/80;    //Used for building walls
    private Bullet blt;
    private BufferedImage world;
    private Graphics2D buffer;
    Graphics2D g2;
    private JFrame jf;
    private Tank t1;
    private Tank t2;
    private Image background;
    private Graphics2D bullet;
    private Image borderWall;                       //Wall Image
    int move = 0;

    static ArrayList<Bullet> bullet1 = new ArrayList<Bullet>(100);


    public static void main(String[] args) {
        Thread x;
        GameWorld trex = new GameWorld();
        trex.init();
        try {

            while (true) {
                trex.t1.update();
                trex.t2.update();
                    trex.repaint();
                    System.out.println(trex.t1);
                    // System.out.println(trex.t2);
                    Thread.sleep(1000 / 144);
                }
            } catch(InterruptedException ignored){

            }


    }

    private void init() {
        this.jf = new JFrame("Tank.Tank Rotation");
        this.world = new BufferedImage(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedImage t1img = null, t2img = null, bulletImg = null;
        try {
            BufferedImage tmp;
            System.out.println(System.getProperty("user.dir"));
            /*
             * note class loaders read files from the out folder (build folder in netbeans) and not the
             * current working directory.
             */
            t1img = read(new File("tank1.png"));
            background = read(new File("Resources/Background.bmp"));
            borderWall = read(new File("Resources/Wall1.gif"));                 //Wall source file
            bulletImg = read(new File("Resources/Shell.gif"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //
        //Tank.Tank Starting locations
        //
        t1 = new Tank(t1img,0, 0, 250, 200, 0, 0, 0, 0);//Tank.Tank 1 starting position
        t2 = new Tank(t1img, 0, 0, 100, 150, 0, 0, 0, 0);//Tank.Tank 2 starting position

        //
        //TankControl tc1 handles all the control keys
        //UP, DOWN, LEFT, RIGHT, ENTER will handle all the controls for tank 1.
        //W(up), S(down), A(left), D(right), F(shoot) will handle all the controls for tank 2.
        //
        //Another instance of a tank should be created.
        //
        TankControl tc1 = new TankControl(t1, t2, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_F);
        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);


        this.jf.addKeyListener(tc1);
      // this.jf.addKeyListener(tc2);


        this.jf.setSize(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT + 30);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);


    }

    @Override
    public void paintComponent(Graphics g) {
        background.getGraphics();

        Graphics2D g2 = (Graphics2D) g;
        buffer = world.createGraphics();
        super.paintComponent(g2);
        this.t1.drawImage(buffer);
        this.t2.drawImage(buffer);
        g2.drawImage(world,0,0,null);
        drawBG();
        drawBullet();
       drawBorderWalls();
    }
    /**
    *This draws the background for the entire map
     */
    public void drawBackGroundWithTileImage() {
        int TileWidth = background.getWidth(this);
        int TileHeight = background.getHeight(this);

        int NumberX = (int) (SCREEN_WIDTH / TileWidth);
        int NumberY = (int) (SCREEN_WIDTH / TileHeight);

        for (int i = -1; i <= NumberY; i++) {
            for (int j = 0; j <= NumberX; j++) {
                buffer.drawImage(background, j * TileWidth,
                        i * TileHeight + (move % TileHeight), TileWidth,
                        TileHeight, this);
            }
        }
        //move += speed;
    }

    /**
     * This section draws (calls) the final background
     * and also gets the bullet list for the tank.
     * It should also draw the bullet.
     */
    public void drawBG(){
        drawBackGroundWithTileImage();
        }


    public void drawBullet() {
        for (int i = 0; i < t1.getMyBulletList().size(); i++) {
            this.t1.getMyBulletList().get(i).drawBullet(buffer);
            this.t1.getMyBulletList().get(i).update(t1.getX(), t1.getY());
        }
    }

    /**
     * This sections draws the border walls individually.
     *
     */
    public void drawBorderWalls(){
        //Draws the border walls.
        //These walls should take no damage.
        //
        //

        int NumberX =  (int)(SCREEN_WIDTH / TILE_SIZE);
        int NumberY =  (int)(SCREEN_WIDTH / TILE_SIZE);

        for (int i = -1; i <= NumberY; i++) {
            for (int j = 0; j <= NumberX; j++) {
                //This is the top wall
                buffer.drawImage(borderWall, j * TILE_SIZE,
                        0 * TILE_SIZE + (move % TILE_SIZE), TILE_SIZE,
                        TILE_SIZE, this);
                //This is the left wall
                buffer.drawImage(borderWall, 0 * TILE_SIZE,
                        i * TILE_SIZE + (move % TILE_SIZE), TILE_SIZE,
                        TILE_SIZE, this);
                //
                //Use NumberX for the other border (right border)
                //
                buffer.drawImage(borderWall, (NumberX - 2) * TILE_SIZE,
                        i * TILE_SIZE + (move % TILE_SIZE), TILE_SIZE,
                        TILE_SIZE, this);

            }
        }

    }



}
