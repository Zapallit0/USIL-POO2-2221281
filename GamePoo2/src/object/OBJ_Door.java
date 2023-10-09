package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject{

    public OBJ_Door(){
        name="Door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/DoorSunny.png"));
        }catch (IOException e){
        }
        collision=true;
    }
    public OBJ_Door(String lado){
        if(lado=="L") {
            name = "DoorLeft";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/LeftDoor.png"));
            } catch (IOException e) {
            }
            collision = true;
        }else if (lado=="R") {
            name = "DoorRight";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/RightDoor.png"));
            } catch (IOException e) {
            }
            collision = true;
        }
    }
}