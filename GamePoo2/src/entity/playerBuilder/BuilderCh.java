package entity.playerBuilder;

public interface BuilderCh {
    abstract void setName(String name);
    abstract String getName();
    abstract int getLife();
    abstract void setLife(int num);
    abstract int getSpeed();
    abstract void setSpeed(int num);
    abstract String getImgs();
    abstract void setImgs(String name);
    abstract void setDmg(int num);
    abstract int getDmg();
    abstract void setState(String name);
    abstract String getState();
}
