package objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pig extends Enemy {
    private int pigX;
    private int pigY;
    private BufferedImage pigImage;
    private Rectangle rect;

    public Pig(BufferedImage image) {
        this.pigImage = image;
        pigX = 600;
        pigY = 220 - (int)(Math.random() * 100);
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
        return pigX + pigImage.getWidth() < 0;
    }

    public void draw(Graphics g) {
        g.drawImage(pigImage, pigX, pigY, null);
    }

    @Override
    public Rectangle getCollision() {
        return rect;
    }

}
