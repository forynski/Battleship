package battleship;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    char[][] grid = {{'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},
            {'~','~','~','~','~','~','~','~','~','~'},};

//char[][] grid = new char[10][10];
//char[] alphabets = "ABCDEFGHIJ".toCharArray();
//for (int i = 0; i < 10; i++) {
//        for (int j = 0; j < 10; j++) {
//            grid[i][j] = '~';
//        }
//    }

    HashMap<Integer,Character> map1 = new HashMap<>();
    {
        map1.put(0, 'A');
        map1.put(1, 'B');
        map1.put(2, 'C');
        map1.put(3, 'D');
        map1.put(4, 'E');
        map1.put(5, 'F');
        map1.put(6, 'G');
        map1.put(7, 'H');
        map1.put(8, 'I');
        map1.put(9, 'J');
    }


    HashMap<Character,Integer> map2 = new HashMap<>();
    {
        map2.put('A',0);
        map2.put('B',1);
        map2.put('C',2);
        map2.put('D',3);
        map2.put('E',4);
        map2.put('F',5);
        map2.put('G',6);
        map2.put('H',7);
        map2.put('I',8);
        map2.put('J',9);
    }


    void printGrid() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.grid.length; i++){
            System.out.print(map1.get(i));
            for (int j = 0; j < this.grid[0].length; j++){
                System.out.printf(String.valueOf(" "+ grid[i][j]));
            }
            System.out.println();
        }
    }

    void printGridWithFogOfWar() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.grid.length; i++){
            System.out.print(map1.get(i));
            for (int j = 0; j < this.grid[0].length; j++){
                if (grid[i][j] == 'O'){
                    System.out.printf(String.valueOf(" ~"));
                } else {
                    System.out.printf(String.valueOf(" " + grid[i][j]));
                }
            }
            System.out.println();
        }
    }

    void TakePosition(int length,String type) {
        Scanner scanner = new Scanner(System.in);
        boolean flag1;
        boolean flag2;
        int[][] position = new int[2][2];
        do {

            flag2 = false;
            String start ;
            String end ;

            do {
                flag1 = false;
                start = scanner.next();
                end = scanner.next();
                position[0][0] = map2.get(start.charAt(0));
                position[0][1] = Integer.parseInt(start.substring(1)) - 1;
                position[1][0] = map2.get(end.charAt(0));
                position[1][1] = Integer.parseInt(end.substring(1)) - 1;

                if (position[0][0] != position[1][0] && position[0][1] != position[1][1]) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    flag1 = true;
                    scanner.nextLine();
                } else if (Math.max(position[0][1], position[1][1]) - Math.min(position[0][1], position[1][1]) + 1 !=length&&Math.max(position[0][0], position[1][0]) - Math.min(position[0][0], position[1][0]) + 1 != length) {
                    System.out.println("Error! Wrong length of the "+type+"! Try again:");
                    flag1 = true;
                    scanner.nextLine();
                }

            } while (flag1);

            if (position[0][0] == position[1][0]) {
                for (int i = Math.min(position[0][1], position[1][1]); i < Math.max(position[0][1], position[1][1]) + 1; i++) {
                    try {
                        if (grid[position[0][0] - 1][i]== 'O' || grid[position[0][0] + 1][i]== 'O' || grid[position[0][0]][i + 1] == 'O' || grid[position[0][0]][i - 1]== 'O') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            flag2 = true;
                            scanner.nextLine();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }
            if (position[0][1] == position[1][1]) {
                for (int i = Math.min(position[0][0],position[1][0]); i < Math.max(position[0][0], position[1][0]) + 1; i++) {
                    try {
                        if (grid[i - 1][position[0][1]] == 'O'|| grid[i + 1][position[0][1]]== 'O' || grid[i][position[0][1] + 1] == 'O' || grid[i][position[0][1] - 1] == 'O') {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            flag2 = true;
                            scanner.nextLine();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }

        } while (flag2);

        if (position[0][0] == position[1][0]) {
            for (int i = Math.min(position[0][1], position[1][1]); i < Math.max(position[0][1], position[1][1]) + 1; i++) {
                grid[position[0][0]][i] = 'O';
            }
        }
        if (position[0][1] == position[1][1]) {
            for (int i = Math.min(position[0][0], position[1][0]); i < Math.max(position[0][0],position[1][0]) + 1; i++) {
                grid[i][position[0][1]] = 'O';
            }
        }

        printGrid();

    }

    void initBoard() {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        TakePosition(5,"Aircraft Carrier");
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        TakePosition(4,"Battleship");
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        TakePosition(3,"Submarine");
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        TakePosition(3,"Cruiser");
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        TakePosition(2,"Destroyer");
    }

    void start() {
        System.out.println("The game starts!");
        printGridWithFogOfWar();
        System.out.println("Take a shot!");
        Scanner scanner = new Scanner(System.in);
        boolean flag ;
        String target;
        do {
            flag = false;
            target = scanner.next();
            if (!map2.containsKey(target.charAt(0))||(Integer.parseInt(target.substring(1)) - 1 < 0 || Integer.parseInt(target.substring(1)) - 1 > 9)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                flag = true;
            }
        } while (flag);
        int[] Target = {map2.get(target.charAt(0)), Integer.parseInt(target.substring(1)) - 1};
        if (grid[Target[0]][Target[1]] == 'O') {
            grid[Target[0]][Target[1]] = 'X';
            printGridWithFogOfWar();
            System.out.println("You hit a ship!");
            printGrid();
        } else if (grid[Target[0]][Target[1]] == '~'){
            grid[Target[0]][Target[1]] = 'M';
            printGridWithFogOfWar();
            System.out.println("You missed!");
            printGrid();
        }
    }
}
