package objects;
import javax.swing.*;
import java.awt.*;

public class Fruit extends Enemy{
    private int fruitX;
    private int fruitY;
    private ImageIcon fruitImage;
    private Rectangle rect;


    public Fruit(ImageIcon image){
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
        rect.width = fruitImage.getIconWidth();
        rect.height = fruitImage.getIconHeight();
    }

    @Override
    public boolean isAwayOfScreen() {
        return fruitX + fruitImage.getIconWidth() < 0;
    }

    public void draw(Graphics g) {
        g.drawImage(fruitImage.getImage(), fruitX, fruitY, null);
    }

    @Override
    public Rectangle getCollision() {
        return rect;
    }

}
