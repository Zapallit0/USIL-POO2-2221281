package object;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperObject {
    public BufferedImage image,image2, image3;
    public String name;
    public boolean collision=false;
    public int worldX, worldY;
    public Rectangle solidArea=new Rectangle(0,0,80,80);
    public int solidAreaDefaultX=solidArea.x;
    public int solidAreaDefaultY=solidArea.y;
    UtilityTool uTool=new UtilityTool();

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX=worldX-(int)gp.player.worldx+gp.player.screenX;
        int screenY=worldY-(int)gp.player.worldy+gp.player.screenY;
        if(worldX+gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldX-gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldY+gp.tileSize>gp.player.worldy-gp.player.screenY &&
                worldY-gp.tileSize<gp.player.worldy+gp.player.screenY){

            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
    }
}
