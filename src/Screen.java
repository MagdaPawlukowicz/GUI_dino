import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable{
    private int count;
    private Thread thread;
    public Screen(){
        setBackground(new Color(196, 253,255));
        thread = new Thread(this);
    }
    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count++);
        }
    }
}
