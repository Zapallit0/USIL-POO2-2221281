package entity.NPCBuilder;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class EnemyBuilder extends Entity implements BuilderEnemy {
    String name;
    int speed;
    int life;
    int Dmg;
    String numberStates;

    public EnemyBuilder(GamePanel gp) {
        super(gp);
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setLife(int num) {
        this.life=num;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setSpeed(int num) {
        this.speed=num;
    }
    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setDmg(int num) {
        this.Dmg=num;
    }

    @Override
    public int getDmg() {
        return Dmg;
    }

    @Override
    public void setStateNumber(String numberState) {
        this.numberStates=numberStates;
    }

    @Override
    public String getStateNumber() {
        return numberStates;
    }
    public void setAction(int numStates){
        if(numStates==2){
            actionCounter++;
            if(actionCounter==180) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;
                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }
                actionCounter=0;
            }
        } else if (numStates==4) {

        }
    };
    public Enemy getCharacter(){
        return new Enemy(name,speed,life,Dmg,numberStates);
    };
}
