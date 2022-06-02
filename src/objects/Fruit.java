package objects;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fruit extends Enemy{
    private int fruitX;
    private int fruitY;
    private BufferedImage fruitImage;
    private Rectangle rect;


    public Fruit(BufferedImage image){
        this.fruitImage = image;
        fruitX =600;
        fruitY=250;
        rect = new Rectangle();
        rect.intersects(rect);
    }

    public void update(){
        fruitX -=2;
        rect.x = fruitX;
        rect.y = fruitY;
        rect.width = fruitImage.getWidth();
        rect.height = fruitImage.getHeight();
    }

    @Override
    public boolean isAwayOfScreen() {
        return fruitX + fruitImage.getWidth() < 0;
    }

    public void draw(Graphics g) {
        g.drawImage(fruitImage, fruitX, fruitY, null);
    }

    @Override
    public Rectangle getCollision() {
        return rect;
    }

}
