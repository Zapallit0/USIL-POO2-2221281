package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Sound {
    Clip clip;
    String soundURL[]=new String[30];
    public Sound(){
        soundURL[0]= "/sound/xd.wav";
        soundURL[1]= "/sound/prueba2.wav";
        soundURL[2]= "/sound/newMusic.wav";
        soundURL[3]= "/sound/getKey.wav";
        soundURL[4]= "/sound/gearSecondLuffy.wav";
        soundURL[5]= "/sound/gearSecondSE.wav";
    }

    public void setFile(int i){
        try {
            AudioInputStream ais= AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream(soundURL[i])));
            clip=AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
