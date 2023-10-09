package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest(){
        name="Chest";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/Chest1.png"));
        }catch (IOException e){
        }
        collision=true;
    }
    public OBJ_Chest(String lado){
        if(lado=="L"){
            name="ChestLeft";
            try{
                image= ImageIO.read(getClass().getResourceAsStream("/Objects/ChestLeft.png"));
            }catch (IOException e){
            }
            collision=true;
        } else if (lado=="R") {
            name="ChestRight";
            try{
                image= ImageIO.read(getClass().getResourceAsStream("/Objects/ChestRight.png"));
            }catch (IOException e){
            }
            collision=true;
        }
    }
}
