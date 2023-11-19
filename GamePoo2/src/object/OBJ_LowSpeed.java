package object;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

    public class OBJ_LowSpeed extends SuperObject {
    public OBJ_LowSpeed() {
            name = "LowSpeed";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/low.png"));
            } catch (IOException e) {
            }
            collision = true;
        }
    }


