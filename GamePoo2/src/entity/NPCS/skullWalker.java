package entity.NPCS;

import main.GamePanel;

public class skullWalker extends NPC {
    public skullWalker(GamePanel gp) {
        super(gp);
        direction="down";
        speed=3;
        setAction();
        getNPCImages("FourStates", "skullWalker");
    }

}
