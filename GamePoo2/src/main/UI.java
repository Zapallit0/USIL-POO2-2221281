package main;

import object.Items.OBJ_Boots;
import object.PlayerAttributes.OBJ_Heart;
import object.Items.OBJ_Key;
import object.PlayerAttributes.PlayerIcons;
import object.SuperObject;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UI extends JPanel{
    GamePanel gp;
    Graphics2D g2;
    Font fontOPTitles =new Font("ONE PIECE",Font.PLAIN,120);
    Font fontOPSmall=new Font("ONE PIECE", Font.PLAIN,50);
    Font fontOPMedium=new Font("ONE PIECE",Font.PLAIN,60);
    OBJ_Key key=new OBJ_Key();
    BufferedImage keyImg;
    OBJ_Boots boots=new OBJ_Boots();
    BufferedImage bootsImg;

    //Icon Player
    SuperObject iconPlayer=new PlayerIcons(gp);
    BufferedImage iconPlayerBase;
    BufferedImage iconPlayerSecond;

    public boolean messageOn=false;
    public String message="";
    int messageCounter=0;
    float transparency = 0.8f;
    float transparencyText = 1.0f;
    int iconHeight=30;
    int iconWidth =30;


    public int commandNum =0;
    //Menu principal Variables
    private int newGameWidth,newGameX,newGameY;
    private int menuWidth;
    private int menuY;
    private int optionsX;
    private int optionsY;
    private int optionsWidth;
    private int gameOverY;
    private int resumeGameY;
    private int resumeGameWidth;
    private int exitX,exitY,exitWidth;

    //Colores Texto
    private final Color resumeColor = Color.BLACK;
    private final Color optionsColor = Color.BLACK;
    private final Color exitColor = Color.BLACK;
    BufferedImage menuState=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/MenuState/background.png")));
    BufferedImage principalState=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/PrincipalState/backgroundMenuPrincipal.png")));
    BufferedImage mapPauseState= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/PauseState/MapaPauseState.png")));
    BufferedImage optionState= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/PauseState/MapaPauseState.png")));
    BufferedImage mapGameOverState= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/GameOverState/GameOver.png")));
    BufferedImage characterSelector= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/GameStates/CharacterSelection/CharacterSelector.png")));
    //Player Life
    BufferedImage heart_full, heart_half, heart_blank;
    SuperObject heart=new OBJ_Heart(gp);
    int subState=0;


    public UI(GamePanel gp) throws IOException, FontFormatException {
        this.gp=gp;
        keyImg=key.image;
        bootsImg=boots.image;
        heart_full=heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;
        iconPlayerBase=iconPlayer.image;
        iconPlayerSecond=iconPlayer.image2;
    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(fontOPTitles);
        g2.setColor(Color.white);
         if(gp.gameState==gp.menuState){
            drawMenuStart(g2);
         }
         if(gp.gameState==gp.principalState){
            drawPrincipalState(g2);
         }
        if(gp.gameState==gp.charactersState){
            drawCharacterSelector();
        }
         if(gp.gameState==gp.playState){
             if(gp.player.getLife()!=0) {
                 drawPlayState(g2);
             }
             if(gp.player.getLife()<=0)
             {
                 gp.stopMusic();
                 gp.stopSE();
               gp.gameState=gp.deathState;
             }
         }
        if(gp.gameState==gp.deathState){
            drawGameOverState(g2);
        }
         if (gp.gameState==gp.pauseState){
            drawPauseState(g2);
         }
         if(gp.gameState==gp.optionsState){
             drawOptionsState(g2);
         }
    }

    private void drawGameOverState(Graphics2D g2) {
        g2.setFont(fontOPMedium);
        drawRectangle(g2,0,0,gp.screenWidth,gp.screenHeight,0.7f);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawImage(mapGameOverState,250,50,600,550,null);
        g2.setColor(Color.BLACK);
        String gameOver = "GAME OVER";
        int gameOverX = 400;
        gameOverY = 400;
        g2.drawString(gameOver, gameOverX, gameOverY);
    }
    public void drawMenuStart(Graphics2D g2){
        g2.drawImage(menuState,0,-50,gp.screenWidth,gp.screenHeight+100,null);
        String tituloMenu="THE BINDING OF LUFFY";
        int tituloMenuWidth=g2.getFontMetrics().stringWidth(tituloMenu);
        int tituloMenuX = (gp.screenWidth - tituloMenuWidth) / 2;
        int tituloMenuY = 200;
        g2.drawString(tituloMenu, tituloMenuX, tituloMenuY);
        setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String playButton = "Play";
        int playButtonWidth = g2.getFontMetrics().stringWidth(playButton);
        int playButtonX = (gp.screenWidth - playButtonWidth) / 2;
        int playButtonY = 350;
        g2.drawString(playButton, playButtonX, playButtonY);
    }
    public void drawPlayState(Graphics2D g2){
        commandNum=0;
        drawPlayerLife();
        drawRecStats(g2);
        g2.setFont(fontOPSmall);
        g2.setColor(Color.WHITE);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawString("  ="+gp.player.hasKey,50,100);
        g2.drawImage(keyImg,30,70, iconWidth,iconHeight,null);
        g2.drawString("  ="+gp.player.getSpeed(),50,140);
        g2.drawImage(bootsImg,30,110,iconWidth,iconHeight,null);
        g2.drawString("  ="+gp.player.getGear(),50,175);
        if(gp.player.getGear()==0) {
            g2.drawImage(iconPlayerBase, 30, 150, iconWidth, iconHeight, null);
        }
        if(gp.player.getGear()==1) {
            g2.drawImage(iconPlayerSecond, 30, 150, iconWidth, iconHeight, null);
        }
        if(messageOn){
            g2.setFont(g2.getFont().deriveFont(32F));
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
        int y = 60;
        int width = 150;
        int height = 150;
        int arcWidth = 20;
        int arcHeight = 20;
        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(x, y, width, height, arcWidth, arcHeight);
        g.setColor(Color.GRAY);
        g.fill(roundedRect);
    }
    public void drawPauseState(Graphics2D g2){
        g2.setFont(fontOPMedium);
        drawRectangle(g2,0,0,gp.screenWidth,gp.screenHeight,0.7f);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawImage(mapPauseState,250,50,600,550,null);
        g2.setColor(Color.BLACK);

        //"Game Paused"
        String titulo = "Game Paused";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = (gp.screenWidth - tituloWidth) / 2;
        int tituloY = 200;
        g2.drawString(titulo, tituloX, tituloY);
        //"Resume"
        String resume = "Resume";
        newGameWidth = g2.getFontMetrics().stringWidth(resume);
        newGameX = (gp.screenWidth - newGameWidth) / 2;
        newGameY = 300;
        g2.setColor(resumeColor);
        g2.drawString(resume, newGameX, newGameY);
        if(commandNum ==0){
            g2.drawString(">>",newGameX-gp.tileSize,newGameY);
        }

        //"Options"
        String options = "Options";
        optionsWidth = g2.getFontMetrics().stringWidth(options);
        optionsX = (gp.screenWidth - optionsWidth) / 2;
        optionsY = 400;
        g2.setColor(optionsColor);
        g2.drawString(options, optionsX, optionsY);
        if(commandNum ==1){
            g2.drawString(">>",optionsX-gp.tileSize,optionsY);
        }

        //"Exit"
        String exit = "Exit";
        exitWidth = g2.getFontMetrics().stringWidth(exit);
        exitX = (gp.screenWidth - exitWidth) / 2;
        exitY = 500;
        g2.setColor(exitColor);
        g2.drawString(exit, exitX, exitY);
        if(commandNum ==2){
            g2.drawString(">>",exitX-gp.tileSize,exitY);
        }

    }
    public void drawOptionsState(Graphics2D g2){
        commandNum =0;
        int frameX=gp.tileSize*6;
        int frameY=gp.tileSize;
        int frameWidth=gp.tileSize*8;
        int frameHeight=gp.tileSize*10;
        g2.setFont(fontOPMedium);
        drawRectangle(g2,0,0,gp.screenWidth,gp.screenHeight,0.7f);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawImage(optionState,250,50,600,550,null);
        g2.setColor(Color.BLACK);


        switch (subState){
            case 0:
                optionsTop();
                break;
            case 1:
                break;
            case 2:
                break;
        }

    }
    public void optionsTop(){
        int textX;
        int textY;

        String text="Options";
        textX=(gp.screenWidth - menuWidth) / 2;
        textY = 200;
        g2.drawString(text,textX,textY);

        textX-=100;
        textY+=gp.tileSize;
        g2.drawString("Music",textX,textY);
        if(commandNum ==0){
            g2.drawString("->",textX-gp.tileSize,textY);
        }
        textY+=gp.tileSize;
        g2.drawString("Sound Effects",textX,textY);
        if(commandNum ==1){
            g2.drawString("->",textX-gp.tileSize,textY);
        }
        textY+=gp.tileSize;
        g2.drawString("End Game",textX,textY);
        if(commandNum ==2){
            g2.drawString("->",textX-gp.tileSize,textY);
        }
        textY+=gp.tileSize;
        g2.drawString("Back",textX,textY);
        if(commandNum ==3){
            g2.drawString("->",textX-gp.tileSize,textY);
        }
    }
    public void drawPrincipalState(Graphics2D g2){
        g2.setFont(fontOPMedium);
        drawRectangle(g2,0,0,gp.screenWidth,gp.screenHeight,0.7f);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencyText));
        g2.drawImage(principalState,0,0,gp.screenWidth,gp.screenHeight,null);
        g2.setColor(Color.WHITE);
        //"TITLE"
        String menu = "MENU";
        menuWidth = g2.getFontMetrics().stringWidth(menu);
        int menuX = (gp.screenWidth - menuWidth) / 2;
        menuY = 200;
        g2.drawString(menu, menuX, menuY);
        if(commandNum ==0){
            g2.drawString(" ",newGameX-gp.tileSize,newGameY);
        }
        //"New game"
        String newGame = "NEW GAME";
        newGameWidth = g2.getFontMetrics().stringWidth(newGame);
        newGameX = (gp.screenWidth - newGameWidth) / 2;
        newGameY = 300;
        g2.drawString(newGame, newGameX, newGameY);
        if(commandNum ==1){
            g2.drawString(">>",newGameX-gp.tileSize,newGameY);
        }

        //"Resume Game"
        String resumeGame = "RESUME GAME";
        resumeGameWidth = g2.getFontMetrics().stringWidth(resumeGame);
        int resumeGameX = (gp.screenWidth - resumeGameWidth) / 2;
        resumeGameY = 400;
        g2.drawString(resumeGame, resumeGameX, resumeGameY);
        if(commandNum ==2){
            g2.drawString(">>", resumeGameX -gp.tileSize,resumeGameY);
        }

        //"Options"
        String options = "OPTIONS";
        optionsWidth = g2.getFontMetrics().stringWidth(options);
        optionsX = (gp.screenWidth - optionsWidth) / 2;
        optionsY= 500;
        g2.drawString(options, optionsX, optionsY);

        if(commandNum ==3){
            g2.drawString(">>",optionsX-gp.tileSize,optionsY);
        }


    }

    public void drawRectangle(Graphics2D g2d, int x, int y, int width, int height, float transparencia){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencia));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
    }
    public void drawCharacterSelector(){
        g2.drawImage(characterSelector,0,-50,gp.screenWidth,gp.screenHeight+100,null);
        g2.setColor(optionsColor);
        String tituloMenu="¿A quien eliges?";
        int tituloMenuWidth=g2.getFontMetrics().stringWidth(tituloMenu);
        int tituloMenuX = (gp.screenWidth - tituloMenuWidth) / 2;
        int tituloMenuY = 200;
        g2.drawString(tituloMenu, tituloMenuX, tituloMenuY);

        String character1 = "Luffy";
        optionsX = (gp.screenWidth - tituloMenuWidth) / 2;
        optionsY = 400;
        g2.setColor(Color.RED);
        g2.drawString(character1, optionsX, optionsY);
        if(commandNum ==0){
        }
        if(commandNum ==1){
            g2.drawString(">>",optionsX-gp.tileSize,optionsY);
        }
        String character2 = "Zoro";
        optionsX = (gp.screenWidth - tituloMenuWidth) / 2;
        optionsY = 400;
        g2.setColor(Color.BLUE);

        g2.drawString(character2, optionsX+gp.tileSize*4, optionsY);
        if(commandNum ==3){
            g2.drawString(">>",optionsX+gp.tileSize*3,optionsY);
        }


    }

    public void drawPlayerLife(){
        int x=gp.tileSize/6;
        int y=5;
        int i=0;
        while(i<gp.player.getMaxLife()/2){
            g2.drawImage(heart_blank,x,y,50,50,null);
            i++;
            x+=gp.tileSize/2;
        }
        x=gp.tileSize/6;
        y=5;
        i=0;
        while(i<gp.player.getLife()){
            g2.drawImage(heart_half,x,y,50,50,null);
            i++;
            if(i<gp.player.getLife()){
                g2.drawImage(heart_full,x,y,50,50,null);
            }
            i++;
            x+=gp.tileSize/2;
        }
    }
    }



