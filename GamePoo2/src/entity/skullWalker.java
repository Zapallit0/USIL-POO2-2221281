package entity;

import entity.attacks.attackMelee;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class skullWalker extends NPC implements attackMelee {
    public skullWalker(GamePanel gp) {
        super(gp);
        direction="down";
        speed=1;
        setAction();
        getNPCImages("FourStates", "skullWalker");
    }
    public void setAction(){
        actionCounter++;
        if(actionCounter==180) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionCounter=0;
        }
    }
    @Override
    public void attack() {

    }
}
