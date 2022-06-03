package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pig extends Enemy {
    private int pigX;
    private int pigY;
    private ImageIcon pigImage;
    private Rectangle rect;

    public Pig(ImageIcon image) {
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
        rect.width = pigImage.getIconWidth();
        rect.height = pigImage.getIconHeight();
    }

    @Override
    public boolean isAwayOfScreen() {
        return pigX + pigImage.getIconWidth() < 0;
    }

    public void draw(Graphics g) {
        g.drawImage(pigImage.getImage(), pigX, pigY, null);
    }

    @Override
    public Rectangle getCollision() {
        return rect;
    }

}
