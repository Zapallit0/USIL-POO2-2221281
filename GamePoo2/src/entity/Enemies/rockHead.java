package entity.Enemies;

import entity.attacks.Attack;
import main.GamePanel;

public class rockHead extends Enemies implements Attack {
    public rockHead(GamePanel gp) {
        super(gp);
        direction="up";
        type=2;
        speed=3;
        dmg=1;
        life=15;
        attack();
        getNPCImages("OneState","faceStone","Enemies");
    }
    @Override
    public void attack() {
        if(life<=10){
            setAction();
            speed=5;
            dmg=5;
            life++;
        }
    }
}
