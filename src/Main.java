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
        CheckCoordinates(grid, alphabets, "Aircraft Carrier", 5);
        CheckCoordinates(grid, alphabets, "Battleship", 4);
        CheckCoordinates(grid, alphabets, "Submarine", 3);
        CheckCoordinates(grid, alphabets, "Cruiser", 3);
        CheckCoordinates(grid, alphabets, "Destroyer", 2);

        System.out.println("The game starts!");
        DisplayGrid(grid, alphabets);
        System.out.println("Take a shot!");
        scanner = new Scanner(System.in);
        // TODO: shooting grid
    }

    public static void CheckCoordinates(char[][] grid, char[] alphabets, String shipName, int ship) {
        String[] coordinates;
        System.out.println("Enter the coordinates of the " + shipName + " (" + ship + " cells):");

        int startCoordinates;
        int endCoordinates;

        while (true) {
            coordinates = scanner.nextLine().split("\\s+");

            try {
                startCoordinates = Integer.parseInt(coordinates[0].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                startCoordinates = Integer.parseInt(String.valueOf(coordinates[0].charAt(1)));
            }
            try {
                endCoordinates = Integer.parseInt(coordinates[1].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                endCoordinates = Integer.parseInt(String.valueOf(coordinates[1].charAt(1)));
            }

            if ((coordinates[0].charAt(0) >= 'A' && coordinates[1].charAt(0) <= 'J')) {
                if (coordinates[0].charAt(0) == coordinates[1].charAt(0)) {
                    if (Math.abs(startCoordinates - endCoordinates) == ship - 1) {
                        int index = new String(alphabets).indexOf(coordinates[0].charAt(0));
                        if (startCoordinates < endCoordinates) {
                            for (int i = startCoordinates - 1; i < endCoordinates; i++) {
                                grid[index][i] = 'O';
                            }
                        } else {
                            for (int i = endCoordinates - 1; i < startCoordinates; i++) {
                                grid[index][i] = 'O';
                            }
                        }
                        DisplayGrid(grid, alphabets);
                        break;
                    } else {
                        System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    }
                } else {
                    int index1 = new String(alphabets).indexOf(coordinates[0].charAt(0));
                    int index2 = new String(alphabets).indexOf(coordinates[1].charAt(0));

                    if (startCoordinates > 1 && endCoordinates > 1 && index1 > 1 && index2 > 1 && index1 < 9 && index2 < 9) {
                        if (grid[index1 - 1][startCoordinates] != 'O' && grid[index1 + 1][startCoordinates] != 'O' && grid[index2 - 1][startCoordinates] != 'O' && grid[index2 + 1][startCoordinates] != 'O') {
                            if (index1 < index2 && startCoordinates == endCoordinates) {
                                for (int i = index1; i <= index2; i++) {
                                    grid[i][startCoordinates - 1] = 'O';
                                }
                                DisplayGrid(grid, alphabets);
                                break;
                            } else {
                                System.out.println("Error! Wrong ship location! Try again:");
                            }
                        } else {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                        }
                    } else {
                        if (index1 < index2 && startCoordinates == endCoordinates) {
                            for (int i = index1; i <= index2; i++) {
                                grid[i][startCoordinates - 1] = 'O';
                            }
                            DisplayGrid(grid, alphabets);
                            break;
                        } else {
                            System.out.println("Error! Wrong ship location! Try again:");
                        }
                    }
                }
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
}

