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
public class BossEnemy extends Enemy{
    int speed;
    int health;
    BossEnemy(boolean a, int b, int c, char d, int e, int f) {
        super(a, b, c, d);
        this.speed = e;
        this.health = f;
    }
}
