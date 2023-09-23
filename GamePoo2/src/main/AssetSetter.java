package main;

import object.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.obj[0]=new OBJ_Boots();
        gp.obj[0].worldX=3*gp.tileSize;
        gp.obj[0].worldY=5*gp.tileSize;

        gp.obj[1]=new OBJ_Key();
        gp.obj[1].worldX=7*gp.tileSize;
        gp.obj[1].worldY=6*gp.tileSize;

        gp.obj[2]=new OBJ_Door();
        gp.obj[2].worldX=7*gp.tileSize;
        gp.obj[2].worldY=1*gp.tileSize;

        gp.obj[3]=new OBJ_GOMUGOMU();
        gp.obj[3].worldX=10*gp.tileSize;
        gp.obj[3].worldY=5*gp.tileSize;


        /**gp.obj[1]=new OBJ_Door();
        gp.obj[1].worldX=33*gp.tileSize;
        gp.obj[1].worldY=14*gp.tileSize;

        gp.obj[2]=new OBJ_Door();
        gp.obj[2].worldX=32*gp.tileSize;
        gp.obj[2].worldY=14*gp.tileSize;

        gp.obj[3]=new OBJ_Chest();
        gp.obj[3].worldX=33*gp.tileSize;
        gp.obj[3].worldY=9*gp.tileSize;

        gp.obj[4]=new OBJ_Chest();
        gp.obj[4].worldX=32*gp.tileSize;
        gp.obj[4].worldY=9*gp.tileSize;

        gp.obj[5]=new OBJ_GOMUGOMU();
        gp.obj[5].worldX=23*gp.tileSize;
        gp.obj[5].worldY=8*gp.tileSize;
**/
    }
}
