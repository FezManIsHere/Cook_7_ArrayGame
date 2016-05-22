package arraygame;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayGame {

    public static void main(String[] args) {
        go();
    }
    
    static Random rand1 = new Random();
    static Player player;
    static Enemy e1, e2;
    static BossEnemy be1;
    static String direction;
    static boolean play = true;
    static boolean chestAlive = true;
    static boolean chestAlive1 = true;
    static String playercoords;
    static String trap1;
    static String trap2;
    static String chest;
    static String chest1;
    static Enemy[] enemies = {e1, e2};
    static BossEnemy[] bossenemies = {be1};
    static int cx = rand1.nextInt(39) + 1;
    static int cy = rand1.nextInt(39) + 1;
    static int cx1 = rand1.nextInt(39) + 1;
    static int cy1 = rand1.nextInt(39) + 1;
    static int trapx = rand1.nextInt(39) + 1;
    static int trapy = rand1.nextInt(39) + 1;
    static int trap1x = rand1.nextInt(39) + 1;
    static int trap1y = rand1.nextInt(39) + 1;
    static char[][] map = new char[41][41];

    static void game() {
        System.out.println("\n\n\n\n");
        Scanner scan = new Scanner(System.in);
        Random rand1 = new Random();
        player = new Player("Hero", 20, 20, '@', 0, 100);

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'P');
        }
        for (int i = 0; i < bossenemies.length; i++) {
            bossenemies[i] = new BossEnemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'B', 2, 100);
        }
        play = true;
        while (play) {
            map[player.x][player.y] = '@';
            map[trapx][trapy] = '*';
            map[trap1x][trap1y] = '*';
            for (Enemy enemie : enemies) {
                if (enemie.isAlive) {
                    map[enemie.x][enemie.y] = enemie.symbol;
                }
            }
            for (BossEnemy bossenemie : bossenemies) {
                if (bossenemie.isAlive) {
                    map[bossenemie.x][bossenemie.y] = bossenemie.symbol;
                }
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
                        if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'P' && map[i][j] != 'T' && map[i][j] != '#' && map[i][j] != 'B') {
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

            if (player.x > 39) {
                player.x = 1;
            } else if (player.x < 1) {
                player.x = 39;
            }
            if (player.y > 39) {
                player.y = 1;
            } else if (player.y < 1) {
                player.y = 39;
            }

            moveEnemy();

            moveBossEnemy();

            setCoords();

            checkEnemyTrap(trap1, trap2);

            checkBossEnemyTrap(trap1, trap2);

            if (playercoords.equals(chest) && chestAlive) {
                player.score += 10;
                chestAlive = false;
            }
            if (playercoords.equals(chest1) && chestAlive1) {
                player.score += 10;
                chestAlive1 = false;
            }
            if (player.score >= 20) {
                player.level = player.score / 20;
            } else {
                player.level = 1;
            }
            System.out.println("Score = " + player.score + "\n Level = " + player.level);
            if (play) {
                play = checkIfOver(playercoords, trap1, trap2, chest, chest1, player.score);
            }
            if (play) {
                play = checkEnemy(playercoords);
                if (play) {
                    play = checkBossEnemy(playercoords);
                }
            }
        }
    }

    static void go() {
        Scanner scan1 = new Scanner(System.in);
        boolean playagain = true;
        String ans;
        System.out.println("Here is a game I like to call Array Evade. \n Basically, You are being chased around by pirates (noted by P) who are out "
                + "for \n your head. However, if you get to all of the treasure (T) before they get you, you \n will win. You might also want to watch out for traps (*)");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (playagain) {
            System.out.println("me");
            game();
            System.out.println("other me");
            System.out.println("\n\n\n\n Would you like to play again?");
            ans = scan1.next().toLowerCase();
            if (ans.contains("y")) {
                System.out.println("Good Luck");
                playagain = true;
            } else {
                playagain = false;
            }
        }
    }

    static boolean checkIfOver(String b /*playercoords*/, String c/*trap1*/, String d/*trap2*/, String f/*chest*/, String j/*chest1*/, int k /*score*/) {
        if (b.equals(c) || b.equals(d)) {
            System.out.println("You jumped into a trap.");
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

    static void checkEnemyTrap(String a, String b) {
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                if (a.equals(enemie.coordinates) || b.equals(enemie.coordinates)) {
                    enemie.isAlive = false;
                    player.score += 10;
                }
            }
        }
    }

    static void checkBossEnemyTrap(String a, String b) {
        for (BossEnemy bossenemie : bossenemies) {
            if (bossenemie.isAlive) {
                if (a.equals(bossenemie.coordinates) || b.equals(bossenemie.coordinates)) {
                    if (bossenemie.health <= 50) {
                        bossenemie.isAlive = false;
                        player.score += 10;
                    } else {
                        bossenemie.health -= 50;
                    }

                }
            }
        }
    }

    static void setCoords() {
        playercoords = player.x + "," + player.y;
        trap1 = trapx + "," + trapy;
        trap2 = trap1x + "," + trap1y;
        chest = cx + "," + cy;
        chest1 = cx1 + "," + cy1;
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                enemie.coordinates = enemie.x + "," + enemie.y;
            }
        }
        for (BossEnemy bossenemie : bossenemies) {
            if (bossenemie.isAlive) {
                bossenemie.coordinates = bossenemie.x + "," + bossenemie.y;
            }
        }
    }

    static void moveEnemy() {
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                map[enemie.x][enemie.y] = '.';
                if (enemie.x < player.x) {
                    enemie.x += 1;
                } else if (enemie.x > player.x) {
                    enemie.x -= 1;
                }
                if (enemie.y < player.y) {
                    enemie.y += 1;
                } else if (enemie.y > player.y) {
                    enemie.y -= 1;
                }
            }
        }
    }
    
    static void moveBossEnemy() {
        for (BossEnemy bossenemie : bossenemies) {
            if (bossenemie.isAlive) {
                map[bossenemie.x][bossenemie.y] = '.';
                if (bossenemie.x < player.x) {
                    bossenemie.x += bossenemie.speed;
                } else if (bossenemie.x > player.x) {
                    bossenemie.x -= bossenemie.speed;
                }
                if (bossenemie.y < player.y) {
                    bossenemie.y += bossenemie.speed;
                } else if (bossenemie.y > player.y) {
                    bossenemie.y -= bossenemie.speed;
                }
            }
        }
    }

    static boolean checkEnemy(String a) {
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                if (a.equals(enemie.coordinates)) {
                    System.out.println("You got roughed up by a pirate.");
                    System.out.println("__   __            _                   \n"
                            + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                            + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                            + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                            + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean checkBossEnemy(String a) {
        for (BossEnemy bossenemie : bossenemies) {
            if (bossenemie.isAlive) {
                if (a.equals(bossenemie.coordinates)) {
                    System.out.println("You got roughed up by a pirate captain.");
                    System.out.println("__   __            _                   \n"
                            + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                            + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                            + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                            + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
                    return false;
                }
            }
        }
        return true;
    }

}
