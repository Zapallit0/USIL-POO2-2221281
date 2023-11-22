package entity;

import entity.attacks.Attack;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity implements Attack{
    protected GamePanel gp;
    public float worldx;
    public float worldy;
    public float speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, state, state2;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public String direction;
    public int spriteCounter = 0, spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false, invincible = false;
    boolean attacking;
    public int actionCounter, movementCounter, widthNPC = 80, heightNPC = 80, invincibleCounter = 0, type;
    public int dmg, life;
    public String tipo;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {
    }

    public void update() throws IOException {
        setAction();
        attack();
        collisionOn = false;
        gp.cChercker.checkTile(this);
        gp.cChercker.checkObject(this, false);
        gp.cChercker.checkEntity(this, gp.enemies);
        boolean contactPlayer = gp.cChercker.checkPlayer(this);
        if (this.type == 2 && contactPlayer) {
            if (!gp.player.invincible) {
                gp.player.lessLife(dmg);
                gp.player.invincible = true;
            }
        }
        if (!collisionOn) {
            switch (direction) {
                case "up":
                    worldy -= speed;
                    break;
                case "down":
                    worldy += speed;
                    break;
                case "left":
                    worldx -= speed;
                    break;
                case "right":
                    worldx += speed;
                    break;
            }
        }
        collisionOn = false;
        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
            ;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int screenX = (int) worldx - (int) gp.player.worldx + gp.player.screenX;
        int screenY = (int) worldy - (int) gp.player.worldy + gp.player.screenY;

        if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenX &&
                worldy - gp.tileSize < gp.player.worldx + gp.player.screenX &&
                worldx + gp.tileSize > gp.player.worldy - gp.player.screenY &&
                worldy - gp.tileSize < gp.player.worldy + gp.player.screenY) {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

    @Override
    public void attack() {

    }
}
