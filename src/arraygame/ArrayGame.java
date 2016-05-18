package arraygame;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayGame {

    public static void main(String[] args) {
        go();
    }
    
    static Player player;
    static Enemy e1, e2, e3;
    static String direction;
    static boolean play = true;
    static boolean enemyAlive = true;
    static boolean enemyAlive1 = true;
    static boolean chestAlive = true;
    static boolean chestAlive1 = true;
    static String playercoords = player.x + "," + player.y;
    static String trap1;
    static String trap2;
    static String chest;
    static String chest1;
    static String enemy;
    static String enemy1;
    static Enemy[] enemies = {e1, e2, e3};
    
    static void game() {
        System.out.println("\n\n\n\n");
        Scanner scan = new Scanner(System.in);
        Random rand1 = new Random();
        char[][] map = new char[41][41];
        player = new Player("Hero",20,20,'@', 0);
        
        
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'P');
        }
        
        
        int ex = rand1.nextInt(39) + 1;
        int ey = rand1.nextInt(39) + 1;
        int ex1 = rand1.nextInt(39) + 1;
        int ey1 = rand1.nextInt(39) + 1;
        int cx = rand1.nextInt(39) + 1;
        int cy = rand1.nextInt(39) + 1;
        int cx1 = rand1.nextInt(39) + 1;
        int cy1 = rand1.nextInt(39) + 1;
        int trapx = rand1.nextInt(39) + 1;
        int trapy = rand1.nextInt(39) + 1;
        int trap1x = rand1.nextInt(39) + 1;
        int trap1y = rand1.nextInt(39) + 1;
        while (play) {
            map[player.x][player.y] = '@';
            map[trapx][trapy] = '*';
            map[trap1x][trap1y] = '*';
            if (enemyAlive) {
                map[ex][ey] = 'P';
            }
            if (enemyAlive1) {
                map[ex1][ey1] = 'P';
            }
            if (chestAlive) {
                map[cx][cy] = 'T';
            }
            if (chestAlive1) {
                map[cx1][cy1] = 'T';
            }
            for (int i = 0; i <= map[0].length - 1; i++) {
                for (int j = 0; j <= map[1].length - 1; j++) {
                    if (i == 0 || j == 0 || i == 40 || j == 40) {
                        map[i][j] = '#';
                    }
                    if (j < map[1].length - 1 /*&& (j < 10 + player.y || j > player.x - 10) && (i < 10 + player.x || i > player.y - 10)*/) {
                        if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'P' && map[i][j] != 'T' && map[i][j] != '#') {
                            System.out.print(". ");
                        } else {
                            System.out.print(map[i][j] + " ");
                        }
                    } else if (map[i][j] != '@' && map[i][j] != '#'/*&& (j < 10 + player.y || j > player.x - 10) && (i < 10 + player.x || i > player.y - 10)*/) {
                        System.out.println(".");
                    } else {
                        System.out.println(map[i][j] + " ");
                    }
                }
            }
            System.out.println("Where do you want to move? (N/E/S/W/NE/NW/SE/SW) Or type Q to quit");
            direction = scan.next();
            if (direction.toUpperCase().contains("N")) {
                map[player.x][player.y] = '.';
                player.x -= 1;
            }
            if (direction.toUpperCase().contains("E")) {
                map[player.x][player.y] = '.';
                player.y += 1;
            }
            if (direction.toUpperCase().contains("S")) {
                map[player.x][player.y] = '.';
                player.x += 1;
            }
            if (direction.toUpperCase().contains("W")) {
                map[player.x][player.y] = '.';
                player.y -= 1;
            }
            if (direction.toUpperCase().contains("Q")) {
                play = false;
            }

            if (player.x > 19) {
                player.x = 1;
            } else if (player.x < 1) {
                player.x = 19;
            }
            if (player.y > 19) {
                player.y = 1;
            } else if (player.y < 1) {
                player.y = 19;
            }

            map[ex][ey] = '.';
            if (ex < player.x) {
                ex += 1;
            } else if (ex > player.x) {
                ex -= 1;
            }
            if (ey < player.y) {
                ey += 1;
            } else if (ey > player.y) {
                ey -= 1;
            }

            map[ex1][ey1] = '.';
            if (ex1 < player.x) {
                ex1 += 1;
            } else if (ex1 > player.x) {
                ex1 -= 1;
            }
            if (ey1 < player.y) {
                ey1 += 1;
            } else if (ey1 > player.y) {
                ey1 -= 1;
            }

            playercoords = player.x + "," + player.y;
            trap1 = trapx + "," + trapy;
            trap2 = trap1x + "," + trap1y;
            chest = cx + "," + cy;
            chest1 = cx1 + "," + cy1;
            enemy1 = ex1 + "," + ey1;
            enemy = ex + "," + ey;

            if (enemy.equals(trap1) || enemy.equals(trap2)) {
                enemyAlive = false;
            }
            if (enemy1.equals(trap1) || enemy1.equals(trap2)) {
                enemyAlive1 = false;
            }
            if (playercoords.equals(chest) && chestAlive) {
                player.score += 10;
                chestAlive = false;
            }
            if (playercoords.equals(chest1) && chestAlive1) {
                player.score += 10;
                chestAlive1 = false;
            }
            System.out.println("Score = " + player.score);
            if (play) {
            play = checkIfOver(playercoords, trap1, trap2, enemy, chest, enemyAlive, enemy1, enemyAlive1, chest1, player.score);
            }
        }
    }

    static void go() {
        Scanner scan1 = new Scanner(System.in);
        boolean playagain = true;
        String ans;
        System.out.println("Here is a game I like to call Array Evade. \n Basically, You are being chased around by pirates (noted by P) who are out for \n your head. However, if you get to all of the treasure (T) before they get you, you \n will win. You might also want to watch out for traps (*)");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (playagain) {
            game();
            System.out.println("\n\n\n\n Would you like to play again?");
            ans = scan1.next().toLowerCase();
            if (ans.contains("n")) {
                playagain = false;
            } else if (!ans.contains("y")) {
                System.out.println("Good Luck");
            }
        }
    }

    static boolean checkIfOver(String b /*playercoords*/, String c/*trap1*/, String d/*trap2*/, String e/*enemy*/, String f/*chest*/, boolean g/*enemyAlive*/, String h/*enemy1*/, boolean i/*enemyAlive1*/, String j/*chest1*/, int k /*score*/) {
        if (b.equals(c) || b.equals(d)) {
            System.out.println("You jumped into a trap.");
            System.out.println("__   __            _                   \n"
                    + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            return false;
        } else if ((b.equals(e) && g) || (b.equals(h) && i)) {
            System.out.println("You got roughed up by a pirate.");
            System.out.println("__   __            _                   \n"
                    + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            return false;
        } else if (k == 20) {
            System.out.println("You win. Congratulations!");
            System.out.println("__   __           __        ___       \n"
                    + "\\ \\ / /__  _   _  \\ \\      / (_)_ __  \n"
                    + " \\ V / _ \\| | | |  \\ \\ /\\ / /| | '_ \\ \n"
                    + "  | | (_) | |_| |   \\ V  V / | | | | |\n"
                    + "  |_|\\___/ \\__,_|    \\_/\\_/  |_|_| |_|\n"
                    + "                                      \n"
                    + "\n"
                    + "");
            return false;
        }
        return true;
    }

}