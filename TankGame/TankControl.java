/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TankGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author anthony-pc
 */
public class TankControl implements KeyListener {

    private Tank t1;
    private Tank t2;

    private final int up;
    private final int down;
    private final int right;
    private final int left;
    private final int shoot;

    private final int w; //up
    private final int s; //down
    private final int a; //left
    private final int d; //right
    private final int f; //f






    public TankControl(Tank tank, int up, int down, int left, int right, int shoot) {
        //Controls for tank 1
        this.t1 = tank;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.shoot = shoot;


        //Controls for tank 2
        this.t2 = tank;
        this.w = up;
        this.s = down;
        this.a = left;
        this.d = right;
        this.f = shoot;

    }


    @Override
    public void keyTyped(KeyEvent ke) {


    }

    @Override
    public void keyPressed(KeyEvent ke) {

        //Player 1 control toggle
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            this.t1.toggleUpPressed();
        }
        if (keyPressed == down) {
            this.t1.toggleDownPressed();
        }
        if (keyPressed == left) {
            this.t1.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.t1.toggleRightPressed();
        }
        if(keyPressed == shoot){
            this.t1.toogleEnterPressed();
        }




        //Player 2 control toggle
        if( keyPressed == w){
            this.t2.toggleUpPressed();
        }
        if (keyPressed == s) {
            this.t2.toggleDownPressed();
        }
        if (keyPressed == a) {
            this.t2.toggleLeftPressed();
        }
        if (keyPressed == d) {
            this.t2.toggleRightPressed();
        }
        if(keyPressed == f){
            this.t2.toogleEnterPressed();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();

       //Player 1 control untoggle
        if (keyReleased  == up) {
            this.t1.unToggleUpPressed();
        }
        if (keyReleased == down) {
            this.t1.unToggleDownPressed();
        }
        if (keyReleased  == left) {
            this.t1.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.t1.unToggleRightPressed();
        }
        if(keyReleased == shoot){
            this.t1.unToggleEnterPressed();
        }





       //Player 2 control untoggle
        if (keyReleased  == w) {
            this.t2.unToggleUpPressed();
        }
        if (keyReleased == s) {
            this.t2.unToggleDownPressed();
        }
        if (keyReleased  == a) {
            this.t2.unToggleLeftPressed();
        }
        if (keyReleased  == d) {
            this.t2.unToggleRightPressed();
        }
        if(keyReleased == f){
            this.t2.unToggleEnterPressed();
        }

    }
}
