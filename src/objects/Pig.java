package objects;
import javax.swing.*;

public class Pig extends Enemy {

    public Pig(ImageIcon image) {
        super(image);
        Enemy.enemyX = 600;
        Enemy.enemyY = 220 - (int)(Math.random() * 100);
    }
}
