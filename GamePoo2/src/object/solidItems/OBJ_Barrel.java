package object.solidItems;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Barrel extends SuperObject {
    public OBJ_Barrel(){
        name="Barrel";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/Items/Barrel.png"));
        }catch (IOException e){
        }
        collision=true;
    }
}
