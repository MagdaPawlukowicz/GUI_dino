package inteface;
import javax.swing.*;

public class Window extends JFrame {

    private Screen screen;

    Window() {
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
