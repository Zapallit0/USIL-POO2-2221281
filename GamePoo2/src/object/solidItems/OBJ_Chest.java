package object.solidItems;

import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest(){
        name="Chest";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/Chest/Chest.png"));
        }catch (IOException e){
        }
        collision=true;
    }
    public OBJ_Chest(String lado){
        if(lado=="L"){
            name="ChestLeft";
            try{
                image= ImageIO.read(getClass().getResourceAsStream("/Objects/Chest/ChestL.png"));
            }catch (IOException e){
            }
            collision=true;
        } else if (lado=="R") {
            name="ChestRight";
            try{
                image= ImageIO.read(getClass().getResourceAsStream("/Objects/Chest/ChestR.png"));
            }catch (IOException e){
            }
            collision=true;
        }
    }
}
