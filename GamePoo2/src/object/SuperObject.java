package object;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int worldX, worldY;
    public Rectangle solidArea=new Rectangle(0,0,80,80);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;
    UtilityTool uTool=new UtilityTool();

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX=worldX-gp.player.worldx+gp.player.screenX;
        int screenY=worldY-gp.player.worldy+gp.player.screenY;
        // STOP MOVING CAMERA
        if(gp.player.worldx < gp.player.screenX) {
            screenX = worldX;
        }
        if(gp.player.worldy < gp.player.screenY) {
            screenY = worldY;
        }
        int rightOffset = gp.screenWidth - gp.player.screenX;
        if(rightOffset > gp.worldWidth - gp.player.worldy) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomOffset = gp.screenHeight - gp.player.screenY;
        if(bottomOffset > gp.worldHeight - gp.player.worldy) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        if(worldX+gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldX-gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldY+gp.tileSize>gp.player.worldy-gp.player.screenY &&
                worldY-gp.tileSize<gp.player.worldy+gp.player.screenY){

            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
        // If player is around the edge, draw everything
        else if(gp.player.worldx < gp.player.screenX ||
                gp.player.worldy < gp.player.screenY ||
                rightOffset > gp.worldWidth - gp.player.worldx ||
                bottomOffset > gp.worldHeight - gp.player.worldy) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    public void setDoorOpenRight() throws IOException {
        this.image= ImageIO.read(getClass().getResourceAsStream("/Objects/RightDoorOpen.png"));
    }
    public void setDoorOpenLeft() throws IOException {
        this.image=ImageIO.read(getClass().getResourceAsStream("/Objects/LeftDoorOpen.png"));
    }
    public void setChestOpen() throws IOException{
        this.image=ImageIO.read(getClass().getResourceAsStream("/Objects/chestOpen.png"));
    }

}
