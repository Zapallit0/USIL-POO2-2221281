package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed,leftPressed, rightPressed, enterPressed, escPressed,sPressed;

    public KeyHandler(GamePanel gp){
        this.gp=gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        //Menu inicial
        if(gp.gameState==gp.menuState){
            if(code==KeyEvent.VK_ENTER){
                gp.gameState=gp.principalState;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                escPressed=true;
                System.exit(0);
            }
        }
        //Principal Menu
        if(gp.gameState== gp.principalState){
            if (code == KeyEvent.VK_UP) {
                if(gp.ui.commandNum ==0){
                }
                else{
                    gp.ui.commandNum--;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                if(gp.ui.commandNum ==3){}
                else{
                    gp.ui.commandNum++;
                }
            }
            if(code==KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {

                }
                if (gp.ui.commandNum == 1) {
                    gp.gameState=gp.charactersState;
                    gp.ui.commandNum=0;
                }
                if(gp.ui.commandNum == 2) {

                }
                if (gp.ui.commandNum == 3) {
                    gp.gameState=gp.optionsState;
                }
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.menuState;
            }
        }
        if(gp.gameState==gp.charactersState){
            if (code == KeyEvent.VK_LEFT) {
                if (gp.ui.commandNum == 0) {
                } else {
                    gp.ui.commandNum--;
                    System.out.println(gp.ui.commandNum);
                }
            }
            if (code == KeyEvent.VK_RIGHT) {
                if(gp.ui.commandNum ==3){
                }
                else{
                    System.out.println(gp.ui.commandNum);
                    gp.ui.commandNum++;
                }
            }
            if(code==KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 1) {
                    gp.gameState=gp.playState;
                }
                if (gp.ui.commandNum == 3) {
                    gp.gameState=gp.playState;

                }
            }
        }
        //Play state
        if(gp.gameState==gp.playState) {
            if(code==KeyEvent.VK_S){
                sPressed=true;
            }
            if (code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_Q) {
                    if (gp.player.direction == "up") {
                        gp.player.worldy = gp.player.worldy - (gp.player.getSpeed() * 5F);
                    }
                    if (gp.player.direction == "down") {
                        gp.player.worldy = gp.player.worldy + (gp.player.getSpeed() * 5F);
                    }
                    if (gp.player.direction == "left") {
                        gp.player.worldx = gp.player.worldx - (gp.player.getSpeed() * 5F);
                    }
                    if (gp.player.direction == "right") {
                        gp.player.worldx = gp.player.worldx + (gp.player.getSpeed() * 5F);
                    }

            }
        }
        //Pause State
        if(gp.gameState== gp.pauseState){
            if (code == KeyEvent.VK_UP) {
                if(gp.ui.commandNum ==0){}
                else{
                    gp.ui.commandNum--;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                if(gp.ui.commandNum ==2){}
                else{
                    gp.ui.commandNum++;
                }
            }
            if(code==KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    gp.gameState=gp.playState;
                    gp.playMusic(2);
                }
                if (gp.ui.commandNum == 1) {
                    gp.gameState=gp.optionsState;
                }
                if (gp.ui.commandNum == 2) {
                    gp.gameState=gp.principalState;
                }
            }
        }
        //Option State
        if(gp.gameState==gp.optionsState){
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed=true;
            }
            if (code==KeyEvent.VK_UP){
                if(gp.ui.commandNum ==0){
                }
                else{
                    gp.ui.commandNum--;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                if(gp.ui.commandNum ==3){}
                else{
                    gp.ui.commandNum++;
                }
            }
        }
        // Dead State
        if (gp.gameState == gp.deathState) {
            gp.playMusic(6);
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.principalState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            upPressed=false;
        }
        if(code==KeyEvent.VK_DOWN){
            downPressed=false;
        }
        if(code==KeyEvent.VK_LEFT){
            leftPressed=false;
        }
        if(code==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
        if(code==KeyEvent.VK_ESCAPE){
            escPressed=false;
        };
        if(code==KeyEvent.VK_ENTER){
            enterPressed=false;
        };
        if(code==KeyEvent.VK_S){
            sPressed=false;
        };

    }
}
