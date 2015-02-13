package model;

import java.awt.Image;

public class Coin {
    
    private Side side;
    private final Image[] images;
    private final Sound sounds;

    public enum Side{
        Head, Tail, Edge;
    }

    public Coin(Side side, String[] imagePath, String[] audioPath) {
        this.side = side;
        this.images = new Animation(imagePath).getImages();
        this.sounds = new Sound(audioPath);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Image[] getImages() {
        return images;
    }
    
    public Sound getSound(){
        return sounds;
    }
}
