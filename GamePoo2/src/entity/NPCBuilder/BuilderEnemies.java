package entity.NPCBuilder;

public interface BuilderEnemies {
    abstract void setName(String name);
    abstract String getName();
    abstract void setLife(int num);
    abstract int getLife();
    abstract void setSpeed(int num);
    abstract int getSpeed();
    abstract void setDmg(int num);
    abstract int getDmg();
    abstract void setStateNumber(String numberState);
    abstract String getStateNumber();
}
