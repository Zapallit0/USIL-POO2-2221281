package entity.NPCS;

import main.GamePanel;

import java.util.Random;

public class redSpikes extends NPC{

    public redSpikes(GamePanel gp) {
        super(gp);
        direction="right";
        speed=6;
        setAction();
        getNPCImages("OneState","redSpikes");
        stateNPC="TwoStates";
    }
    @Override
    public void setAction(){
        actionCounter++;
        if(actionCounter==120) {
            movementCounter++;
            if (movementCounter ==1) {
                direction = "right";
            }
            if (movementCounter ==2) {
                direction = "left";
                movementCounter=0;
            }
            actionCounter=0;
        }
    }
}
