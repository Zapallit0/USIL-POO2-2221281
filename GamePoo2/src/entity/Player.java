package entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey=0;
    public int keyChest=0;
    int speed;
    int standCounter=0;

    public Player(GamePanel gp,KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);

        solidArea=new Rectangle();
        solidArea.x=20;
        solidArea.y=40;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.height=40;
        solidArea.width=20;

        setDefaultValues();
        getPlayerImg();
    }

    public void setDefaultValues(){
        worldx=gp.worldWidth/2;
        worldy=gp.worldHeight/2;
        speed=5;
        direction="state";
    }
    public void getPlayerImg(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/player/luffygoingup2.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player/luffygoingup1.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/player/luffygoingdown1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player/luffygoingdown2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/player/luffystanding.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/player/luffywalking.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/player/standingright.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/player/luffywalkingright.png"));
            state=ImageIO.read(getClass().getResourceAsStream("/player/Luffy04-5.png.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true){
            if(keyH.upPressed==true){
                direction="up";
            }
            if (keyH.downPressed==true){
                direction="down";
            }
            if (keyH.leftPressed==true){
                direction="left";
            }
            if(keyH.rightPressed==true){
                direction="right";
            }
            if(keyH.rightPressed==true && keyH.upPressed==true ){
                direction="up-right";
            }
            if(keyH.leftPressed==true && keyH.upPressed==true ){
                direction="up-left";
            }
            if(keyH.leftPressed==true && keyH.downPressed==true ){
                direction="down-left";
            }
            if(keyH.rightPressed==true && keyH.downPressed==true ){
                direction="down-right";
            }

            //Check collision
            collisionOn=false;
            gp.cChercker.checkTile(this);

            //Check obj collision
            int objIndex=gp.cChercker.checkObject(this,true);
            pickUpObject(objIndex);
            //if collision is false, player can move
            if(collisionOn==false){
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
            if(spriteCounter>15){
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
            if(standCounter==60){
                direction="state";
                spriteNum=1;
                standCounter=0;
            }
        }
    }
    public void pickUpObject(int i){
        if(i!=999){
            String objectName=gp.obj[i].name;
            switch (objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i]=null;
                    gp.ui.showMessage("You got a key");
                    break;
                case "GomuGomu":
                    gp.obj[i]=null;
                    gp.ui.showMessage("Demon fruit?");
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
                case "Chest":
                    if(keyChest>0){
                        gp.ui.showMessage("Treasure");
                        keyChest--;
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
            }
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
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }

}
