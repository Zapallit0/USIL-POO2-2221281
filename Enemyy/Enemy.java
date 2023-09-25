package Enemyy;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy {
    protected int x, y; // Posición del enemigo
    protected int width, height; // Tamaño del enemigo
    protected BufferedImage sprite; // Imagen del enemigo

    public Enemy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        // Cargar la imagen del enemigo
        // this.sprite = cargarImagen();
    }

    // Métodos abstractos que deben implementarse en subclases
    public abstract void mover();
    public abstract void dibujar(Graphics2D g2);
}
