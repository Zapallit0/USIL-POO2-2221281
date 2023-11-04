package entity;

import entity.EnemyBuilder.DirectorEnemy;
import entity.attacks.attackWithBullets;
import main.GamePanel;

import java.util.Random;



public class pirateBaby extends NPC implements attackWithBullets {
    public pirateBaby(GamePanel gp) {
        super(gp);
        direction="up";
        setAction();
        getNPCImages();
    }
    DirectorEnemy directorEnemy=new DirectorEnemy();

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
