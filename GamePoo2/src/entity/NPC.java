package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class NPC extends  Entity{
    public int i,counter;
    public NPC(GamePanel gp) {
        super(gp);
        direction="down";
        speed=2;

        getNpcImages();
        setAction();
    }
    public void getNpcImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingup2.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingup1.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingdown1.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingdown2.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffystanding.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffywalking.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standingright.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffywalkingright.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting1.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting2.png")));
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
}
