package entity.NPCBuilder;

import entity.playerBuilder.BuilderCh;

public class DirectorEnemies {
    public void constructpirateBaby(BuilderEnemies pirateB){
        pirateB.setName("Pirate Baby");
        pirateB.setSpeed(7);
        pirateB.setLife(25);
        pirateB.setDmg(2);
        pirateB.setStateNumber("TwoStates");

    }
}
