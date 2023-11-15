package entity.NPCS;

import main.GamePanel;


public class pirateBaby extends NPC {
    public pirateBaby(GamePanel gp) {
        super(gp);
        direction="up";
        speed=3;
        setAction();
        getNPCImages("TwoStates","babyPirate");
        stateNPC="TwoStates";
    }
}
