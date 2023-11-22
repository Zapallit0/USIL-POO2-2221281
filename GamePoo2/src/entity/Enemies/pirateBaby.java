package entity.Enemies;

import entity.attacks.Attack;
import main.GamePanel;


public class pirateBaby extends Enemies implements Attack {
    public pirateBaby(GamePanel gp) {
        super(gp);
        name="pirateBaby";
        direction="up";
        type=2;
        speed=3;
        dmg=1;
        life=10;
        setAction();
        getNPCImages("TwoStates","babyPirate","Enemies");
        stateNPC="TwoStates";
        attack();
    }

    @Override
    public void attack() {
        if(life<=5){
            speed=8;
            dmg=4;
        }
    }
}
