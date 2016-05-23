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
    static Treasure t1, t2, t3;
    static Enemy e3, e4, e5, e6;
    static BossEnemy be2, be3;
    static Walls w1, w2, w3, w4, w5, w6, w7, w8, w9;
    static String direction;
    static boolean play = true;
    static boolean chestAlive = true;
    static boolean chestAlive1 = true;
    static String playercoords;
    static String trap1;
    static String trap2;
    static Enemy[] enemies = {e1, e2};
    static Enemy[] enemies2 = {e3, e4, e5, e6};
    static BossEnemy[] bossenemies2 = {be2, be3};
    static BossEnemy[] bossenemies = {be1};
    static Treasure[] chests = {t1, t2, t3};
    static Walls[] walls = {w1, w2, w3, w4, w5, w6, w7, w8, w9};
    static int trapx;
    static int trapy;
    static int trap1x;
    static int trap1y;
    static char[][] map = new char[41][41];
    static Scanner scan = new Scanner(System.in);
    static String ans;
    static boolean playagain;
    static boolean level1Pass;
    static String nothing;

    static void level1() {
        System.out.println("\n\n\n\n");
        System.out.println(" __       ___________    ____  _______  __          __               __   __    __  .__   __.   _______  __       _______ \n" +
"|  |     |   ____\\   \\  /   / |   ____||  |        /_ |  _          |  | |  |  |  | |  \\ |  |  /  _____||  |     |   ____|\n" +
"|  |     |  |__   \\   \\/   /  |  |__   |  |         | | (_)         |  | |  |  |  | |   \\|  | |  |  __  |  |     |  |__   \n" +
"|  |     |   __|   \\      /   |   __|  |  |         | |       .--.  |  | |  |  |  | |  . `  | |  | |_ | |  |     |   __|  \n" +
"|  `----.|  |____   \\    /    |  |____ |  `----.    | |  _    |  `--'  | |  `--'  | |  |\\   | |  |__| | |  `----.|  |____ \n" +
"|_______||_______|   \\__/     |_______||_______|    |_| (_)    \\______/   \\______/  |__| \\__|  \\______| |_______||_______|");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearMap();
        player = new Player("Hero", 20, 20, '@', 0, 100, 1);
        randomize();
        play = true;
        while (play) {

            assignSymbols();

            drawMap('#');

            movePlayer();

            moveEnemy();

            moveBossEnemy();

            setCoords();

            checkEnemyTrap();

            checkBossEnemyTrap();

            checkPlayerChest();

            playerLevelCheck();

            if (play) {
                play = checkIfOver(playercoords, trap1, trap2);
            }
            if (play) {
                play = checkEnemy(playercoords);
                if (play) {
                    play = checkBossEnemy(playercoords);

                }
            }
            level1Pass = checkIfMovingOn(playercoords, trap1, trap2);
            clearMap();
        }
    }

    static void level2() {
        System.out.println("\n\n\n\n");
        System.out.println(" __       ___________    ____  _______  __          ___         .______    _______     ___       ______  __    __ \n" +
"|  |     |   ____\\   \\  /   / |   ____||  |        |__ \\   _    |   _  \\  |   ____|   /   \\     /      ||  |  |  |\n" +
"|  |     |  |__   \\   \\/   /  |  |__   |  |           ) | (_)   |  |_)  | |  |__     /  ^  \\   |  ,----'|  |__|  |\n" +
"|  |     |   __|   \\      /   |   __|  |  |          / /        |   _  <  |   __|   /  /_\\  \\  |  |     |   __   |\n" +
"|  `----.|  |____   \\    /    |  |____ |  `----.    / /_   _    |  |_)  | |  |____ /  _____  \\ |  `----.|  |  |  |\n" +
"|_______||_______|   \\__/     |_______||_______|   |____| (_)   |______/  |_______/__/     \\__\\ \\______||__|  |__|");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearMap();
        player = new Player("Hero", 20, 20, '@', 0, 100, 1);
        randomize2();
        play = true;
        while (play) {

            assignSymbols2();

            drawMap('~');

            movePlayer();

            moveEnemy2();

            moveBossEnemy2();

            setCoords2();

            checkEnemyTrap2();

            checkBossEnemyTrap2();

            checkPlayerChest();

            playerLevelCheck();

            if (play) {
                play = checkIfOver(playercoords, trap1, trap2);
            }
            if (play) {
                play = checkEnemy2(playercoords);
                if (play) {
                    play = checkBossEnemy2(playercoords);
                }
            }
        }
    }

    static void go() {
        playagain = true;
        System.out.println(".______    __  .______          ___   .___________. _______     ___________    ____  ___       _______   _______ \n" +
"|   _  \\  |  | |   _  \\        /   \\  |           ||   ____|   |   ____\\   \\  /   / /   \\     |       \\ |   ____|\n" +
"|  |_)  | |  | |  |_)  |      /  ^  \\ `---|  |----`|  |__      |  |__   \\   \\/   / /  ^  \\    |  .--.  ||  |__   \n" +
"|   ___/  |  | |      /      /  /_\\  \\    |  |     |   __|     |   __|   \\      / /  /_\\  \\   |  |  |  ||   __|  \n" +
"|  |      |  | |  |\\  \\----./  _____  \\   |  |     |  |____    |  |____   \\    / /  _____  \\  |  '--'  ||  |____ \n" +
"| _|      |__| | _| `._____/__/     \\__\\  |__|     |_______|   |_______|   \\__/ /__/     \\__\\ |_______/ |_______|");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Here is a game I like to call Array Evade. \n Basically, You are being chased around by pirates (noted by P), and Pirate Captains (C) who are out "
                + "for \n your head. However, if you get 100 points in both scenarios (jungle and beach) before they get you, you \n will win. You might also want to watch out for traps (*) \n"
                + "Pirates move once per turn. Captains move twice. Collect treasure chests (T) and trick enemies into traps to get points.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (playagain) {
            //System.out.println("me");
            level1();
            if (level1Pass) {
                //System.out.println("over here");
                level2();
            }
            //System.out.println("other me");
            playAgain();
        }
    }

    static boolean checkIfOver(String b /*playercoords*/, String c/*trap1*/, String d/*trap2*/) {
        if ((b.equals(c)) || (b.equals(d))) {
            System.out.println("You jumped into a trap.");
            System.out.println("__   __            _                   \n"
                    + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } else if (player.score >= 100 && level1Pass) {
            System.out.println("You win. Congratulations!");
            System.out.println("__   __           __        ___       \n"
                    + "\\ \\ / /__  _   _  \\ \\      / (_)_ __  \n"
                    + " \\ V / _ \\| | | |  \\ \\ /\\ / /| | '_ \\ \n"
                    + "  | | (_) | |_| |   \\ V  V / | | | | |\n"
                    + "  |_|\\___/ \\__,_|    \\_/\\_/  |_|_| |_|\n"
                    + "                                      \n"
                    + "\n"
                    + "");
            returnScore();
            return false;
        }
        return true;
    }

    static boolean checkIfMovingOn(String b, String c, String d) {
        if ((b.equals(c)) || (b.equals(d))) {
            System.out.println("You jumped into a trap.");
            System.out.println("__   __            _                   \n"
                    + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                    + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                    + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                    + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
            System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } else if (player.score >= 100) {
            System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Press any Key to go on to the second level.");
            nothing = scan.next();
            return true;
        }
        return false;
    }

    static void checkEnemyTrap() {
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                if (trap1.equals(enemie.coordinates) || trap2.equals(enemie.coordinates)) {
                    enemie.isAlive = false;
                    player.score += 10;
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    static void checkBossEnemyTrap() {
        for (BossEnemy bossenemie : bossenemies) {
            for (Treasure chestthing : chests) {
                String a = chestthing.coordinates;
                if (bossenemie.isAlive) {
                    if (a.equals(bossenemie.coordinates)) {
                        if (bossenemie.health <= 50) {
                            bossenemie.isAlive = false;
                            player.score += 10;
                            System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            bossenemie.health -= 50;
                        }

                    }
                }
            }
        }
    }

    static void setCoords() {
        playercoords = player.x + "," + player.y;
        trap1 = trapx + "," + trapy;
        trap2 = trap1x + "," + trap1y;
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
        for (Treasure chestthing : chests) {
            if (chestthing.isAlive) {
                chestthing.coordinates = chestthing.x + "," + chestthing.y;
            }
        }
    }

    static void moveEnemy() {
        for (Enemy enemie : enemies) {
            if (enemie.isAlive) {
                map[enemie.x][enemie.y] = '.';
                if (enemie.x < player.x && !checkWalls(enemie.x + 1, enemie.y)) {
                    enemie.x += 1;
                } else if (enemie.x > player.x && !checkWalls(enemie.x - 1, enemie.y)) {
                    enemie.x -= 1;
                }

                if (enemie.y < player.y && !checkWalls(enemie.x, enemie.y + 1)) {
                    enemie.y += 1;
                } else if (enemie.y > player.y && !checkWalls(enemie.x, enemie.y - 1)) {
                    enemie.y -= 1;
                }

            }
        }
    }

    static void moveBossEnemy() {
        for (BossEnemy bossenemie : bossenemies) {
            if (bossenemie.isAlive) {
                map[bossenemie.x][bossenemie.y] = '.';
                if (bossenemie.x < player.x && !checkWalls(bossenemie.x + bossenemie.speed, bossenemie.y)) {
                    bossenemie.x += bossenemie.speed;
                } else if (bossenemie.x > player.x && !checkWalls(bossenemie.x - bossenemie.speed, bossenemie.y)) {
                    bossenemie.x -= bossenemie.speed;

                }
                if (bossenemie.y < player.y && !checkWalls(bossenemie.x, bossenemie.y + bossenemie.speed)) {
                    bossenemie.y += bossenemie.speed;
                } else if (bossenemie.y > player.y && !checkWalls(bossenemie.x, bossenemie.y - bossenemie.speed)) {
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
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void randomize() {
        trapx = rand1.nextInt(39) + 1;
        trapy = rand1.nextInt(39) + 1;
        trap1x = rand1.nextInt(39) + 1;
        trap1y = rand1.nextInt(39) + 1;
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'P');
        }
        for (int i = 0; i < bossenemies.length; i++) {
            bossenemies[i] = new BossEnemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'C', 2, 100);
        }
        for (int i = 0; i < chests.length; i++) {
            chests[i] = new Treasure(rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, true, rand1.nextInt(6) + 30, 'T');
        }
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Walls(rand1.nextInt(39) + 1, rand1.nextInt(39) + 1);
        }
    }

    static void checkPlayerChest() {
        for (Treasure chestthing : chests) {
            String a = chestthing.coordinates;
            int b = chestthing.scoreGiven;
            if (playercoords.equals(a) && chestthing.isAlive) {
                player.score += b;
                chestthing.isAlive = false;
                System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static void drawMap(char a) {
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (i == 0 || j == 0 || i == 40 || j == 40) {
                    map[i][j] = a;
                } else if(i % 5 == 0 && j % 5 == 0 && map[i][j] != '@') {
                    map[i][j] = 'X';
                }
                if (j < map[1].length - 1 /*&& (j < 10 + player.y || j > player.x - 10) && (i < 10 + player.x || i > player.y - 10)*/) {
                    if (map[i][j] != player.symbol && map[i][j] != '*' && map[i][j] != 'P' && map[i][j] != 'T' && map[i][j] != a && map[i][j] != 'C' && map[i][j] != 'X') {
                        System.out.print(". ");
                    } else {
                        System.out.print(map[i][j] + " ");
                    }
                } else if (map[i][j] != player.symbol && map[i][j] != a/*&& (j < 10 + player.y || j > player.x - 10) && (i < 10 + player.x || i > player.y - 10)*/) {
                    System.out.println(".");
                } else {
                    System.out.println(map[i][j] + " ");
                }
            }
        }
    }

    static void assignSymbols() {
        map[player.x][player.y] = player.symbol;
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
        for (Treasure chestthing : chests) {
            if (chestthing.isAlive) {
                map[chestthing.x][chestthing.y] = chestthing.symbol;
            }
        }
        for (Walls wall : walls) {
            map[wall.x][wall.y] = 'X';
        }
    }

    static void playerLevelCheck() {
        if (player.score >= 20) {
            player.level = player.score / 20;
        } else {
            player.level = 1;
        }
        if (player.level == 2) {
            player.symbol = '%';
        } else if (player.level == 3) {
            player.symbol = '$';
        } else if (player.level == 4) {
            player.symbol = '^';
        } else if (player.level == 5) {
            player.symbol = '+';
        } else if (player.level >= 6) {
            player.symbol = '!';
        } else {
            player.symbol = '@';
        }
        player.speed = player.level;
    }

    static void movePlayer() {
        System.out.println("Where do you want to move? (N/E/S/W/NE/NW/SE/SW) Or type Q to quit");
        direction = scan.next();
        if (direction.toUpperCase().contains("N")) {
            map[player.x][player.y] = '.';
            if (!checkWalls(player.x - 1, player.y)) {
                player.x -= 1;
            }

        }
        if (direction.toUpperCase().contains("E")) {
            map[player.x][player.y] = '.';
            if (!checkWalls(player.x, player.y + 1)) {
                player.y += 1;
            }

        }
        if (direction.toUpperCase().contains("S")) {
            map[player.x][player.y] = '.';
            if (!checkWalls(player.x + 1, player.y)) {
                player.x += 1;
            }

        }
        if (direction.toUpperCase().contains("W")) {
            map[player.x][player.y] = '.';
            if (!checkWalls(player.x, player.y -1)) {
                player.y -= 1;
            }

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
    }

    static void playAgain() {
        System.out.println("\n\n\n\n Would you like to play again?");
        ans = scan.next().toLowerCase();
        if (ans.contains("y")) {
            System.out.println("Good Luck");
            playagain = true;
        } else {
            playagain = false;
        }
    }

    static void clearMap() {
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (i == 0 || j == 0 || i == 40 || j == 40) {
                    map[i][j] = '#';
                } else {
                    map[i][j] = '.';
                }
            }
        }
    }

    static void checkEnemyTrap2() {
        for (Enemy enemie : enemies2) {
            if (enemie.isAlive) {
                if (trap1.equals(enemie.coordinates) || trap2.equals(enemie.coordinates)) {
                    enemie.isAlive = false;
                    player.score += 10;
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    static void checkBossEnemyTrap2() {
        for (BossEnemy bossenemie : bossenemies2) {
            for (Treasure chestthing : chests) {
                String a = chestthing.coordinates;
                if (bossenemie.isAlive) {
                    if (a.equals(bossenemie.coordinates)) {
                        if (bossenemie.health <= 50) {
                            bossenemie.isAlive = false;
                            player.score += 10;
                            System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            bossenemie.health -= 50;
                        }

                    }
                }
            }
        }
    }

    static void moveEnemy2() {
        for (Enemy enemie : enemies2) {
            if (enemie.isAlive) {
                map[enemie.x][enemie.y] = '.';
                if (enemie.x < player.x && !checkWalls(enemie.x + 1, enemie.y)) {
                    enemie.x += 1;
                } else if (enemie.x > player.x && !checkWalls(enemie.x - 1, enemie.y)) {
                    enemie.x -= 1;
                }
                if (enemie.y < player.y && !checkWalls(enemie.x, enemie.y + 1)) {
                    enemie.y += 1;
                } else if (enemie.y > player.y && !checkWalls(enemie.x, enemie.y -1)) {
                    enemie.y -= 1;
                }
            }
        }
    }

    static void moveBossEnemy2() {
        for (BossEnemy bossenemie : bossenemies2) {
            if (bossenemie.isAlive) {
                map[bossenemie.x][bossenemie.y] = '.';
                if (bossenemie.x < player.x && !checkWalls(bossenemie.x + bossenemie.speed, bossenemie.y)) {
                    bossenemie.x += bossenemie.speed;
                } else if (bossenemie.x > player.x && !checkWalls(bossenemie.x - bossenemie.speed, bossenemie.y)) {
                    bossenemie.x -= bossenemie.speed;
                }
                if (bossenemie.y < player.y && !checkWalls(bossenemie.x, bossenemie.y + bossenemie.speed)) {
                    bossenemie.y += bossenemie.speed;
                } else if (bossenemie.y > player.y && !checkWalls(bossenemie.x, bossenemie.y - bossenemie.speed)) {
                    bossenemie.y -= bossenemie.speed;
                }
            }
        }
    }

    static boolean checkEnemy2(String a) {
        for (Enemy enemie : enemies2) {
            if (enemie.isAlive) {
                if (a.equals(enemie.coordinates)) {
                    System.out.println("You got roughed up by a pirate.");
                    System.out.println("__   __            _                   \n"
                            + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                            + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                            + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                            + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkBossEnemy2(String a) {
        for (BossEnemy bossenemie : bossenemies2) {
            if (bossenemie.isAlive) {
                if (a.equals(bossenemie.coordinates)) {
                    System.out.println("You got roughed up by a pirate captain.");
                    System.out.println("__   __            _                   \n"
                            + "\\ \\ / /__  _   _  | |    ___  ___  ___ \n"
                            + " \\ V / _ \\| | | | | |   / _ \\/ __|/ _ \\\n"
                            + "  | | (_) | |_| | | |__| (_) \\__ \\  __/\n"
                            + "  |_|\\___/ \\__,_| |_____\\___/|___/\\___|");
                    System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void assignSymbols2() {
        map[player.x][player.y] = player.symbol;
        map[trapx][trapy] = '*';
        map[trap1x][trap1y] = '*';

        for (Enemy enemie : enemies2) {
            if (enemie.isAlive) {
                map[enemie.x][enemie.y] = enemie.symbol;
            }
        }
        for (BossEnemy bossenemie : bossenemies2) {
            if (bossenemie.isAlive) {
                map[bossenemie.x][bossenemie.y] = bossenemie.symbol;
            }
        }
        for (Treasure chestthing : chests) {
            if (chestthing.isAlive) {
                map[chestthing.x][chestthing.y] = chestthing.symbol;
            }
        }
        for (Walls wall : walls) {
            map[wall.x][wall.y] = 'X';
        }
    }

    static void setCoords2() {
        playercoords = player.x + "," + player.y;
        trap1 = trapx + "," + trapy;
        trap2 = trap1x + "," + trap1y;
        for (Enemy enemie : enemies2) {
            if (enemie.isAlive) {
                enemie.coordinates = enemie.x + "," + enemie.y;
            }
        }
        for (BossEnemy bossenemie : bossenemies2) {
            if (bossenemie.isAlive) {
                bossenemie.coordinates = bossenemie.x + "," + bossenemie.y;
            }
        }
        for (Treasure chestthing : chests) {
            if (chestthing.isAlive) {
                chestthing.coordinates = chestthing.x + "," + chestthing.y;
            }
        }
    }

    static void randomize2() {
        trapx = rand1.nextInt(39) + 1;
        trapy = rand1.nextInt(39) + 1;
        trap1x = rand1.nextInt(39) + 1;
        trap1y = rand1.nextInt(39) + 1;
        for (int i = 0; i < enemies2.length; i++) {
            enemies2[i] = new Enemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'P');
        }
        for (int i = 0; i < bossenemies2.length; i++) {
            bossenemies2[i] = new BossEnemy(true, rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, 'C', 2, 100);
        }
        for (int i = 0; i < chests.length; i++) {
            chests[i] = new Treasure(rand1.nextInt(39) + 1, rand1.nextInt(39) + 1, true, rand1.nextInt(6) + 30, 'T');
        }
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Walls(rand1.nextInt(39) + 1, rand1.nextInt(39) + 1);
        }
    }

    static void returnScore() {
        System.out.println("Score = " + player.score + "\nLevel = " + player.level + "\nYour Symbol = " + player.symbol);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArrayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static boolean checkWalls(int a, int b) {
        if (map[a][b] == 'X') {
            return true;
        }
        return false;
    }

}