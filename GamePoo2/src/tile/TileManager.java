package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[19];
        mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map03.txt");
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/t2.png"));
            tile[1].collision=true;
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2].collision=true;
            tile[3]=new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            tile[4]=new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision=true;
            tile[5]=new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
            tile[6]=new Tile();
            tile[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/parketFloor2.png"));
            tile[7]=new Tile();
            tile[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/parketWood.png"));
            tile[8]=new Tile();
            tile[8].collision=false;
            tile[8].image= ImageIO.read(getClass().getResourceAsStream("/tiles/parketWall.png"));
            tile[9]=new Tile();
            tile[9].collision=false;
            tile[9].image= ImageIO.read(getClass().getResourceAsStream("/tiles/t4.png"));

            tile[10]=new Tile();
            tile[10].collision=true;
            tile[10].image= ImageIO.read(getClass().getResourceAsStream("/tiles/t3.png"));
            tile[11]=new Tile();
            tile[11].collision=true;
            tile[11].image= ImageIO.read(getClass().getResourceAsStream("/tiles/t8.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filename){
        try{
            InputStream is= getClass().getResourceAsStream(filename);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
            while(col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line= br.readLine();
                while ((line = br.readLine())!=null && row<gp.maxWorldRow) {
                    String numbers[] = line.split(" ");
                    for (col=0;col<gp.maxWorldCol;col++) {
                        mapTileNum[col][row]=Integer.parseInt(numbers[col]);
                    }
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int worldcol=0;
        int worldrow=0;

        while (worldcol<gp.maxWorldCol && worldrow<gp.maxWorldRow){
            int tileNum=mapTileNum[worldcol][worldrow];
            int worldX=worldcol*gp.tileSize;
            int worldY=worldrow*gp.tileSize;
            int screenX=worldX-gp.player.worldx+gp.player.screenX;
            int screenY=worldY-gp.player.worldy+gp.player.screenY;
            //stop moving the camera at the edge

            if(worldX+gp.tileSize>gp.player.worldx-gp.player.screenX &&
               worldX-gp.tileSize<gp.player.worldx+gp.player.screenX &&
               worldY+gp.tileSize>gp.player.worldy-gp.player.screenY &&
               worldY-gp.tileSize<gp.player.worldy+gp.player.screenY){

                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            worldcol++;

            if(worldcol==gp.maxWorldCol){
                worldcol=0;
                worldrow++;

            }
        }
    }
}
