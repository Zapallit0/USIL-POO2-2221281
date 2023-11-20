package object.PlayerAttributes;

import main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Heart extends SuperObject {
    public OBJ_Heart(GamePanel gp){
        name="Heart";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/PlayerHearth/heart_full.png")));
            image2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/PlayerHearth/heart_half.png")));
            image3= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/PlayerHearth/heart_blank.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
