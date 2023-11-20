package object.Items;



import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Message extends SuperObject {
    public OBJ_Message(){
        name="Msg";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/Items/BegginingMap.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }
}
