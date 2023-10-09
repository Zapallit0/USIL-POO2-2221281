package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Transformations  {
    public Player luffy;
    public BufferedImage image;
    int gear;
    public Transformations(){
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Icons/Luffy/IconLuffy_Gear1.png")));
            } catch (IOException e) {
            }
    }

    public BufferedImage setGear(int gear) {
        if(gear==1){
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Icons/Luffy/IconLuffy_Gear1.png")));
            } catch (IOException e) {
            }
        } else if (gear==2) {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Icons/Luffy/IconLuffy_Gear2.png")));
            } catch (IOException e) {
            }
        }
        return image;
    }

}
