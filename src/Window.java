import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {

    private Screen screen;

    Window(){
        this.setTitle("Cat Run Game");
        this.setSize(600,500);
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen = new Screen();
        add(screen);
    }

    public void startGame(){
        screen.startGame();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //nie psuje wygladu po zmianie rozmiaru okna
//        g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
        BufferedImage cat = null;
        try {
            cat = ImageIO.read(new File("img/cat.png"));
            g.drawImage(cat,100,getHeight()/2, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
