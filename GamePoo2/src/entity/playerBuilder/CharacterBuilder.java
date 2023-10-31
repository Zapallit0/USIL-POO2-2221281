package entity.playerBuilder;

public class CharacterBuilder implements BuilderCh{
    String name;
    int speed;
    int life;
    String state;
    String nameImg;
    int damage;
    @Override
    public void setName(String realName){
        this.name=realName;
    };
    @Override
    public String getName(){
        return name;
    };
    @Override
    public int getLife() {
        return this.life;
    }
    @Override
    public void setLife(int baseLife) {
        this.life=baseLife;
    }
    @Override
    public int getSpeed() {
        return this.speed;
    }
    @Override
    public void setSpeed(int baseSpeed) {
        this.speed=baseSpeed;
    }
    @Override
    public void setImgs(String packName) {
        this.nameImg=packName;
    }
    @Override
    public String getImgs(){return this.nameImg;};
    @Override
    public void setDmg(int baseDmg) {
        this.damage=baseDmg;
    }
    @Override
    public int getDmg(){
        return this.damage;
    };
    @Override
    public void setState(String playerState){
        this.state=playerState;
    };
    @Override
    public String getState(){
        return state;
    };
    public Character getCharacter(){
        return new Character(name, speed ,life,damage,nameImg,state);
    };
}
