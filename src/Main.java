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
        DisplayGrid(grid, alphabets);
        System.out.println("Take a shot!");
        scanner = new Scanner(System.in);
        String shot = scanner.nextLine();
        // TODO: shooting grid
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
}

