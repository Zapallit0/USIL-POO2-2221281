package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {
    GamePanel gp;
    public int worldx,worldy;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,state,state2;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn=false;
    public int actionCounter;

    public Entity(GamePanel gp) {
        this.gp=gp;
    }
    public void setAction(){}
    public void update() throws IOException {
        setAction();
        collisionOn=false;
        gp.cChercker.checkTile(this);
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

    public void draw(Graphics2D g2){
        BufferedImage image=null;

        int screenX=worldx-gp.player.worldx+gp.player.screenX;
        int screenY=worldy-gp.player.worldy+gp.player.screenY;
      
        if(worldx+gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldy-gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldx+gp.tileSize>gp.player.worldy-gp.player.screenY &&
                worldy-gp.tileSize<gp.player.worldy+gp.player.screenY){
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
    }
    public void getNPCImg(){}
    public void getPlayersImg(String name,String base){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/goingUp2.png")));
            up2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/goingUp1.png")));
            down1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/goingDown1.png")));
            down2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/goingDown2.png")));
            left1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/standingLeft.png")));
            left2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/walkingLeft.png")));
            right1=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/standingRight.png")));
            right2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/walkingRight.png")));
            state=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/waiting1.png")));
            state2=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/"+name+"/"+base+"/waiting2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getEnemiesImg(String name, String states){
        if(states=="TwoStates"){

        }
        else if (states=="FourStates") {
            try {
                up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/goingUp2.png")));
                up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/goingUp1.png")));
                down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/goingDown1.png")));
                down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/goingDown2.png")));
                left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/standingLeft.png")));
                left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/walkingLeft.png")));
                right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/standingRight.png")));
                right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/walkingRight.png")));
                state = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/waiting1.png")));
                state2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/" + states + "/" + name + "/waiting2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
