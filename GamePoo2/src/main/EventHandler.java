package main;

public class EventHandler {
    GamePanel gp;
    EventRect[][] eventRect;
    float previusEventX;
    float previousEventY;
    boolean canTouchEvent=true;
    public EventHandler(GamePanel gp){
        this.gp=gp;
        eventRect=new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col=0;
        int row=0;
        while(col<gp.maxWorldCol && row< gp.maxWorldRow){
            eventRect[col][row]=new EventRect();
            eventRect[col][row].x=23;
            eventRect[col][row].y=23;
            eventRect[col][row].width=3;
            eventRect[col][row].height=3;
            eventRect[col][row].eventRectDefX=eventRect[col][row].x;
            eventRect[col][row].eventRectDefY=eventRect[col][row].y;
            col++;
            if(col==gp.maxWorldCol){
                col=0;
                row++;
            }
        }
    }
    public void checkEvent(){
        //check if the player is away from the last event
        int xDistance=(int)Math.abs(gp.player.worldx-previusEventX);
        int yDistance=(int)Math.abs(gp.player.worldy-previousEventY);
        int distance=Math.max(xDistance,yDistance);
        if(distance>gp.tileSize){
            canTouchEvent=true;
        }
        if(canTouchEvent){
            if(hit(27, 16, "right")){
                damagePit(27,16);
            }
        }
    }
    public void checkEvent(int i){
        if(i!=999) {
            //check if the player is away from the last event
            int xDistance =(int) Math.abs(gp.player.worldx - previusEventX);
            int yDistance = (int)Math.abs(gp.player.worldy - previousEventY);
            int distance = Math.max(xDistance, yDistance);
            if (distance > gp.tileSize) {
                canTouchEvent = true;
            }
            if (canTouchEvent) {
                String npcName = gp.enemies[i].name;
                int enemiDmg=gp.enemies[i].dmg;
                switch (npcName) {
                    case "redSpikes":
                        gp.player.lessLife(enemiDmg);
                        break;
                    case "babyPirate":
                        gp.player.lessLife(enemiDmg);
                        break;
                    case "BabyPlum":
                        gp.player.lessLife(enemiDmg);
                        break;
                    case "rockHead":
                        gp.player.lessLife(enemiDmg);
                        break;
                    case "skullWalker":
                        gp.player.lessLife(enemiDmg);
                        break;

                }
            }
        }
    }
    public boolean hit(int col, int row, String reqDirection){
        boolean hit=false;
        gp.player.solidArea.x=(int)gp.player.worldx+gp.player.solidArea.x;
        gp.player.solidArea.y=(int)gp.player.worldy+gp.player.solidArea.y;
        eventRect[col][row].x=col*gp.tileSize+eventRect[col][row].x;
        eventRect[col][row].y=row*gp.tileSize+eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone){
            if(gp.player.direction.contentEquals(reqDirection)|| reqDirection.contentEquals("any")){
                hit=true;
                previusEventX=gp.player.worldx;
                previousEventY=gp.player.worldy;
            }
        }
        gp.player.solidArea.x=gp.player.solidAreaDefaultX;
        gp.player.solidArea.y=gp.player.solidAreaDefaultY;
        eventRect[col][row].x=eventRect[col][row].eventRectDefX;
        eventRect[col][row].y=eventRect[col][row].eventRectDefY;
        return hit;
    }
    public void damagePit(int col, int row){
        gp.player.lessLife(1);
        canTouchEvent=false;
    }
}
