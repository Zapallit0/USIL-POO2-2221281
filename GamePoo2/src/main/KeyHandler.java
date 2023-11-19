package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed,leftPressed, rightPressed, enterPressed, escPressed;
    boolean checkDrawTime =false;

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
                if(gp.ui.commandMenuNum==0){
                }
                else{
                    gp.ui.commandMenuNum--;
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                if(gp.ui.commandMenuNum==3){}
                else{
                    gp.ui.commandMenuNum++;
                }
                System.out.println(gp.ui.commandMenuNum);
            }

            if(code==KeyEvent.VK_ENTER) {
                e.consume();
                if (gp.ui.commandMenuNum == 1) {
                    gp.gameState=gp.playState;
                    gp.playMusic(2);
                }
                if (gp.ui.commandMenuNum == 2) {

                }
                if (gp.ui.commandMenuNum == 3) {
                    gp.playMusic(2);
                    gp.ui.commandMenuNum=0;
                }
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.menuState;
            }
        }
        //Play state
        if(gp.gameState==gp.playState) {
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
                gp.stopMusic();
            }
        }
        //Pause State
        if(gp.gameState== gp.pauseState){
            if (code == KeyEvent.VK_UP) {
                if(gp.ui.commandPauseNum==0){}
                else{
                    gp.ui.commandPauseNum--;
                    System.out.println(gp.ui.commandPauseNum);
                }
            }
            if (code == KeyEvent.VK_DOWN) {
                if(gp.ui.commandPauseNum==2){}
                else{
                    gp.ui.commandPauseNum++;
                    System.out.println(gp.ui.commandPauseNum);
                }
            }
            if(code==KeyEvent.VK_ENTER) {
                if (gp.ui.commandPauseNum == 0) {
                    gp.gameState=gp.playState;
                    gp.playMusic(2);
                }
                if (gp.ui.commandPauseNum == 1) {
                    gp.gameState=gp.optionsState;
                }
                if (gp.ui.commandPauseNum == 2) {
                    gp.gameState=gp.principalState;
                }
            }
        }
        if (gp.gameState==gp.optionsState){

        }

        // Dead State
        if (gp.gameState == gp.deathState) {
            if (code == KeyEvent.VK_ENTER) {
                // Reiniciar el juego o realizar acciones relacionadas con el estado de muerte.
                // Por ejemplo:
                // gp.resetGame();
                // Otras acciones...
            }
            if (code == KeyEvent.VK_ESCAPE) {
                // Volver al menú principal o realizar acciones relacionadas.
                // Por ejemplo:
                gp.gameState = gp.principalState;
                // Otras acciones...
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
    }
}
