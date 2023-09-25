package Enemyy;

import java.awt.*;

public class ZombieEnemy extends Enemy {
    public ZombieEnemy(int x, int y) {
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

// De manera similar, puedes crear clases para GhostEnemy y VampireEnemy.
