package battleship;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] grid = new char[10][10];
        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '~';
            }
        }


        DisplayGrid(grid, alphabets);
        Check.CheckCoordinates(grid, alphabets, "Aircraft Carrier", 5);
        Check.CheckCoordinates(grid, alphabets, "Battleship", 4);
        Check.CheckCoordinates(grid, alphabets, "Submarine", 3);
        Check.CheckCoordinates(grid, alphabets, "Cruiser", 3);
        Check.CheckCoordinates(grid, alphabets, "Destroyer", 2);

        System.out.println("The game starts!");
        DisplayEmptyGrid(grid, alphabets);
//        DisplayGrid(grid, alphabets);

        System.out.println("Take a shot!");

        while (scanner.hasNext()) {
            String shot = scanner.nextLine();

            char x = shot.charAt(0);
            if (x == 'A') {
                x = 0;
            } else if (x == 'B') {
                x = 1;
            } else if (x == 'C') {
                x = 2;
            } else if (x == 'D') {
                x = 3;
            } else if (x == 'E') {
                x = 4;
            } else if (x == 'F') {
                x = 5;
            } else if (x == 'G') {
                x = 6;
            } else if (x == 'H') {
                x = 7;
            } else if (x == 'I') {
                x = 8;
            } else if (x == 'J') {
                x = 9;
            }

            char y = shot.charAt(1);
            if (y == '1' && shot.length() == 2) {
                y = 0;
            } else if (y == '2') {
                y = 1;
            } else if (y == '3') {
                y = 2;
            } else if (y == '4') {
                y = 3;
            } else if (y == '5') {
                y = 4;
            } else if (y == '6') {
                y = 5;
            } else if (y == '7') {
                y = 6;
            } else if (y == '8') {
                y = 7;
            } else if (y == '9') {
                y = 8;
            } else if (shot.charAt(1) == 1 && shot.charAt(2) == 0) {
                y = 9;
            }

            try {
                if (grid[x][y] == 'O') {
                    System.out.println("You hit a ship!");
                    grid[x][y] = 'X';
                } else {
                    System.out.println("You missed!");
                    grid[x][y] = 'M';
                }
                DisplayGrid(grid, alphabets);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }

        }
    }


    public static void DisplayGrid(char[][] grid, char[] alphabets) {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(alphabets[i] + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DisplayEmptyGrid(char[][] grid, char[] alphabets) {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(alphabets[i] + " ");
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = '~';
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
