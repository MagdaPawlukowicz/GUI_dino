package objects;
import recources.Animation;
import recources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static inteface.Screen.GRAVITY;
import static inteface.Screen.GROUNDY;

public class CatPixel {
    private float x= 0;
    private float y= 0;
    private float speedY = 0;
    private Animation catMove;
    Rectangle catRect;
    private boolean isAlive = true;

    public CatPixel(){
        catMove = new Animation(300);
        catMove.addFrame(Resource.getResourceImage("img/cat.png"));
        catMove.addFrame(Resource.getResourceImage("img/cat2.png"));
        catMove.addFrame(Resource.getResourceImage("img/cat_hide.png"));
        catRect = new Rectangle();

    }

    public Rectangle getBound(){
        return catRect;
    }

    public void update(){
        catMove.update();
        if (y>= GROUNDY - catMove.getFrame().getHeight()){
            speedY = 0;
            y = GROUNDY - catMove.getFrame().getHeight();
        } else {
            speedY += GRAVITY; //gravity powoduje że obiekt zawsze spada
            y += speedY;
        }
        catRect.x = (int) x;
        catRect.y = (int) y;
        catRect.width = catMove.getFrame().getWidth();
        catRect.height = catMove.getFrame().getHeight();
    }

    public void draw(Graphics g){
        g.drawImage(catMove.getFrame(), (int) x, (int) y, null);

    }

    public void jump(){
        if(speedY != 0) {
        }else {
            speedY = -6; //wysokosc skoku
            y += speedY;
        }
    }

    public void hide(){
       catMove.setFrame(2);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void rise() {
        catMove.setFrame(0);
    }
}
