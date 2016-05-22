package arraygame;

/**
 *
 * @author Ramborux
 */
public class Player {

    int x = 0;
	String name;
	int y;
	int z;
	int health = 100;
	int score = 0;
	int level = 1;
	char symbol;	

	Player(String a, int b, int c, char d, int e, int f) {
		this.x = b;
		this.y = c;
		this.name = a;
		this.symbol = d;
                this.score = e;
                this.health = f;
	}

    }
