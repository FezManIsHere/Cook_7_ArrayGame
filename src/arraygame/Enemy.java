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
public class Enemy { //here I have my enemy class with different values I utilize in my main class 5 pts

    int x = 0;
    int y = 0;
    int health = 100;
    boolean isAlive;
    int experience = 0;
    char symbol = 'P';
    String coordinates;
    Enemy(boolean a, int b, int c, char d) {
        this.isAlive = a;
        this.x = b;
        this.y = c;
        this.symbol = d;
    }
}
