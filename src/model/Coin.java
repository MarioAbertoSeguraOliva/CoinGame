package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Coin {
    
    private Side side;
    private final Image image;

    public enum Side{
        Head, Tail, Edge;
    }

    public Coin(Side side, String path) {
        this.side = side;
        this.image = loadImage(path);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
    
    private Image loadImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
        }
        return img;
    }

    public Image getImage() {
        return image;
    }
}
