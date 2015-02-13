package view;

import javafx.scene.media.MediaPlayer;
import model.Sound;


public class SoundPLayer {

    private final MediaPlayer[] player;
    
    public SoundPLayer(Sound sound) {
        this.player = loadSounds(sound);
    }
    
    public void play(int pos){
        player[pos].play();
    }

    public MediaPlayer[] getPlayer() {
        return player;
    }

    private MediaPlayer[] loadSounds(Sound sound) {
        MediaPlayer[] mediaPlayer = new MediaPlayer[sound.getClips().length];
        for (int i = 0; i < mediaPlayer.length; i++) {
            mediaPlayer[i]=new MediaPlayer(sound.getClips()[i]);
        }
        return mediaPlayer;
    }
    
    
}
