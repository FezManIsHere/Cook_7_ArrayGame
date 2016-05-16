/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraygame;

/**
 *
 * @author Ramborux
 */
public class BossEnemy {

    int x = 0;
    int y = 0;
    int health = 100;
    boolean isAlive;
    int experience = 0;
    char symbol = 'B';

    BossEnemy(boolean a, int b, int c, char d) {
        this.isAlive = a;
        this.x = b;
        this.y = c;
        this.symbol = d;
    }
}
