package entity.NPCS;


import main.GamePanel;

import javax.swing.*;

public class coco extends NPC {
    public coco(GamePanel gp) {
        super(gp);
        direction="up";
        setAction();
        getNPCImages("TwoStates","coco");
    }

}