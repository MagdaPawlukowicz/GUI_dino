package recources;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List<ImageIcon> frames;
    private int frameIndex = 0;
    private long deltaTime;
    private long previousTime;

    public Animation(int deltaTime) {
        this.deltaTime = deltaTime;
        frames = new ArrayList<ImageIcon>();
    }

    public void update() {
        if ((System.currentTimeMillis() - previousTime) > deltaTime && catIsnNotHide()) {
            frameIndex++;
            frameIndex = frameIndex % 2;
            previousTime = System.currentTimeMillis();
        }
    }

    private boolean catIsnNotHide() {
        return frameIndex != 2;
    }

    public void addFrame(ImageIcon frame) {
        frames.add(frame);
    }

    public ImageIcon getFrame() {
        if (frames.size() > 0) {
            return frames.get(frameIndex);
        }
        return null;
    }

    public void setFrame(int frameIndex) {
        this.frameIndex = frameIndex;
    }

}
