package objects;

import java.awt.*;

public abstract class Enemy {
    public abstract Rectangle getCollision();

    public abstract void draw(Graphics g);

    public abstract void update();

    public abstract boolean isAwayOfScreen();
}
