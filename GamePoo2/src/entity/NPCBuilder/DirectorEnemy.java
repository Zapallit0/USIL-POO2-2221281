package entity.NPCBuilder;

public class DirectorEnemy {
    public void constructpirateBaby(BuilderEnemy pirateB){
        pirateB.setName("Pirate Baby");
        pirateB.setSpeed(4);
        pirateB.setLife(25);
        pirateB.setDmg(2);
        pirateB.setStateNumber("TwoStates");
    }
    public void constructRedSpikes(BuilderEnemy pirateB){
        pirateB.setName("Red Spikes");
        pirateB.setSpeed(9);
        pirateB.setLife(25);
        pirateB.setDmg(2);
        pirateB.setStateNumber("TwoStates");
    }
    public void constructSkullWalker(BuilderEnemy pirateB){
        pirateB.setName("Pirate Baby");
        pirateB.setSpeed(5);
        pirateB.setLife(100);
        pirateB.setDmg(2);
        pirateB.setStateNumber("FourStates");
    }
    public void constructBabyPlum(BuilderEnemy pirateB){
        pirateB.setName("Pirate Baby");
        pirateB.setSpeed(5);
        pirateB.setLife(100);
        pirateB.setDmg(2);
        pirateB.setStateNumber("FourStates");
    }
}
