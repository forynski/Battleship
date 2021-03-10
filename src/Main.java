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
    }

    public static void CheckCoordinates(char[][] grid, char[] alphabets, String shipName, int ship) {
        String[] coordinates;
        System.out.println("Enter the coordinates of the " + shipName + " (" + ship + " cells):");
        int first, second;
        while (true) {
            coordinates = scanner.nextLine().split("\\s+");

            try {
                first = Integer.parseInt(coordinates[0].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                first = Integer.parseInt(String.valueOf(coordinates[0].charAt(1)));
            }
            try {
                second = Integer.parseInt(coordinates[1].substring(1, 3));
            } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                second = Integer.parseInt(String.valueOf(coordinates[1].charAt(1)));
            }

            if ((coordinates[0].charAt(0) >= 'A' && coordinates[1].charAt(0) <= 'J')) {
                if (coordinates[0].charAt(0) == coordinates[1].charAt(0)) {
                    if (Math.abs(first - second) == ship - 1) {
                        int index = new String(alphabets).indexOf(coordinates[0].charAt(0));
                        if (first < second) {
                            for (int i = first - 1; i < second; i++) {
                                grid[index][i] = 'O';
                            }
                        } else {
                            for (int i = second - 1; i < first; i++) {
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

                    if (first > 1 && second > 1 && index1 > 1 && index2 > 1 && index1 < 9 && index2 < 9) {
                        if (grid[index1 - 1][first] != 'O' && grid[index1 + 1][first] != 'O' && grid[index2 - 1][first] != 'O' && grid[index2 + 1][first] != 'O') {
                            if (index1 < index2 && first == second) {
                                for (int i = index1; i <= index2; i++) {
                                    grid[i][first - 1] = 'O';
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
                        if (index1 < index2 && first == second) {
                            for (int i = index1; i <= index2; i++) {
                                grid[i][first - 1] = 'O';
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

