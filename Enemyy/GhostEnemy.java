package Enemyy;

import java.awt.*;

public class GhostEnemy extends Enemy{
    public GhostEnemy(int x, int y) {
        super(x, y, 32, 32); // Tamaño y posición del zombie
        // Cargar la imagen del zombie
        // this.sprite = cargarImagen("zombie.png");
    }

    @Override
    public void mover() {
        // Implementar el comportamiento de movimiento del zombie
    }

    @Override
    public void dibujar(Graphics2D g2) {
        //dibuja el zombie en el contexto grafico
    }

}
