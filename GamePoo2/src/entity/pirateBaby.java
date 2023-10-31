package entity;

import entity.attacks.attackWithBullets;
import entity.playerBuilder.CharacterBuilder;
import entity.playerBuilder.NpcBuilder;
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
        speed=3;
        setAction();
        getNPCImages();
    }

    NpcBuilder builder= new NpcBuilder();
    CharacterBuilder pirateB= new CharacterBuilder();
    public void setDefaultValues(){

        int hasKey=0;
        int speed;
        int standCounter=0;
        int life;
        int gear;
        int dmg;

       builder.constructpirateBaby(pirateB);
        worldx=gp.worldWidth/2;
        worldy=10;
        speed=pirateB.getSpeed();
       life= pirateB.getLife();
        dmg= pirateB.getDmg();
        direction="state";
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
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_standing.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NPC/NPC1/NPC2/NPC2_attacking.png")));
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
