package entity;

import entity.attacks.attackWithBullets;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class pirateBaby extends NPC implements attackWithBullets {
    public pirateBaby(GamePanel gp) {
        super(gp);
        direction="up";
        speed=1;
        setAction();
        getNPCImages();
    }
    @Override
    public void getNPCImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
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
