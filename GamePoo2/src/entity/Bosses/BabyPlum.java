package entity.Bosses;

import entity.Enemies.Enemies;
import main.GamePanel;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class BabyPlum extends Enemies {
    public BabyPlum(GamePanel gp) {
        super(gp);
        name="BabyPlum";
        direction="up";
        dmg=3;
        speed=3;
        type=2;
        life=40;
        setAction();
        getNPCImages("FourStates","BabyPlum","Enemies");
    }
    public void setAction(){
        actionCounter++;
        if (actionCounter == 70) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            int y=random.nextInt(3);
            if(y==0) {
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
