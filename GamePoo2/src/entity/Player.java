package entity;
import entity.playerBuilder.CharacterBuilder;
import entity.playerBuilder.DirectorCharacter;
import main.GamePanel;
import main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    //Player Handler
    public int goldCounter;
    KeyHandler keyH;
    //Player Position
    public int screenX;
    public final int screenY;
    public int hasKey=0,standCounter=0,previousEventX,previousEventY;
    //Player Attributes
    int speed,life,maxLife,dmg;
    String gear;
    public BufferedImage playerIcon;
    boolean canTouchEvent;
    public String characterSelected="";
    DirectorCharacter director=new DirectorCharacter();
    CharacterBuilder LuffyPlayer=new CharacterBuilder();
    CharacterBuilder ZoroPlayer=new CharacterBuilder();
    int estado;


    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        setDefaultValues(characterSelected);
        solidArea=new Rectangle();
        solidArea.x=10;
        solidArea.y=40;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.height=40;
        solidArea.width=40;
        if(Objects.equals(characterSelected, "Luffy")){
            getPlayersImg(LuffyPlayer.getImgs(), estado);
            getPlayerAttackImage(LuffyPlayer.getImgs(), estado);
        }else if(Objects.equals(characterSelected, "Zoro")){
            getPlayersImg(ZoroPlayer.getImgs(), estado);
            getPlayerAttackImage(ZoroPlayer.getImgs(), estado);
        }
    }

    public void setDefaultValues(String player){
        worldx= (float) gp.worldWidth /2;
        worldy=gp.tileSize*5;
        direction="state";
        if(Objects.equals(player, "Luffy")) {
            director.constructLuffy(LuffyPlayer);
            speed=LuffyPlayer.getSpeed();
            life= LuffyPlayer.getLife();
            maxLife=10;
            dmg= LuffyPlayer.getDmg();
            estado=getGear();
            attackArea.width=60;
            attackArea.height=60;

        }
        if(Objects.equals(player, "Zoro")){
            director.constructZoro(ZoroPlayer);
            speed=ZoroPlayer.getSpeed();
            life=ZoroPlayer.getLife();
            maxLife=6;
            dmg= ZoroPlayer.getDmg();
            estado=getGear();
        }
    }

    public void setEstado() {
        if(Objects.equals(characterSelected, "Luffy")) {
            LuffyPlayer.setState("Second");
        }
        if(Objects.equals(characterSelected, "Zoro")){
            ZoroPlayer.setState("Second");
        }
    }

    public void update() throws IOException {
        if(attacking==true){
            attaking();
        }
        else if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(keyH.upPressed){
                direction="up";
            }
            if (keyH.downPressed){
                direction="down";
            }
            if (keyH.leftPressed){
                direction="left";
            }
            if(keyH.rightPressed){
                direction="right";
            }
            if(keyH.rightPressed && keyH.upPressed){
                direction="up-right";
            }
            if(keyH.leftPressed && keyH.upPressed){
                direction="up-left";
            }
            if(keyH.leftPressed && keyH.downPressed){
                direction="down-left";
            }
            if(keyH.rightPressed && keyH.downPressed){
                direction="down-right";
            }
            //Check collision
            collisionOn=false;
            gp.cChercker.checkTile(this);
            //Check obj collision
            int objIndex=gp.cChercker.checkObject(this,true);
            pickUpObject(objIndex);
            //Check Collision npc
            int npcIndex=gp.cChercker.checkEntity(this,gp.enemies);
            interactNPC(npcIndex);
            //CheckEvent
            float prevWorldX = worldx;
            float prevWorldY = worldy;
            //if collision is false, player can move
            if(!collisionOn){
                switch (direction){
                    case"up": worldy-=speed;break;
                    case "down": worldy+=speed;break;
                    case "left": worldx-=speed;break;
                    case "right": worldx+=speed;break;
                    case "up-right": worldy-=(speed-1);worldx+=(speed-1);break;
                    case "up-left": worldy-=(speed-1);worldx-=(speed-1);break;
                    case "down-left": worldy+=(speed-1);worldx-=(speed-1);break;
                    case "down-right": worldy+=(speed-1);worldx+=(speed-1);break;
                }
            }

            spriteCounter++;
            if(spriteCounter>12){
                if(spriteNum==1){
                    spriteNum=2;
                } else if (spriteNum==2) {
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }
        else{
            standCounter++;
            if(standCounter==300){
                direction="state";
                spriteNum=1;
            }
            if(standCounter==350){
                direction="state";
                spriteNum=2;
                standCounter=0;
            }
        }
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible=false;
                invincibleCounter=0;
            };
        }
    }

    private void attaking() {
        spriteCounter++;

        if(spriteCounter<=5){
            spriteNum=1;
        };
        if(spriteCounter>5&&spriteCounter<=25){
            spriteNum=2;

            //Ubicacion actual X y Y
            int currentWorldX=(int)worldx;
            int currentWorldY=(int)worldy;
            int solidAreaWidth=solidArea.width;
            int solidAreaHeight=solidArea.height;

            //Ajustando posicion para atacar

            switch(direction){
                case "up":worldy-=attackArea.height;break;
                case "down":worldy+=attackArea.height;break;
                case "left":worldx-=attackArea.width;break;
                case "right":worldx+=attackArea.width;break;
            }
            //Cambio de area solida a la area de ataque
            solidArea.width=attackArea.width;
            solidArea.height=attackArea.height;

            //colision con enemigos
            int monsterIndex=gp.cChercker.checkEntity(this,gp.enemies);
            dmgMonster(monsterIndex);
            worldx=currentWorldX;
            worldy=currentWorldY;
            solidArea.width=solidAreaWidth;
            solidArea.height=solidAreaHeight;
        }
        if(spriteCounter>25){
            spriteNum=1;
            spriteCounter=0;
            attacking=false;
        }
    }

    private void dmgMonster(int i) {
        if(i!=999){
            if(!gp.enemies[i].invincible) {
                gp.enemies[i].life =gp.enemies[i].life- gp.player.dmg;
                gp.enemies[i].invincible=true;
                if (gp.enemies[i].life <= 0) {
                    gp.enemies[i] = null;
                }
            }
        }
    }
    private void contactMonster(int i){
        if(i !=999){
            if(!invincible){
                life-=1;
                invincible=true;
            }
        }
    }

    public void pickUpObject(int i) throws IOException {
        if(i!=999){
            String objectName=gp.obj[i].name;
            switch (objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i]=null;
                    gp.playSE(3);
                    gp.ui.showMessage("You got a key");
                    break;
                case "GomuGomu":
                    if(Objects.equals(characterSelected, "Luffy")){
                            gp.obj[i] = null;
                            gp.playSE(4);
                            gp.playSE(5);
                            speed += 5;
                            dmg=+3;
                            estado++;
                            setEstado();
                            getPlayersImg(characterSelected,estado);
                        }
                        else{
                            gp.ui.showMessage("I'm not sure I want a devil fruit");
                    }
                    break;
                case "Msg":
                    gp.obj[i]=null;
                    gp.playSE(3);
                    gp.ui.showMessage(" ");
                    break;
                case "LowSpeed":
                    gp.obj[i]=null;
                    gp.ui.showMessage("Oh no , Estoy llenito D:");
                    speed=speed-2;
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.obj[i]=null;
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "ChestRight":
                    if(hasKey>0){
                        gp.obj[i].name="ChestOpen";
                        gp.obj[i].collision=false;
                        gp.ui.showMessage("Treasure");
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                        worldx=worldx-(speed*0.2F);
                    }
                    break;
                case "ChestLeft":
                    if(hasKey>0){
                        gp.obj[i].name="ChestOpen";
                        gp.obj[i].collision=false;
                        gp.ui.showMessage("Treasure");
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                        worldx=worldx+(speed*0.2F);
                    }
                    break;
                case "Boots":
                    speed+=2;
                    gp.playSE(1);
                    gp.obj[i]=null;
                    break;
                case "DoorRight":
                    if(hasKey>0){
                        hasKey--;
                        gp.obj[i]=null;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                        worldx=worldx-(speed*0.2F);
                    }
                    break;
                case  "DoorLeft":
                    if(hasKey>0){
                        hasKey--;
                        gp.obj[i]=null;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                        worldx=worldx+(speed*0.2F);
                    }
                    break;
                case "cora" :
                    moreLife(2);
                    gp.obj[i]=null;
                    break;
                case "gold":
                    goldCounter++;
                    gp.obj[i]=null;
                    break;
            }
        }
    }
    public void interactNPC(int i){
        if(gp.keyH.sPressed) {
            if (i != 999) {
                if (!invincible) {
                    invincible = true;
                    gp.eHandler.checkEvent(i);
                }
            }
            else{
                attacking=true;
            }
        }
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        if(Objects.equals(characterSelected, "Luffy")){
            LuffyPlayer.setSpeed(speed);
        }
        if(Objects.equals(characterSelected, "Zoro")){
            ZoroPlayer.setSpeed(speed);
        }
    }
    public void draw(Graphics2D g2){
        int imgWidth=gp.tileSize;
        int imgHeight=gp.tileSize;
        int tempScreenX=screenX;
        int tempScreenY=screenY;
        BufferedImage image=null;
        switch (direction){
            case "up":
                if(!attacking){
                    if(spriteNum==1){image=up1;}
                    if(spriteNum==2){image=up2;}
                }
                if(attacking){
                    tempScreenY=screenY-gp.tileSize;
                    if(spriteNum==1){image=attackUp1;imgHeight=gp.tileSize*2;}
                    if(spriteNum==2){image=attackUp2;imgHeight=gp.tileSize*2;}
                }
                break;
            case "down":
                if(!attacking){
                    if(spriteNum==1){image=down1;}
                    if(spriteNum==2){image=down2;}
                }
                if(attacking){
                    if(spriteNum==1){image=attackDown1;imgHeight=gp.tileSize*2;}
                    if(spriteNum==2){image=attackDown2;imgHeight=gp.tileSize*2;}
                }
                break;
            case "left","up-left","down-left":
                if(!attacking){
                    if(spriteNum==1){image=left1;}
                    if(spriteNum==2){image=left2;}
                }
                if(attacking){
                    tempScreenX=screenX-gp.tileSize;
                    if(spriteNum==1){image=attackLeft1; imgWidth=gp.tileSize*2;}
                    if(spriteNum==2){image=attackLeft2; imgWidth=gp.tileSize*2;}
                }
                break;
            case "right","up-right","down-right":
                if(!attacking){
                    if(spriteNum==1){image=right1;}
                    if(spriteNum==2){image=right2;}
                }
                if(attacking){
                    if(spriteNum==1){image=attackRight1;imgWidth=gp.tileSize*2;}
                    if(spriteNum==2){image=attackRight2;imgWidth=gp.tileSize*2;}
                }
                break;
            case "state":
                if(!attacking){
                    if(spriteNum==1){image=state;}
                    if(spriteNum==2){image=state2;}
                }
                break;
        }
        if(!attacking){
            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
        if(attacking){
            g2.drawImage(image,tempScreenX,tempScreenY,imgWidth,imgHeight,null);
        }
    }
    public void getPlayersImg(String name,int base) {
        if(name=="Luffy") {
            if (base == 0) {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp1.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingDown1.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingDown2.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/standingLeft.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/walkingLeft.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/standingRight.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/walkingRight.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (base == 1) {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp1.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingDown1.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingDown2.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/standingLeft.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/walkingLeft.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/standingRight.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/walkingRight.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/waiting2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(name=="Zoro") {
            if (base == 0) {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp1.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingDown1.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingDown2.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/standingLeft.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/walkingLeft.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/standingRight.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/walkingRight.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (base == 1) {
                try {
                    up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp1.png")));
                    down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingDown1.png")));
                    down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingDown2.png")));
                    left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/standingLeft.png")));
                    left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/walkingLeft.png")));
                    right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/standingRight.png")));
                    right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/walkingRight.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/waiting2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void getPlayerAttackImage(String name, int base){
        if(name=="Luffy") {
            if(base==0) {
                try {
                    attackUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up2.png")));
                    attackDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_down1.png")));
                    attackDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_down2.png")));
                    attackRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_right1.png")));
                    attackRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_right2.png")));
                    attackLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_left1.png")));
                    attackLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_left2.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting2.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(base==1) {
                try {
                    attackUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    attackLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Luffy/Attacking/attack_up1.png")));
                    state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting1.png")));
                    state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/waiting2.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        if(name=="Zoro") {
            if(base==0) {
                try {
                    attackUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                    attackLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Base/goingUp2.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(base==1) {
                try {
                    attackUp1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackUp2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackDown1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackDown2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackRight1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackRight2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                    attackLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/" + name + "/Second/goingUp2.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    public int getGear() {
        int state = 0;
        if(characterSelected=="Luffy"){
            if(LuffyPlayer.getState()=="Base"){
                state=0;
            }
            if(LuffyPlayer.getState()=="Second"){
                state=1;
            }
        }
        if(Objects.equals(characterSelected, "Zoro")){
            if(ZoroPlayer.getState()=="Base"){
                state=0;
            }
            if(ZoroPlayer.getState()=="Second"){
                state=1;
            }
        }
        return state;
    }
    public int getLife(){
        if(Objects.equals(characterSelected, "Luffy")){
            life=LuffyPlayer.getLife();
        }
        if(Objects.equals(characterSelected, "Zoro")){
            life=ZoroPlayer.getLife();
        }
        return life;
    }
    public void lessLife(int nlife){
        if(Objects.equals(characterSelected, "Luffy")){
            nlife=life-nlife;
            LuffyPlayer.setLife(nlife);
        }else if(Objects.equals(characterSelected, "Zoro")){
            nlife=life-nlife;
            ZoroPlayer.setLife(nlife);
        }
    }
    public void moreLife(int nlife){
        if(Objects.equals(characterSelected, "Luffy")){
            nlife=life+nlife;
            LuffyPlayer.setLife(nlife);
        }else if(Objects.equals(characterSelected, "Zoro")){
            nlife=life+nlife;
            ZoroPlayer.setLife(nlife);
        }
    }
    public int getMaxLife(){
        return maxLife;
    }
}
