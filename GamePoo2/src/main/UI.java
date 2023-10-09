package main;

import object.OBJ_Boots;
import object.OBJ_Key;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import entity.Transformations;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UI extends JPanel implements MouseListener{
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    int speed;
    OBJ_Key key=new OBJ_Key();
    BufferedImage keyImg;
    OBJ_Boots boots=new OBJ_Boots();
    BufferedImage bootsImg;
    Transformations luffyGear=new Transformations();
    BufferedImage geraImg;
    int gearNumber=1;
    public boolean messageOn=false;
    public String message="";
    int messageCounter=0;
    float transparency = 0.8f;
    float transparencyText = 1.0f;
    int iconHeight=30;
    int iconWidth =30;

    //Texto variables
    private int resumeX;
    private int resumeY;
    private int resumeWidth;
    private int optionsX;
    private int optionsY;
    private int optionsWidth;
    private int exitX;
    private int exitY;
    private int exitWidth;
    private int fontSizeMenu = 36;

    //Colores Texto
    private Color resumeColor = Color.BLACK;
    private Color optionsColor = Color.BLACK;
    private Color exitColor = Color.BLACK;

    BufferedImage mapPauseState= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/MapaPauseState.png")));
    public UI(GamePanel gp) throws IOException {
        this.gp=gp;
        arial_40=new Font("Arial",Font.PLAIN,30);
        keyImg=key.image;
        bootsImg=boots.image;
        geraImg=luffyGear.setGear(gearNumber);
    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        this.g2=g2;
         g2.setFont(arial_40);
         g2.setColor(Color.white);
         if(gp.gameState==gp.playState){
             drawPlayState(g2);
         }
         if (gp.gameState==gp.pauseState){
            drawPauseState(g2);
         }
    }
    public void drawPlayState(Graphics2D g2){
        drawRecStats(g2);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("  ="+gp.player.hasKey,40,50);
        g2.drawImage(keyImg,20,20, iconWidth,iconHeight,null);
        g2.drawString("  ="+gp.player.getSpeed(),40,90);
        g2.drawImage(bootsImg,20,60,iconWidth,iconHeight,null);
        g2.drawString("  ="+gp.player.getGear(),40,125);
        g2.drawImage(geraImg,20,100,iconWidth,iconHeight,null);
        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(20F));
            g2.drawString(message,gp.tileSize/2,gp.tileSize*5);
            messageCounter++;
            if(messageCounter>120){
                messageCounter=0;
                messageOn=false;
            }
        }
    }

    public void drawRecStats(Graphics2D g){
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
        int x = 10;
        int y = 10;
        int width = 150;
        int height = 150;
        int arcWidth = 20;
        int arcHeight = 20;
        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(x, y, width, height, arcWidth, arcHeight);
        g.setColor(Color.GRAY);
        g.fill(roundedRect);
    }

    public void drawPauseState(Graphics2D g2){
        drawRectangle(g2,0,0,gp.screenWidth,gp.screenHeight,0.7f);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawImage(mapPauseState,250,50,600,550,null);
        g2.setFont(new Font("Arial", Font.BOLD, 36));
        g2.setColor(Color.BLACK);

        //"Game Paused"
        String titulo = "Game Paused";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = (gp.screenWidth - tituloWidth) / 2;
        int tituloY = 200;
        g2.drawString(titulo, tituloX, tituloY);
        //"Resume"
        String resume = "Resume";
        resumeWidth = g2.getFontMetrics().stringWidth(resume);
        resumeX = (gp.screenWidth - resumeWidth) / 2;
        int resumeY = 300;
        g2.setColor(resumeColor);
        g2.drawString(resume, resumeX, resumeY);

        //"Options"
        String options = "Options";
        optionsWidth = g2.getFontMetrics().stringWidth(options);
        optionsX = (gp.screenWidth - optionsWidth) / 2;
        optionsY = 400;
        g2.setColor(optionsColor);
        g2.drawString(options, optionsX, optionsY);

        //"Exit"
        String exit = "Exit";
        exitWidth = g2.getFontMetrics().stringWidth(exit);
        exitX = (gp.screenWidth - exitWidth) / 2;
        exitY = 500;
        g2.setColor(exitColor);
        g2.drawString(exit, exitX, exitY);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Comprueba si se hizo clic en el área del texto "Exit"
        if (mouseX > exitX && mouseX < exitX + exitWidth &&
                mouseY > exitY - fontSizeMenu && mouseY < exitY) {
            // Cerrar la aplicación
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX > resumeX && mouseX < resumeX + resumeWidth &&
                mouseY > resumeY - fontSizeMenu && mouseY < resumeY) {
                resumeColor = Color.YELLOW;
        } else if (mouseX > optionsX && mouseX < optionsX + optionsWidth &&
                mouseY > optionsY - fontSizeMenu && mouseY < optionsY) {
                optionsColor = Color.YELLOW;
        } else if (mouseX > exitX && mouseX < exitX + exitWidth &&
                mouseY > exitY - fontSizeMenu && mouseY < exitY) {
                exitColor = Color.YELLOW;
        }

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void drawRectangle(Graphics2D g2d, int x, int y, int width, int height, float transparencia){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencia));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
    }
}
