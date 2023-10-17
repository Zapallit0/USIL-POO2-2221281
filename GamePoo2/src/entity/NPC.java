package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class NPC extends  Entity{
    public int worldX, worldY;
    public int i,counter;
    public NPC(GamePanel gp) {
        super(gp);
        direction="down";
        speed=2;
        getNpcImages();
        movementNPC();
    }
    public void getNpcImages(){
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/luffygoingup2.png")));
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
    public void draw(Graphics2D g2,GamePanel gp){
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

        int screenX=worldX-gp.player.worldx+gp.player.screenX;
        int screenY=worldY-gp.player.worldy+gp.player.screenY;
        if(worldX+gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldY-gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldY+gp.tileSize>gp.player.worldy-gp.player.screenY &&
                worldY-gp.tileSize<gp.player.worldy+gp.player.screenY){

            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
    }
    public void movementNPC(){
        while(i!=70){
            if(i==60) {
                double rand = Math.random() * (600 + 1);
                if (rand >= 0 && rand <= 150) {
                    direction = "up";
                } else if (rand > 150 && rand <= 300) {
                    direction = "left";
                } else if (rand > 300 && rand <= 450) {
                    direction = "right";
                } else if (rand > 450 && rand <= 600) {
                    direction = "up";
                }
                System.out.println(rand);
            }
            i++;
        }
    }
}
