package entity.Enemies;

import main.GamePanel;

import java.awt.*;
import java.util.Objects;

public class redSpikes extends Enemies {
    public String side;

    public redSpikes(GamePanel gp, String side) {
        super(gp);
        name="redSpikes";
        this.side=side;
        if (Objects.equals(side, "right")) {
            direction="right";
        }if (Objects.equals(side, "left")) {
            direction="left";
        }if (Objects.equals(side, "up")) {
            direction="up";
        }if (Objects.equals(side, "down")) {
            direction="down";
        }
        type=2;
        speed=8;
        dmg=2;
        setAction();
        stateNPC="TwoStates";
        getNPCImages("OneState","redSpikes","Enemies");
        solidArea=new Rectangle(30,30,50,50);
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
