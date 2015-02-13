package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animation {
    Image[] animationImages;

    public Animation(String[] path) {
        this.animationImages = loadImages(path);
    }

    public Image[] getImages() {
        return animationImages;
    }

    private Image[] loadImages(String[] path) {
        Image[] images = new Image[path.length];
        for (int i = 0; i < path.length; i++) {
            try {
                images[i] = ImageIO.read(new File(path[i]));
            } catch (IOException e) {
            }
        }
        return images;
    }
    
    
}
