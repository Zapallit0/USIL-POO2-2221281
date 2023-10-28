package entity;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey=0;
    int speed;
    int standCounter=0;
    int life;
    public int gear;
    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);

        solidArea=new Rectangle();
        solidArea.x=20;
        solidArea.y=40;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.height=40;
        solidArea.width=40;
        setDefaultValues();
        getPlayerImg(gear);
    }

    public void setDefaultValues(){
        worldx=gp.worldWidth/2;
        worldy=10;
        speed=4;
        direction="state";
        gear=1;
        life=6;
    }
    public void getPlayerImg(int gear){
        if(gear==1) {
            try {
                up1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingup2.png")));
                up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingup1.png")));
                down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingdown1.png")));
                down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingdown2.png")));
                left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffystanding.png")));
                left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffywalking.png")));
                right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standingright.png")));
                right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffywalkingright.png")));
                state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting1.png")));
                state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (gear==2){
            try {
                up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffygoingup2.png")));
                up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffygoingup1.png")));
                down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffygoingdown1.png")));
                down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffygoingdown2.png")));
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/LuffystandingLeft.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffywalkingleft.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/LuffystandingRight.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/secondGearLuffy/Luffywalkingright.png")));
                state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting1.png")));
                state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/LuffyWaiting2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() throws IOException {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
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
            int npcIndex=gp.cChercker.checkEntity(this,gp.npcs);
            interactNPC(npcIndex);

            //if collision is false, player can move
            if(!collisionOn){
                switch (direction){
                    case"up":
                        worldy-=speed;
                        break;
                    case "down":
                        worldy+=speed;
                        break;
                    case "left":
                        worldx-=speed;
                        break;
                    case "right":
                        worldx+=speed;
                        break;
                    case "up-right":
                        worldy-=(speed-1);
                        worldx+=(speed-1);
                        break;
                    case "up-left":
                        worldy-=(speed-1);
                        worldx-=(speed-1);
                        break;
                    case "down-left":
                        worldy+=(speed-1);
                        worldx-=(speed-1);
                        break;
                    case "down-right":
                        worldy+=(speed-1);
                        worldx+=(speed-1);
                        break;
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
            };
        }
        else{
            standCounter++;
            if(standCounter==300){
                direction="state";
                spriteNum=1;
            }
            if(standCounter==350){
                direction="state2";
                spriteNum=1;
                standCounter=0;
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
                    gp.obj[i]=null;
                    gp.playSE(4);
                    gp.playSE(5);
                    speed+=5;
                    gear++;
                    getPlayerImg(gear);
                    break;


                case "LowSpeed":
                    gp.obj[i]=null;
                    gp.playSE(4);
                    gp.playSE(5);
                   // gp.player.speed--;
                    speed--;
                    break;
//gp.player getspeed --

                case "Door":
                    if(hasKey>0){
                        gp.obj[i]=null;
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "ChestRight","ChestLeft":
                    if(hasKey>0){
                        gp.obj[i].name="ChestOpen";
                        gp.obj[i].collision=false;
                        gp.obj[i].setChestOpen();
                        gp.ui.showMessage("Treasure");
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "Boots":
                    speed+=2;
                    gp.playSE(1);
                    gp.obj[i]=null;
                    break;
                case "DoorRight":
                    if(hasKey>0){
                        gp.obj[i].name="DoorOpen";
                        gp.obj[i].collision=false;
                        hasKey--;
                        gp.obj[i].setDoorOpenRight();
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "DoorLeft":
                    if(hasKey>0){
                        gp.obj[i].name="DoorOpen";
                        gp.obj[i].collision=false;
                        hasKey--;
                        gp.obj[i].setDoorOpenLeft();
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "Barrel":
                    gp.ui.showMessage("Can´t drink now");
                    gp.obj[i].collision=false;
                    break;
                case "DoorOpen":
                    break;
                case "ChestOpen":
                    break;
            }
        }
    }
    public void interactNPC(int i){
        if (i !=999){
            System.out.println("you are hitting and npc");
        }
    }
    public int getSpeed(){
        return speed;
    }
    public void draw(Graphics2D g2){
        BufferedImage image=null;
        switch (direction){
            case "up":
                if(spriteNum==1){
                    image=up1;
                }
                if(spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image=down1;
                }
                if(spriteNum==2){
                    image=down2;
                }
                break;
            case "left","up-left","down-left":
                if(spriteNum==1){
                    image=left1;
                }
                if(spriteNum==2){
                    image=left2;
                }
                break;
            case "right","up-right","down-right":
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }
                break;
            case "state":
                image=state;
                break;
            case "state2":
                image=state2;
                break;
        }

        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }

    public int getGear() {
        return gear;
    }
    public int getLife(){
        return life;
    }
}
