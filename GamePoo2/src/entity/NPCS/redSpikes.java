package entity.NPCS;

import main.GamePanel;

import java.util.Objects;
import java.util.Random;

public class redSpikes extends NPC{
    public String side;

    public redSpikes(GamePanel gp, String side) {
        super(gp);
        name="redSpikes";
        this.side=side;
        if (side == "right") {
            direction="right";
        }if (side == "left") {
            direction="left";
        }if (side == "up") {
            direction="up";
        }if (side == "down") {
            direction="down";
        }
        type=2;
        speed=8;
        setAction();
        getNPCImages("OneState","redSpikes");
        stateNPC="TwoStates";
    }
    @Override
    public void setAction(){
        actionCounter++;
        if(actionCounter==60) {
            movementCounter++;
            if (movementCounter ==1) {
                if (Objects.equals(side, "right")) {
                    direction="right";
                }if (Objects.equals(side, "left")) {
                    direction="left";
                }if (Objects.equals(side, "up")) {
                    direction="up";
                }if (Objects.equals(side, "down")) {
                    direction="down";
                }
            }
            if (movementCounter ==2) {
                if (Objects.equals(side, "right")) {
                    direction="left";
                }if (Objects.equals(side, "left")) {
                    direction="right";
                }if (Objects.equals(side, "up")) {
                    direction="down";
                }if (Objects.equals(side, "down")) {
                    direction="up";
                }
                movementCounter=0;
            }
            actionCounter=0;
        }
    }
}
