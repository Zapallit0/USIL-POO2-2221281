package object.Items;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Cora extends SuperObject {
    public OBJ_Cora(){
        name="cora";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Items/Hearth.png")));
        }catch (IOException ignored){
        }
        collision=false;
    }
}

