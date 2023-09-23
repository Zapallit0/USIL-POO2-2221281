package main;

import object.OBJ_Boots;
import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_40;
    int speed;
    BufferedImage keyImg;
    BufferedImage bootsImg;
    public boolean messageOn=false;
    public String message="";
    int messageCounter=0;

    public UI(GamePanel gp){
        this.gp=gp;
        arial_40=new Font("Arial",Font.PLAIN,40);
        OBJ_Key key=new OBJ_Key();
        keyImg=key.image;
        OBJ_Boots boots=new OBJ_Boots();
        bootsImg=boots.image;
    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("  ="+gp.player.hasKey,23,50);
        g2.drawImage(keyImg,0,10,gp.tileSize/3,gp.tileSize/3,null);
        g2.drawString("  ="+gp.player.getSpeed(),30,110);
        g2.drawImage(bootsImg,0,70,gp.tileSize/3,gp.tileSize/3,null);
        if(messageOn==true){
            g2.setFont(g2.getFont().deriveFont(20F));
            g2.drawString(message,gp.tileSize/2,gp.tileSize*5);
            messageCounter++;
            if(messageCounter>120){
                messageCounter=0;
                messageOn=false;
            }
        }
    }
}
