package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class skullWalker extends NPC implements attackMelee{
    public skullWalker(GamePanel gp) {
        super(gp);
        direction="down";
        speed=1;

        getNPCImages();
        setAction();
    }
    public void getNPCImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_up1.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_up2.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_down1.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_down2.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_left1.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_left2.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_right1.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC1/NPC1_right2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
