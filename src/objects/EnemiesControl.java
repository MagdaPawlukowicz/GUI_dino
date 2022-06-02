package objects;

import inteface.Screen;
import recources.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemiesControl {
    private static final int TWO_SECOND_IN_MILLIS = 2000;
    private ArrayList<Enemy> enemies;
    private Long lastMillis;
    private BufferedImage apple, banana, cherry, lemon, orange, pear, pig;
    private CatPixel catPixel;
    private Screen screen;

    public EnemiesControl(CatPixel catPixel, Screen gameScreen){
        this.catPixel = catPixel;
        this.screen = gameScreen;
        enemies = new ArrayList<Enemy>();
        apple = Resource.getResourceImage("img/apple.png");
        banana = Resource.getResourceImage("img/banana.png");
        cherry = Resource.getResourceImage("img/cherry.png");
        lemon = Resource.getResourceImage("img/lemon.png");
        orange = Resource.getResourceImage("img/orange.png");
        pear = Resource.getResourceImage("img/pear.png");
        pig = Resource.getResourceImage("img/pig.png");
        this.lastMillis = System.currentTimeMillis();
    }

    public void update(){
        int random = (int) (Math.random()*4000) + TWO_SECOND_IN_MILLIS;
        for(Enemy e: enemies){
            e.update();
            if(e.getCollision().intersects(catPixel.getBound())){
                catPixel.setAlive(false);
            }
        }

        Enemy firstFruit = enemies.get(0);
        if (firstFruit.isAwayOfScreen()){
            enemies.remove(firstFruit);
        } else {
            long now = System.currentTimeMillis();
            long duration = now - lastMillis;
            if (duration > random) {
                enemies.add(myRandomEnemy());
                lastMillis = now;
            }
        }
    }

    public void restart() {
        enemies = new ArrayList<>();
        enemies.add(myRandomEnemy());
    }

    public void draw(Graphics g){
        for(Enemy e: enemies){
            e.draw(g);
        }
    }

    private Enemy myRandomEnemy(){
        int randomNumb = (int) (Math.random()*8);
        switch (randomNumb){
            case 0: return new Fruit(apple,catPixel);
            case 1: return new Fruit(banana, catPixel);
            case 2: return new Fruit(cherry, catPixel);
            case 3: return new Fruit(lemon, catPixel);
            case 4: return new Fruit(orange, catPixel);
            case 5: return new Fruit(pear, catPixel);
            default: return new Pig(pig, catPixel);
        }
    }
}
