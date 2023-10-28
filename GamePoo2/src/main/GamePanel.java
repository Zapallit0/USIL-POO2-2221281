package main;

import entity.NPC;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize=16;
    final int scale=5;

    final public int tileSize=originalTileSize*scale; //48*48
    public final int maxScreenCol=14;
    public final int getMaxScreenRow=8;
    public final int screenWidth=tileSize*maxScreenCol;// px
    public final int screenHeight=tileSize*getMaxScreenRow;//576 px

    //World settings
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;
    //FPS
    int FPS=60;
    //tilemanager
    TileManager tileM=new TileManager(this);

    KeyHandler keyH=new KeyHandler(this);
    Sound music=new Sound();
    Sound se=new Sound();
    public UI ui=new UI(this);

    //Start the clock of the game
    Thread gameThread;
    public CollisionChecker cChercker=new CollisionChecker(this);
    public AssetSetter aSetter=new AssetSetter(this);
    public Player player=new Player(this,keyH);
    public SuperObject obj[]=new SuperObject[20];
    public NPC npcs[]=new NPC[10];

    //GAME STATE
    public int gameState;
    public final int menuState=0;
    public final int playState=1;
    public final int pauseState=2;

    public final int deathState=3;

    public GamePanel() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNpc();
        playMusic(2);
        gameState=playState;
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    public void run(){
        double drawInterval=1000000000/FPS;//0.01666seconds;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while(gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime=currentTime;
            if (delta>=1) {
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    public void update() throws IOException {
        if(gameState==menuState){
            
        }
        if(gameState==playState){
            player.update();
            //NPC
            for(int i=0;i<npcs.length;i++){
                if(npcs[i]!=null){
                    npcs[i].update();
                }
            }
        }
        if(gameState==pauseState){
            //nothing
        }


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        //tile
        tileM.draw(g2);

        //Debug
        long drawStart=0;
        if (keyH.checkDrawTime == true) {
            drawStart=System.nanoTime();
        }

        //Object
        for(int i=0;i<obj.length;i++){
            if(obj[i]!=null){
                obj[i].draw(g2,this);
            }
        }
        //NPC
        for(int i=0;i<npcs.length;i++){
            if(npcs[i]!=null){
                npcs[i].draw(g2);
            }
        }
        //player
        player.draw(g2);
        ui.draw(g2);

        //Debug: en cuanto tiempo dibuja
        if(keyH.checkDrawTime==true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw time:" + passed);
        }
        g2.dispose();
    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
