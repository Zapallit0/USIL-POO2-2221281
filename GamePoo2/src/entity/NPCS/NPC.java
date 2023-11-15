package entity.NPCS;

import entity.Entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;



public class NPC extends Entity {
    protected KeyHandler keyH;
    String stateNPC;
    public NPC(GamePanel gp) {
        super(gp);
        direction="down";
        speed=1;
        setAction();
    }
    public void getNPCImages(String State,String name){
        if(State=="TwoStates") {
            try {
                up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
                state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/secondStateAttack.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (State=="FourStates") {
            try {
                up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/up1.png")));
                up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/up2.png")));
                down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/down1.png")));
                down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/down2.png")));
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/left1.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/left2.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/right1.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/right2.png")));
                state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/standing.png")));
                state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/" + State + "/" + name + "/standing.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAction(){
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
    }

}
