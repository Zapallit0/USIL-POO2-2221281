package main;

import entity.Bosses.BabyPlum;
import entity.Enemies.*;
import object.Items.*;
import object.solidItems.OBJ_Door;


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
        gp.obj[8].worldX=45*gp.tileSize;
        gp.obj[8].worldY=9*gp.tileSize;

        gp.obj[9]=new OBJ_Key();
        gp.obj[9].worldX=41*gp.tileSize;
        gp.obj[9].worldY=6*gp.tileSize;

        gp.obj[10]=new OBJ_LowSpeed();
        gp.obj[10].worldX=37*gp.tileSize;
        gp.obj[10].worldY=16*gp.tileSize;

        gp.obj[11]=new OBJ_Message();
        gp.obj[11].worldX=28*gp.tileSize;
        gp.obj[11].worldY=6*gp.tileSize;

        gp.obj[12]=new OBJ_Gold();
        gp.obj[12].worldX=44*gp.tileSize;
        gp.obj[12].worldY=16*gp.tileSize;

        gp.obj[13]=new OBJ_GOMUGOMU();
        gp.obj[13].worldX=10*gp.tileSize;
        gp.obj[13].worldY=15*gp.tileSize;

        gp.obj[14]=new OBJ_Cora();
        gp.obj[14].worldX=25*gp.tileSize;
        gp.obj[14].worldY=20*gp.tileSize;

        gp.obj[15]=new OBJ_Gold();
        gp.obj[15].worldX=18*gp.tileSize;
        gp.obj[15].worldY=16*gp.tileSize;

        gp.obj[16]=new OBJ_Gold();
        gp.obj[16].worldX=10*gp.tileSize;
        gp.obj[16].worldY=37*gp.tileSize;

        gp.obj[17]=new OBJ_Gold();
        gp.obj[17].worldX=10*gp.tileSize;
        gp.obj[17].worldY=37*gp.tileSize;
    }
    public void setNpc(){
        gp.enemies[0]=new pirateBaby(gp);
        gp.enemies[0].worldx=10*gp.tileSize;
        gp.enemies[0].worldy=12* gp.tileSize;

        gp.enemies[1]=new skullWalker(gp);
        gp.enemies[1].worldx=15*gp.tileSize;
        gp.enemies[1].worldy=14* gp.tileSize;

        gp.enemies[2]=new redSpikes(gp,"right");
        gp.enemies[2].worldx=25*gp.tileSize;
        gp.enemies[2].worldy=11* gp.tileSize;

        gp.enemies[3]=new redSpikes(gp,"left");
        gp.enemies[3].worldx=25*gp.tileSize;
        gp.enemies[3].worldy=12* gp.tileSize;

        gp.enemies[4]=new redSpikes(gp,"right");
        gp.enemies[4].worldx=25*gp.tileSize;
        gp.enemies[4].worldy=13* gp.tileSize;

        gp.enemies[5]=new coco(gp);
        gp.enemies[5].worldx=36*gp.tileSize;
        gp.enemies[5].worldy=10* gp.tileSize;

        gp.enemies[6]=new coco(gp);
        gp.enemies[6].worldx=38*gp.tileSize;
        gp.enemies[6].worldy=10* gp.tileSize;

        gp.enemies[7]=new coco(gp);
        gp.enemies[7].worldx=20*gp.tileSize;
        gp.enemies[7].worldy=10* gp.tileSize;

        gp.enemies[8]=new coco(gp);
        gp.enemies[8].worldx=40*gp.tileSize;
        gp.enemies[8].worldy=10* gp.tileSize;

        gp.enemies[9]=new coco(gp);
        gp.enemies[9].worldx=35*gp.tileSize;
        gp.enemies[9].worldy=27* gp.tileSize;

        gp.enemies[10]=new coco(gp);
        gp.enemies[10].worldx=35*gp.tileSize;
        gp.enemies[10].worldy=29* gp.tileSize;

        gp.enemies[11]=new coco(gp);
        gp.enemies[11].worldx=35*gp.tileSize;
        gp.enemies[11].worldy=35* gp.tileSize;

        gp.enemies[12]=new redSpikes(gp,"up");
        gp.enemies[12].worldx=33*gp.tileSize;
        gp.enemies[12].worldy=20* gp.tileSize;

        gp.enemies[13]=new redSpikes(gp,"down");
        gp.enemies[13].worldx=34*gp.tileSize;
        gp.enemies[13].worldy=20* gp.tileSize;

        gp.enemies[14]=new redSpikes(gp,"up");
        gp.enemies[14].worldx=35*gp.tileSize;
        gp.enemies[14].worldy=20* gp.tileSize;

        gp.enemies[15]=new redSpikes(gp,"left");
        gp.enemies[15].worldx=25*gp.tileSize;
        gp.enemies[15].worldy=14* gp.tileSize;

        gp.enemies[16]=new redSpikes(gp,"down");
        gp.enemies[16].worldx=36*gp.tileSize;
        gp.enemies[16].worldy=20* gp.tileSize;

        gp.enemies[17]=new BabyPlum(gp);
        gp.enemies[17].worldx=10*gp.tileSize;
        gp.enemies[17].worldy=35* gp.tileSize;

        gp.enemies[18]=new pirateBaby(gp);
        gp.enemies[18].worldx=10*gp.tileSize;
        gp.enemies[18].worldy=13* gp.tileSize;

        gp.enemies[19]=new pirateBaby(gp);
        gp.enemies[19].worldx=10*gp.tileSize;
        gp.enemies[19].worldy=12* gp.tileSize;

        gp.enemies[20]=new rockHead(gp);
        gp.enemies[20].worldx=37*gp.tileSize;
        gp.enemies[20].worldy=16* gp.tileSize;

        gp.enemies[21]=new rockHead(gp);
        gp.enemies[21].worldx=37*gp.tileSize;
        gp.enemies[21].worldy=15* gp.tileSize;

        gp.enemies[22]=new rockHead(gp);
        gp.enemies[22].worldx=37*gp.tileSize;
        gp.enemies[22].worldy=14* gp.tileSize;

        gp.enemies[23]=new rockHead(gp);
        gp.enemies[23].worldx=37*gp.tileSize;
        gp.enemies[23].worldy=17* gp.tileSize;

        gp.enemies[24]=new BabyPlum(gp);
        gp.enemies[24].worldx=10*gp.tileSize;
        gp.enemies[24].worldy=37* gp.tileSize;

        gp.enemies[25]=new pirateBaby(gp);
        gp.enemies[25].worldx=15*gp.tileSize;
        gp.enemies[25].worldy=12* gp.tileSize;

        gp.enemies[26]=new rockHead(gp);
        gp.enemies[26].worldx=37*gp.tileSize;
        gp.enemies[26].worldy=18* gp.tileSize;

        gp.enemies[27]=new rockHead(gp);
        gp.enemies[27].worldx=37*gp.tileSize;
        gp.enemies[27].worldy=13* gp.tileSize;

        gp.enemies[28]=new rockHead(gp);
        gp.enemies[28].worldx=37*gp.tileSize;
        gp.enemies[28].worldy=12* gp.tileSize;
    }
}
