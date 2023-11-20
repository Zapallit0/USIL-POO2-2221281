package entity.Enemies;

import main.GamePanel;

public class skullWalker extends Enemies {
    public skullWalker(GamePanel gp) {
        super(gp);
        direction="down";
        type=2;
        speed=3;
        life=6;
        setAction();
        getNPCImages("FourStates", "skullWalker","Enemies");
    }
}
