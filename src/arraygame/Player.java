package arraygame;

/**
 *
 * @author Ramborux
 */
public class Player {//this is where I made player into an object, from a class constructor with different vairables determined in the main class 10 pts

    int x = 0;
	String name;
	int y;
	int z;
	int health = 100;
	int score = 0;
	int level = 1;
	char symbol;
        int speed;

	Player(String a, int b, int c, char d, int e, int f, int g) {
		this.x = b;
		this.y = c;
		this.name = a;
		this.symbol = d;
                this.score = e;
                this.health = f;
                this.speed = g;
	}

    }
