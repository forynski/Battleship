package battleship;

import java.util.Scanner;

public class Main extends DisplayGridClass {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] grid = new char[10][10];
        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '~';
            }
        }

        displayGrid(grid, alphabets);
        Check.checkCoordinates(grid, alphabets, "Aircraft Carrier", 5);
        Check.checkCoordinates(grid, alphabets, "Battleship", 4);
        Check.checkCoordinates(grid, alphabets, "Submarine", 3);
        Check.checkCoordinates(grid, alphabets, "Cruiser", 3);
        Check.checkCoordinates(grid, alphabets, "Destroyer", 2);
        System.out.println("The game starts!");

        hideCells(grid);
        displayGrid(grid, alphabets);

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
                displayGrid(grid, alphabets);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }

    static void hideCells(char[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = '~';
                }
            }

        }
    }
}
