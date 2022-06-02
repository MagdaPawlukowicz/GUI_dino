package inteface;
import javax.swing.*;
import java.io.IOException;

public class Window extends JFrame {

    private Screen screen;

    Window() throws IOException {
        this.setTitle("Cat Run Game");
        this.setSize(600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen = new Screen();
        add(screen);
        addKeyListener(screen);
        this.setLocationRelativeTo(null); //ustawia okno na środku
        this.setResizable(false);
        this.setVisible(true);
    }

    public void startGame(){
        screen.startGame();
    }

}
