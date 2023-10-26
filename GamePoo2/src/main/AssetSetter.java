package main;

import entity.NPC;
import entity.pirateBaby;
import entity.skullWalker;
import object.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.obj[0]=new OBJ_Door("L");
        gp.obj[0].worldX=20*gp.tileSize;
        gp.obj[0].worldY=12*gp.tileSize;

        gp.obj[1]=new OBJ_Door("R");
        gp.obj[1].worldX=28*gp.tileSize;
        gp.obj[1].worldY=12*gp.tileSize;

        gp.obj[2]=new OBJ_Key();
        gp.obj[2].worldX=22*gp.tileSize;
        gp.obj[2].worldY=12*gp.tileSize;

        gp.obj[3]=new OBJ_Key();
        gp.obj[3].worldX=23*gp.tileSize;
        gp.obj[3].worldY=12*gp.tileSize;

        gp.obj[4]=new OBJ_Chest("L");
        gp.obj[4].worldX=5*gp.tileSize;
        gp.obj[4].worldY=12*gp.tileSize;

        gp.obj[5]=new OBJ_Chest("R");
        gp.obj[5].worldX=40*gp.tileSize;
        gp.obj[5].worldY=12*gp.tileSize;

        gp.obj[6]=new OBJ_Barrel();
        gp.obj[6].worldX=10*gp.tileSize;
        gp.obj[6].worldY=9*gp.tileSize;

        gp.obj[7]=new OBJ_GOMUGOMU();
        gp.obj[7].worldX=10*gp.tileSize;
        gp.obj[7].worldY=13*gp.tileSize;
    }
    public void setNpc(){
        gp.npcs[0]=new pirateBaby(gp);
        gp.npcs[0].worldx=10*gp.tileSize;
        gp.npcs[0].worldy=12* gp.tileSize;
        gp.npcs[1]=new skullWalker(gp);
        gp.npcs[1].worldx=10*gp.tileSize;
        gp.npcs[1].worldy=10* gp.tileSize;
    }
}
