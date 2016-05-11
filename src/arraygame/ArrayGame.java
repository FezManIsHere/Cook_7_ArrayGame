package arraygame;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayGame {

    public static void main(String[] args) {
        go();
    }

    static void game() {
        System.out.println("\n\n\n\n");
        Scanner scan = new Scanner(System.in);
        Random rand1 = new Random();
        char[][] map = new char[21][21];
        int x = 10;
        int y = 10;
        int ex = rand1.nextInt(19) + 1;
        int ey = rand1.nextInt(19) + 1;
        int ex1 = rand1.nextInt(19) + 1;
        int ey1 = rand1.nextInt(19) + 1;
        int cx = rand1.nextInt(19) + 1;
        int cy = rand1.nextInt(19) + 1;
        int cx1 = rand1.nextInt(19) + 1;
        int cy1 = rand1.nextInt(19) + 1;
        int trapx = rand1.nextInt(19) + 1;
        int trapy = rand1.nextInt(19) + 1;
        int trap1x = rand1.nextInt(19) + 1;
        int trap1y = rand1.nextInt(19) + 1;
        String direction;
        boolean play = true;
        boolean enemyAlive = true;
        boolean enemyAlive1 = true;
        boolean chestAlive = true;
        boolean chestAlive1 = true;
        int score = 0;
        String player = x + "," + y;
        String trap1 = trapx + "," + trapy;
        String trap2 = trap1x + "," + trap1y;
        String chest = cx + "," + cy;
        String chest1 = cx1 + "," + cy1;
        String enemy = ex + "," + ey;
        String enemy1 = ex1 + "," + ey1;
        while (player.equals(trap1) || player.equals(trap2) || player.equals(chest) || player.equals(enemy) || trap1.equals(trap2) || trap1.equals(chest) || trap1.equals(enemy) || trap2.equals(enemy) || trap2.equals(chest) || enemy.equals(chest) || enemy1.equals(player) || enemy1.equals(trap1) || enemy1.equals(trap2) || enemy1.equals(chest) || enemy1.equals(chest1) || enemy1.equals(enemy) || chest1.equals(player) || chest1.equals(trap1) || chest1.equals(trap2) || chest1.equals(chest) || chest1.equals(enemy)) {
            trapx = rand1.nextInt(19) + 1;
            trapy = rand1.nextInt(19) + 1;
            trap1x = rand1.nextInt(19) + 1;
            trap1y = rand1.nextInt(19) + 1;
            ex = rand1.nextInt(19) + 1;
            ey = rand1.nextInt(19) + 1;
            ex1 = rand1.nextInt(19) + 1;
            ey1 = rand1.nextInt(19) + 1;
            cx = rand1.nextInt(19) + 1;
            cy = rand1.nextInt(19) + 1;
            cx1 = rand1.nextInt(19) + 1;
            cy1 = rand1.nextInt(19) + 1;
        }
        while (play) {
            map[x][y] = '@';
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
                    if (i == 0 || j == 0 || i == 20 || j == 20) {
                        map[i][j] = '#';
                    }
                    if (j < map[1].length - 1 /*&& (j < 10 + y || j > x - 10) && (i < 10 + x || i > y - 10)*/) {
                        if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'P' && map[i][j] != 'T' && map[i][j] != '#') {
                            System.out.print(". ");
                        } else {
                            System.out.print(map[i][j] + " ");
                        }
                    } else if (map[i][j] != '@' && map[i][j] != '#'/*&& (j < 10 + y || j > x - 10) && (i < 10 + x || i > y - 10)*/) {
                        System.out.println(".");
                    } else {
                        System.out.println(map[i][j] + " ");
                    }
                }
            }
            System.out.println("Where do you want to move? (N/E/S/W/NE/NW/SE/SW) Or type Q to quit");
            direction = scan.next();
            if (direction.toUpperCase().contains("N")) {
                map[x][y] = '.';
                x -= 1;
            }
            if (direction.toUpperCase().contains("E")) {
                map[x][y] = '.';
                y += 1;
            }
            if (direction.toUpperCase().contains("S")) {
                map[x][y] = '.';
                x += 1;
            }
            if (direction.toUpperCase().contains("W")) {
                map[x][y] = '.';
                y -= 1;
            }
            if (direction.toUpperCase().contains("Q")) {
                play = false;
            }

            if (x > 19) {
                x = 1;
            } else if (x < 1) {
                x = 19;
            }
            if (y > 19) {
                y = 1;
            } else if (y < 1) {
                y = 19;
            }

            map[ex][ey] = '.';
            if (ex < x) {
                ex += 1;
            } else if (ex > x) {
                ex -= 1;
            }
            if (ey < y) {
                ey += 1;
            } else if (ey > y) {
                ey -= 1;
            }

            map[ex1][ey1] = '.';
            if (ex1 < x) {
                ex1 += 1;
            } else if (ex1 > x) {
                ex1 -= 1;
            }
            if (ey1 < y) {
                ey1 += 1;
            } else if (ey1 > y) {
                ey1 -= 1;
            }

            player = x + "," + y;
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
            if (player.equals(chest) && chestAlive) {
                score += 10;
                chestAlive = false;
            }
            if (player.equals(chest1) && chestAlive1) {
                score += 10;
                chestAlive1 = false;
            }
            System.out.println("Score = " + score);
            play = checkIfOver(player, trap1, trap2, enemy, chest, enemyAlive, enemy1, enemyAlive1, chest1, score);
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

    static boolean checkIfOver(String b /*player*/, String c/*trap1*/, String d/*trap2*/, String e/*enemy*/, String f/*chest*/, boolean g/*enemyAlive*/, String h/*enemy1*/, boolean i/*enemyAlive1*/, String j/*chest1*/, int k /*score*/) {
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
