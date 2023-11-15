package main;

import entity.NPCS.pirateBaby;
import entity.NPCS.redSpikes;
import entity.NPCS.skullWalker;
import object.*;


public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.obj[0]=new OBJ_Door("L");
        gp.obj[0].worldX=24*gp.tileSize;
        gp.obj[0].worldY=16*gp.tileSize;

        gp.obj[1]=new OBJ_Door("R");
        gp.obj[1].worldX=32*gp.tileSize;
        gp.obj[1].worldY=16*gp.tileSize;

        gp.obj[8]=new OBJ_Key();
        gp.obj[8].worldX=40*gp.tileSize;
        gp.obj[8].worldY=9*gp.tileSize;

        gp.obj[9]=new OBJ_Key();
        gp.obj[9].worldX=41*gp.tileSize;
        gp.obj[9].worldY=6*gp.tileSize;

        gp.obj[10]=new OBJ_LowSpeed();
        gp.obj[10].worldX=37*gp.tileSize;
        gp.obj[10].worldY=16*gp.tileSize;
    }
    public void setNpc(){
        gp.npcs[0]=new pirateBaby(gp);
        gp.npcs[0].worldx=10*gp.tileSize;
        gp.npcs[0].worldy=12* gp.tileSize;

        gp.npcs[1]=new skullWalker(gp);
        gp.npcs[1].worldx=10*gp.tileSize;
        gp.npcs[1].worldy=10* gp.tileSize;

        gp.npcs[2]=new redSpikes(gp);
        gp.npcs[2].worldx=25*gp.tileSize;
        gp.npcs[2].worldy=12* gp.tileSize;

        gp.npcs[3]=new redSpikes(gp);
        gp.npcs[3].worldx=25*gp.tileSize;
        gp.npcs[3].worldy=13* gp.tileSize;

        gp.npcs[4]=new redSpikes(gp);
        gp.npcs[4].worldx=25*gp.tileSize;
        gp.npcs[4].worldy=11* gp.tileSize;
    }
}
