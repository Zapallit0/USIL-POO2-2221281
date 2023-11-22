package object.Items;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_GOMUGOMU extends SuperObject {
    public OBJ_GOMUGOMU(){
        name="GomuGomu";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Items/DevilFruit1.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }
}
