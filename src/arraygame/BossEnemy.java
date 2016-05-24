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
public class BossEnemy extends Enemy{ //Here is both my second enemy class and a sub class that extends enemy. It gives the same values but also health and a different move speed 5 pts and 7 pts
    int speed;
    int health;
    BossEnemy(boolean a, int b, int c, char d, int e, int f) {
        super(a, b, c, d);
        this.speed = e;
        this.health = f;
    }
}
