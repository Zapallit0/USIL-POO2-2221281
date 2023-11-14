package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Heart extends SuperObject{
    public OBJ_Heart(GamePanel gp){
        name="Heart";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/playerIcons/heart_full.png")));
            image2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/playerIcons/heart_half.png")));
            image3= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/playerIcons/heart_blank.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
