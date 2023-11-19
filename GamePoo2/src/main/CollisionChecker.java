package main;

import entity.Entity;


public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp=gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX=(int)entity.worldx+entity.solidArea.x;
        int entityRightWorldX=(int)entity.worldx+entity.solidArea.x+entity.solidArea.width;
        int entityTopWorldY=(int)entity.worldy+entity.solidArea.y;
        int entityBottomWorldY=(int)entity.worldy+entity.solidArea.y+entity.solidArea.height;

        int entityLeftCol=entityLeftWorldX/gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/gp.tileSize;
        int entityBottomRow=entityBottomWorldY/gp.tileSize;

        int tileNum1,tileNum2;

        switch (entity.direction){
            case"up","up-right":
                entityTopRow=(int)(entityTopWorldY-entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "down","down-left":
                entityBottomRow=(int)(entityBottomWorldY+entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "left","up-left":
                entityLeftCol=(int)(entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "right","down-right":
                entityRightCol=(int)(entityRightWorldX+entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
        }
    }

    public int checkObject(Entity entity, boolean player){
        int index=999;
        for(int i=0;i<gp.obj.length;i++){
            if(gp.obj[i]!=null){
                int objSolidX = gp.obj[i].solidArea.x;
                int objSolidY = gp.obj[i].solidArea.y;

                entity.solidArea.x=(int)entity.worldx+entity.solidArea.x;
                entity.solidArea.y=(int)entity.worldy+entity.solidArea.y;

                gp.obj[i].solidArea.x=gp.obj[i].worldX+gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y=gp.obj[i].worldY+gp.obj[i].solidArea.y;

                switch (entity.direction){
                    case "up","up-right": entity.solidArea.y-=entity.speed;break;
                    case "down","down-left": entity.solidArea.y+=entity.speed;break;
                    case "left","up-left": entity.solidArea.x-=entity.speed;break;
                    case "right","down-right": entity.solidArea.x+=entity.speed;break;
                }
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision) {
                        entity.collisionOn=true;
                    }
                    if(player){
                        index=i;
                    }
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x=gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y=gp.obj[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
    //NPC collision
    public int checkEntity(Entity entity, Entity[] target){
        int index=999;
        for(int i=0;i<target.length;i++){
            if(target[i]!=null){
                //get entities solid area position
                entity.solidArea.x=(int)entity.worldx+entity.solidArea.x;
                entity.solidArea.y=(int)entity.worldy+entity.solidArea.y;
                //get the obj solid area position
                target[i].solidArea.x=(int)target[i].worldx+target[i].solidArea.x;
                target[i].solidArea.y=(int)target[i].worldy+target[i].solidArea.y;

                switch (entity.direction){
                    case "up","up-right": entity.solidArea.y+=entity.speed;break;
                    case "down","down-left": entity.solidArea.y-=entity.speed;break;
                    case "left","up-left": entity.solidArea.x+=entity.speed;break;
                    case "right","down-right": entity.solidArea.x-=entity.speed;break;
                }
                if(entity.solidArea.intersects(target[i].solidArea)){
                    if(target[i]!=entity) {
                        entity.collisionOn = true;
                        index = i;
                    }
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                target[i].solidArea.x=target[i].solidAreaDefaultX;
                target[i].solidArea.y=target[i].solidAreaDefaultY;
            }
        }
        return index;
    }
    public boolean checkPlayer(Entity entity){
        boolean contactPlayer=false;
        entity.solidArea.x=(int)entity.worldx+entity.solidArea.x;
        entity.solidArea.y=(int)entity.worldy+entity.solidArea.y;

        //get the obj solid area position
        gp.player.solidArea.x=(int)gp.player.worldx+gp.player.solidArea.x;
        gp.player.solidArea.y=(int)gp.player.worldy+gp.player.solidArea.y;
        switch (entity.direction){
            case "up","up-right": entity.solidArea.y+=entity.speed;break;
            case "down","down-left": entity.solidArea.y-=entity.speed;break;
            case "left","up-left": entity.solidArea.x+=entity.speed;break;
            case "right","down-right": entity.solidArea.x-=entity.speed;break;
        }
        if(entity.solidArea.intersects(gp.player.solidArea)){
            entity.collisionOn=true;
            contactPlayer=true;
        }
        return contactPlayer;
    }
}
