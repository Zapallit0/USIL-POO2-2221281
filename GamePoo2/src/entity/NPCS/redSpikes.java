package entity.NPCS;

import main.GamePanel;

import java.util.Objects;
import java.util.Random;

public class redSpikes extends NPC{
    public String side;

    public redSpikes(GamePanel gp, String side) {
        super(gp);
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
        speed=6;
        setAction();
        getNPCImages("TwoStates","redSpikes");
        stateNPC="TwoStates";
    }
    @Override
    public void setAction(){
        actionCounter++;
        if(actionCounter==120) {
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
                System.out.println(direction +" + "+side);
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
                System.out.println(direction +" + "+side);
                movementCounter=0;
            }
            actionCounter=0;
        }
    }
}
