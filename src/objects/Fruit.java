package objects;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fruit extends Enemy{
    private int fruitX;
    private int fruitY;
    private BufferedImage fruitImage;
    private CatPixel catPixel;
    private Rectangle rect;
    private boolean isScoreTaken;

    public Fruit(BufferedImage image, CatPixel pixel){
        this.catPixel = pixel;
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

    public int getFruitX() {
        return fruitX;
    }

    public void setFruitX(int fruitX) {
        this.fruitX = fruitX;
    }

    public int getFruitY() {
        return fruitY;
    }

    public void setFruitY(int fruitY) {
        this.fruitY = fruitY;
    }

    public BufferedImage getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(BufferedImage fruitImage) {
        this.fruitImage = fruitImage;

    }
}
