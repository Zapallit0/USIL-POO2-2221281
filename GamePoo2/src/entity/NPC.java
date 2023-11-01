package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;



public class NPC extends  Entity{
    protected KeyHandler keyH;

    public NPC(GamePanel gp) {
        super(gp);
        direction="down";
        speed=1;
        setAction();
        getNPCImages();
    }
    public void getNPCImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
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
