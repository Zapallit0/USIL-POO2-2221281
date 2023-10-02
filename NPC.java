package entity;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.KeyHandler;

public class NPC extends Player{
    private BufferedImage npcImage;
    private int x; // Posición X del NPC
    private int y; // Posición Y del NPC
    private int speed; // Velocidad de movimiento del NPC

    public NPC(int x, int y, int speed, String imagePath) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        try {
            npcImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            int newWorldX = worldx;
            int newWorldY = worldy;

            if (keyH.upPressed) {
                newWorldY -= speed;
            }
            if (keyH.downPressed) {
                newWorldY += speed;
            }
            if (keyH.leftPressed) {
                newWorldX -= speed;
            }
            if (keyH.rightPressed) {
                newWorldX += speed;
            }

            
            if (newWorldX >=2 && newWorldX <= 7 &&
                newWorldY >= 4 && newWorldY <= 9) {
                worldx = newWorldX;
                worldy = newWorldY;
            }
        }

        
        x += speed;
        if (x > 800) { 
            x = -npcImage.getWidth();
        }
    }

    public void draw(Graphics2D g2) {
        
        g2.drawImage(npcImage, x, y, null);
    }
}
