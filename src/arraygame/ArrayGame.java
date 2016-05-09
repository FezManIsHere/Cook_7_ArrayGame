package arraygame;
import java.util.Scanner;
import java.util.Random;
public class ArrayGame {
    public static void main(String[] args) {
        go();
    }
    
    static void game() {
        System.out.println("\n\n\n\n");
        Scanner scan = new Scanner(System.in);
        Random rand1 = new Random();
        char[][] map = new char[21][41];
        int x = 10;
        int y = 20;
        int ex = rand1.nextInt(20);
        int ey = rand1.nextInt(40);
        int cx = rand1.nextInt(20);
        int cy = rand1.nextInt(40);
        int trapx = rand1.nextInt(20);
        int trapy = rand1.nextInt(40);
        int trap1x = rand1.nextInt(20);
        int trap1y = rand1.nextInt(40);
        String direction;
        boolean play = true;
        String player = x + "," + y;
        String trap1 = trapx + "," + trapy;
        String trap2 = trap1x + "," + trap1y;
        String chest = cx + "," + cy;
        String enemy = ex + "," + ey;
        while (player.equals(trap1) || player.equals(trap2) || player.equals(chest) || player.equals(enemy) || trap1.equals(trap2) || trap1.equals(chest) || trap1.equals(enemy) || trap2.equals(enemy) || trap2.equals(chest) || enemy.equals(chest)) {
            trapx = rand1.nextInt(20);
            trapy = rand1.nextInt(40);
            trap1x = rand1.nextInt(20);
            trap1y = rand1.nextInt(40);
            ex = rand1.nextInt(20);
            ey = rand1.nextInt(40);
            cx = rand1.nextInt(20);
            cy = rand1.nextInt(40);
        }
        while (play) {
            map[x][y] = '@';
            //if(trapx < 10 + x && trapy < x + 10) {
            map[trapx][trapy] = '*';
        //}
            //if(trap1x < 10 + x && trap1y < x + 10){
            map[trap1x][trap1y] = '*';
            //}
            //if(ex < 10 + x && ey < x + 10){
            map[ex][ey] = 'E';
            //}
            //if (cx < 10 + x && cy < x + 10) {
            map[cx][cy] = 'T';
            //}
            for (int i = 0; i <= map[0].length - 1; i++) {
                for (int j = 0; j <= map[1].length - 1; j++) {
                    if (i == 0 || j == 0 || i == 20 || j == 40) {
                        map[i][j] = '█';
                    }
                    if (j < map[1].length - 1 /*&& (j < 10 + y || j > x - 10) && (i < 10 + x || i > y - 10)*/) {
                        if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'E' && map[i][j] != 'T' && map[i][j] != '█') {
                            System.out.print(".");
                        } else {
                            System.out.print(map[i][j] + "");
                        }
                    } else {
                        if (map[i][j] != '@' && map[i][j] != '█'/*&& (j < 10 + y || j > x - 10) && (i < 10 + x || i > y - 10)*/) {
                            System.out.println(".");
                        } else {
                            System.out.println(map[i][j] + "");
                        }
                    }
                }
            }
            System.out.println("Where do you want to move? (N/E/S/W/NE/NW/SE/SW) Or type Q to quit");
            direction = scan.next();
            
//            map[ex][ey] = '.';
//            map[trapx][trapy] = '.';
//            map[trap1x][trap1y] = '.';
//            map[cx][cy] = '.';
            
            if (direction.toUpperCase().contains("N")) {
                map[x][y] = '.';
                x -= 1;
//                trapx += 1;
//                trap1x += 1;
//                ex += 1;
//                cx += 1;
            }
            if (direction.toUpperCase().contains("E")) {
                map[x][y] = '.';
                y += 1;
//                trapy -= 1;
//                trap1y -= 1;
//                ey -= 1;
//                cy -= 1;
            }
            if (direction.toUpperCase().contains("S")) {
                map[x][y] = '.';
                x += 1;
//                trapx -= 1;
//                trap1x -= 1;
//                ex -= 1;
//                cx -= 1;
            }
            if (direction.toUpperCase().contains("W")) {
                map[x][y] = '.';
                y -= 1;
//                trapy += 1;
//                trap1y += 1;
//                ey += 1;
//                cy += 1;
            }
            if (direction.toUpperCase().contains("Q")) {
                play = false;
            }
            
            if (x > 19) {
                x = 0;
            } else if (x < 0) {
                x = 19;
            }
            if (y > 39) {
                y = 0;
            } else if (y < 0) {
                y = 39;
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
            
            
            
            player = x + "," + y;
            trap1 = trapx + "," + trapy;
            trap2 = trap1x + "," + trap1y;
            chest = cx + "," + cy;
            enemy = ex + "," + ey;
            if (player.equals(trap1) || player.equals(trap2)) {
                System.out.println("You jumped into a trap. GAME OVER");
                play = false;
            }else if (player.equals(enemy)) {
                System.out.println("You got roughed up by a bad dude. GAME OVER");
                play = false;
            }else if (player.equals(chest)) {
                System.out.println("You win. Congratulations!");
                play = false;
//            map[ex][ey] = '.';
//            map[trapx][trapy] = '.';
//            map[trap1x][trap1y] = '.';
//            map[cx][cy] = '.';
            }
        }
    }
    static void go() {
        Scanner scan1 = new Scanner(System.in);
        boolean playagain = true;
        String ans;
        while (playagain) {
            game();
            System.out.println("\n\n\n\n Would you like to play again?");
            ans = scan1.next().toLowerCase();
            if(ans.contains("n")) {
                playagain = false;
            } else if(!ans.contains("y")) {
                System.out.println("Good Luck");
            }
        }
    }
}