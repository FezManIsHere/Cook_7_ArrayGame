/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraygame;

/**
 *
 * @author Geronimo
 */
public class Treasure {
    int x;
    int y;
    boolean isAlive;
    int scoreGiven;
    char symbol;
    String coordinates;
    Treasure(int a, int b, boolean c, int d, char e) {
        this.x = a;
        this.y = b;
        this.isAlive = c;
        this.scoreGiven = d;
        this.symbol = e;
    }
}
