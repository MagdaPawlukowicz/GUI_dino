package inteface;

import objects.CatPixel;
import objects.EnemiesControl;
import recources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class Screen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1f; //zmianna powodująca że kotek zawsze spada
    public static final float GROUNDY = 300; // zmienna określająca y gdzie ma sie zatrzymac
    public static final int GAME_OVER_STATE = 2;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_START_STATE = 0;
    private CatPixel cat;
    private Thread thread;
    private EnemiesControl enemiesControl;
    private int gameState = 0;
    private BufferedImage gameOverImage = Resource.getResourceImage("img/game_over.png");
    private BufferedImage startGameImage = Resource.getResourceImage("img/start.png");
    private long previousTime;
    private int score;
    private int highestScore;
    private String pathHighestScore = "C:\\Users\\Madzia\\IdeaProjects\\s24242_dino\\img\\highestScore.txt";
    private BufferedWriter writer;
    private BufferedReader reader;

    public Screen() {
        setBackground(Color.lightGray);
        thread = new Thread(this);
        cat = new CatPixel();
        cat.setY(200);
        cat.setX(40);
        enemiesControl = new EnemiesControl(cat, this);
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                update();
                repaint();
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void scoreInc(long deltaTime) {
        if ((System.currentTimeMillis() - previousTime) > deltaTime) {
            previousTime = System.currentTimeMillis();
            this.score += 1;
        }
    }

    public void saveScore(int score) {
        this.score = score;
        if (score >= getHighestScore()) {
            try {
                highestScore = score;
                writer = new BufferedWriter(new FileWriter(pathHighestScore));
                writer.write(String.valueOf(highestScore));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighestScore() {
        if (highestScore >= score) {
            try {
                reader = new BufferedReader(new FileReader(pathHighestScore));
                highestScore = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            highestScore = score;
        }
        return highestScore;
    }

    public void update() {
        switch (gameState) {
            case GAME_PLAY_STATE:
                cat.update();
                enemiesControl.update();
                break;
            case GAME_OVER_STATE:
                break;
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);
        cat.draw(g);
        switch (gameState) {
            case GAME_START_STATE:
                enemiesControl.restart();
                cat.setAlive(true);
                setScore(0);
                getHighestScore();
                g.drawImage(startGameImage, 100, 130, null);
                break;
            case GAME_PLAY_STATE:
                enemiesControl.draw(g);
                if (cat.getIsAlive() == false) {
                    gameState = GAME_OVER_STATE;
                }
                g.drawString("SCORE: " + this.score, 500, 30);
                g.drawString("HI: " + highestScore, 300, 30);
                scoreInc(250);
                break;
            case GAME_OVER_STATE:
                enemiesControl.draw(g);
                g.drawImage(gameOverImage, 110, 40, null);
                getHighestScore();
                saveScore(this.score);
                break;
        }
//        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_START_STATE) {
                    gameState = GAME_PLAY_STATE;
                }
                if (gameState == GAME_OVER_STATE) {
                    gameState = GAME_START_STATE;
                }
                break;
            case KeyEvent.VK_UP:
                if (gameState == GAME_PLAY_STATE) {
                    cat.jump();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (gameState == GAME_PLAY_STATE) {
                    cat.hide();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (KeyEvent.VK_DOWN == e.getKeyCode()) {
            cat.rise();
        }
    }
}
