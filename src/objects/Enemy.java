package objects;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    public static int enemyX;
    public static int enemyY;
    protected ImageIcon enemyImage;
    protected Rectangle rect;

    protected Enemy(ImageIcon image) {
        this.enemyImage = image;
        rect = new Rectangle();
        rect.intersects(rect);
    }

    public void update() {
        enemyX -= 2;
        rect.x = enemyX;
        rect.y = enemyY;
        rect.width = enemyImage.getIconWidth();
        rect.height = enemyImage.getIconHeight();
    }

    public boolean isAwayOfScreen() {
        return enemyX + enemyImage.getIconWidth() < 0;
    }

    public void draw(Graphics g) {
        g.drawImage(enemyImage.getImage(), enemyX, enemyY, null);
    }

    public Rectangle getCollision() {
        return rect;
    }
}
