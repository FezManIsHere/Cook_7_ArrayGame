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
public class Player {
    int x = 0;
	String name;
	int y = 0;
	int z = 0;
	int health = 100;
	int score = 0;
	String skill; 
        int level = 1;
	char symbol;	

	Player(String a, int b, int c, char d) {
		this.x = b;
		this.y = c;
		this.name = a;
		this.symbol = d;
	}
}
