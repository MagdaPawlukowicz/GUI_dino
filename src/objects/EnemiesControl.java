package objects;

import inteface.Screen;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class EnemiesControl {
    private List<Enemy> enemies;
    private long lastTimeOfEnemyCreation;
    private ImageIcon apple, banana, cherry, lemon, orange, pear, pig;
    private CatPixel catPixel;
    private Screen screen;

    public EnemiesControl(CatPixel catPixel, Screen gameScreen){
        this.catPixel = catPixel;
        this.screen = gameScreen;
        enemies = new LinkedList<>();
        apple = new ImageIcon(this.getClass().getResource("/img/apple.png"));
        banana = new ImageIcon(this.getClass().getResource("/img/banana.png"));
        cherry = new ImageIcon(this.getClass().getResource("/img/cherry.png"));
        lemon = new ImageIcon(this.getClass().getResource("/img/lemon.png"));
        orange = new ImageIcon(this.getClass().getResource("/img/orange.png"));
        pear = new ImageIcon(this.getClass().getResource("/img/pear.png"));
        pig = new ImageIcon(this.getClass().getResource("/img/pig.png"));
    }

    public void update(){
        checkIfCollisionWithCat();
        removeEnemyIfOutside();
        createEnemyInRandomTime();
    }

    private void checkIfCollisionWithCat() {
        for(Enemy e: enemies){
            e.update();
            if(e.getCollision().intersects(catPixel.getBound())){
                catPixel.setAlive(false);
            }
        }
    }

    private void removeEnemyIfOutside() {
        if (enemies.size() == 0) return;

        Enemy firstFruit = enemies.get(0);
        if (firstFruit.isAwayOfScreen()){
            enemies.remove(0);
        }
    }

    private void createEnemyInRandomTime() {
        int randomTimeOfEnemyCreation = (int) (Math.random()*4000) + 2000;
        long now = System.currentTimeMillis();
        long duration = now - lastTimeOfEnemyCreation;
        if (duration > randomTimeOfEnemyCreation) {
            enemies.add(myRandomEnemy());
            lastTimeOfEnemyCreation = now;
        }
    }

    public void restart() {
        enemies = new LinkedList<>();
        this.lastTimeOfEnemyCreation = 0;
    }

    public void draw(Graphics g){
        for(Enemy e: enemies){
            e.draw(g);
        }
    }

    private Enemy myRandomEnemy(){
        int randomNumb = (int) (Math.random()*8);
        switch (randomNumb){
            case 0: return new Fruit(apple);
            case 1: return new Fruit(banana);
            case 2: return new Fruit(cherry);
            case 3: return new Fruit(lemon);
            case 4: return new Fruit(orange);
            case 5: return new Fruit(pear);
            default: return new Pig(pig);
        }
    }
}
