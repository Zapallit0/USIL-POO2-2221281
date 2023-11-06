package entity.NPCS;

import main.GamePanel;

import java.util.Random;

public class redSpikes extends NPC{

    public redSpikes(GamePanel gp) {
        super(gp);
        direction="up";
        speed=6;
        setAction();
        getNPCImages("TwoStates","redSpikes");
        stateNPC="TwoStates";
    }
    @Override
    public void setAction(){
        actionCounter++;
        if(actionCounter==300) {
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
