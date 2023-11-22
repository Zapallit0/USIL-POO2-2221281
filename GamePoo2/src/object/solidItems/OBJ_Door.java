package object.solidItems;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject {
    public OBJ_Door(){
        name="Door";
        try{
            image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Door/Door.png")));
        }catch (IOException e){
        }
        collision=true;
    }
    public OBJ_Door(String lado){
        if(lado=="L") {
            name = "DoorLeft";
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Door/DoorL.png")));
            } catch (IOException e) {
            }
            collision = true;
        }else if (lado=="R") {
            name = "DoorRight";
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Door/DoorR.png")));
            } catch (IOException e) {
            }
            collision = true;
        }
    }
}
