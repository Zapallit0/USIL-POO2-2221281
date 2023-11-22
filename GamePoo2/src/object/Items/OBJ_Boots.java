package object.Items;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots(){
        name="Boots";
        solidArea=new Rectangle(0,0);
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Items/Boots.png")));
        }catch (IOException ignored){
        }
        collision=false;
    }
}
