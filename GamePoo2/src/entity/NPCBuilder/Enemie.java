package entity.NPCBuilder;

public class Enemie {
    String name;
    int life;
    int Dmg;
    String numberStates;
    public Enemie(String name, int life, int dmg,String numberStates){
        this.name=name;
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
