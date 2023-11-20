package entity.playerBuilder;

public class DirectorCharacter {
    public void constructLuffy(BuilderCh luffyChar){
        luffyChar.setName("Monkey D' Luffy");
        luffyChar.setSpeed(4);
        luffyChar.setLife(1);
        luffyChar.setDmg(2);
        luffyChar.setImgs("Luffy");
        luffyChar.setState("Base");
    }
    public void constructZoro(BuilderCh luffyChar){
        luffyChar.setName("Roronoa Zoro");
        luffyChar.setSpeed(3);
        luffyChar.setLife(8);
        luffyChar.setDmg(4);
        luffyChar.setImgs("Zoro");
        luffyChar.setState("Base");
    }


}
