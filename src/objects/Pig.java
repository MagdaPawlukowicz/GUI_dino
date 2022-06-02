package objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pig extends Enemy {
    private int pigX;
    private int pigY;
    private BufferedImage pigImage;
    private CatPixel catPixel;
    private Rectangle rect;

    public Pig(BufferedImage image, CatPixel catPixel) {
        this.catPixel = catPixel;
        this.pigImage = image;
        pigX = 600;
        pigY = (int) (Math.random() * 60) + 200;
        rect = new Rectangle();
        rect.intersects(rect);
    }

    public void update() {
        pigX -= 2;
        rect.x = pigX;
        rect.y = pigY;
        rect.width = pigImage.getWidth();
        rect.height = pigImage.getHeight();
    }

    @Override
    public boolean isAwayOfScreen() {
        boolean isAway = pigX + pigImage.getWidth() < 0;
        return isAway;
    }

    public void draw(Graphics g) {
        g.drawImage(pigImage, pigX, pigY, null);
    }

    @Override
    public Rectangle getCollision() {
        return rect;
    }

    public int getFruitX() {
        return pigX;
    }

    public void setFruitX(int fruitX) {
        this.pigX = fruitX;
    }

    public int getFruitY() {
        return pigY;
    }

    public void setFruitY(int fruitY) {
        this.pigY = fruitY;
    }

    public BufferedImage getFruitImage() {
        return pigImage;
    }

    public void setFruitImage(BufferedImage fruitImage) {
        this.pigImage = fruitImage;
    }
}
