package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends SuperObject{

    public OBJ_Key(){
        name="Key";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/LlaveDoor.png"));
        }catch (IOException e){
        }
    }
}