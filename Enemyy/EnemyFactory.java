package Enemyy;
import java.util.Random;

public class EnemyFactory {
    private Random random = new Random();

    // Método para crear un enemigo aleatorio
    public Enemy crearEnemigo(int x, int y) {
        int tipo = random.nextInt(3); // Supongamos que hay 3 tipos de enemigos

        switch (tipo) {
            case 0:
                return new ZombieEnemy(x, y);
            case 1:
                return new GhostEnemy(x, y);
            case 2:
                return new VampireEnemy(x, y);
            default:
                throw new IllegalArgumentException("Tipo de enemigo no válido");
        }
    }
}
