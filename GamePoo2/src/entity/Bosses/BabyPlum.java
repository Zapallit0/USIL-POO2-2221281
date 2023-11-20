package entity.Bosses;

import entity.Enemies.Enemies;
import main.GamePanel;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class BabyPlum extends Enemies {
    public BabyPlum(GamePanel gp) {
        super(gp);
        direction="up";
        dmg=3;
        speed=3;
        type=2;
        tipo="Boss";
        life=40;
        solidArea=new Rectangle(0,0,120,120);
        setAction();
        getNPCImages("FourStates","BabyPlum","Bosses");
    }
    public void setAction(){
        actionCounter++;
        if (actionCounter == 70) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            int y=random.nextInt(4);
            if(y==0||y==3) {
                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75) {
                    direction = "right";
                }
                actionCounter = 0;
            }
            if (y == 1) {
                if (i <= 50) {
                    direction = "right";
                    speed=10;
                }
                actionCounter = 0;
            }
            if (y == 2) {
                if (i <= 50) {
                    direction = "left";
                    speed=10;
                }
                actionCounter = 0;
            }
            }
    }
}
