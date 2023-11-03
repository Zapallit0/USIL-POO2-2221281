package entity.NPCBuilder;

public class Enemy {
    private String name;
    private int life;
    private int speed;
    private int Dmg;
    private String numberStates;
    public Enemy(String name,int speed, int life, int dmg, String numberStates){
        this.name=name;
        this.speed=speed;
        this.life=life;
        this.Dmg=dmg;
        this.numberStates=numberStates;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public int getSpeed(){
        return speed;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getDmg() {
        return Dmg;
    }
    public void setDmg(int dmg) {
        this.Dmg = dmg;
    }
    public String getNumberStates() {
        return numberStates;
    }
    public void setNumberStates(String numberStates) {
        this.numberStates = numberStates;
    }

}
