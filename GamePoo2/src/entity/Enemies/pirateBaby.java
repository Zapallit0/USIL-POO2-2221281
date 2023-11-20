package entity.Enemies;

import main.GamePanel;


public class pirateBaby extends Enemies {
    public pirateBaby(GamePanel gp) {
        super(gp);
        direction="up";
        type=2;
        speed=3;
        dmg=2;
        setAction();
        getNPCImages("TwoStates","babyPirate","Enemies");
        stateNPC="TwoStates";
    }
}
