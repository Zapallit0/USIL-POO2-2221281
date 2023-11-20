package entity.Bosses;

import entity.Enemies.Enemies;
import main.GamePanel;

import java.awt.*;

public class BabyPlum extends Enemies {
    public BabyPlum(GamePanel gp) {
        super(gp);
        direction="up";
        dmg=3;
        speed=6;
        type=2;
        tipo="Boss";
        solidArea=new Rectangle(0,0,120,120);
        setAction();
        getNPCImages("FourStates","BabyPlum","Bosses");
    }
}
