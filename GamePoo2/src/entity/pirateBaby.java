package entity;

import entity.NPCBuilder.DirectorEnemies;
import entity.attacks.attackWithBullets;
import entity.playerBuilder.CharacterBuilder;
import entity.NPCBuilder.EnemieBuilder;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;



public class pirateBaby extends NPC implements attackWithBullets {
    public pirateBaby(GamePanel gp) {
        super(gp);
        direction="up";
        setAction();
        getNPCImages();
    }

    DirectorEnemies directorEnemies=new DirectorEnemies();
    EnemieBuilder pirateBB1=new EnemieBuilder(gp);
    public void setDefaultValues(){
        directorEnemies.constructpirateBaby(pirateBB1);
        speed=pirateBB1.getSpeed();
        life=
    }

    public pirateBaby(GamePanel gp,KeyHandler keyH){
        super(gp);
        final int screenX;
        final int screenY;

        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        setDefaultValues();
        solidArea=new Rectangle();
        solidArea.x=20;
        solidArea.y=40;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.height=40;
        solidArea.width=40;
        getPlayersImg(pirateB.getImgs(), pirateB.getState());
    }
    @Override
    public void getNPCImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/standing.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/TwoStates/babyPirate/attacking.png")));
        } catch (IOException e) {
            e.printStackTrace();
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
    @Override
    public void attack() {
    }
}
