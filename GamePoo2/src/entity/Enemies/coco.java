package entity.Enemies;


import main.GamePanel;

public class coco extends Enemies {
    public coco(GamePanel gp) {
        super(gp);
        direction="up";
        setAction();
        getNPCImages("TwoStates","coco","Enemies");
    }

}