package object.PlayerAttributes;

import main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class PlayerIcons extends SuperObject {
    public PlayerIcons(GamePanel gp){
             name="Icon";
            try{
                image= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Icons/Luffy/Icon1.png")));
                image2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Icons/Luffy/Icon2.png")));
            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
