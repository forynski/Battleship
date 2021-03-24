package battleship;

public class DisplayGridClass {
    public static void displayGrid(char[][] grid, char[] alphabets) {

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
