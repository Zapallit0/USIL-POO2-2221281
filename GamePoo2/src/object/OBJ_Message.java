package object;



import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Message extends SuperObject{
    public OBJ_Message(){
        name="Msg";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/Objects/tn.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }
}
