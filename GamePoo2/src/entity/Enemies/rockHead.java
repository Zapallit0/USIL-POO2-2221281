package entity.Enemies;

import entity.attacks.Attack;
import main.GamePanel;

public class rockHead extends Enemies implements Attack {
    public rockHead(GamePanel gp) {
        super(gp);
        name="rockHead";
        direction="up";
        type=2;
        speed=0;
        dmg=1;
        life=15;
        attack();
        getNPCImages("OneState","faceStone","Enemies");
        System.out.println(speed+dmg+life);
    }
    @Override
    public void attack() {
        if(life<=10){
            setAction();
            this.speed=5;
            this.dmg=5;
            this.life++;
        }
    }
}
