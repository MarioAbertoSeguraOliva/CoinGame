package model;

import javafx.scene.media.Media;

public class Sound {
    private final Media[] sfx;
    
    public Sound(String[] path) {
        sfx = new Media[path.length];
        for (int i = 0; i < path.length; i++) {
            sfx[i] = new Media(path[i]);
        }
    }
    
    public Media[] getClips(){
        return sfx;
    }
}