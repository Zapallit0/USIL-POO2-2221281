package object.Items;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Gold extends SuperObject {
    public OBJ_Gold(){
        name="gold";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Items/Gold.png")));
        }catch (IOException ignored){
        }
        collision=false;
    }
}
