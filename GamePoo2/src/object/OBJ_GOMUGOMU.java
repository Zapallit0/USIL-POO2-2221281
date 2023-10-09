package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_GOMUGOMU extends SuperObject{
    public OBJ_GOMUGOMU(){
        name="GomuGomu";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/GomuGomu .png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }
}
