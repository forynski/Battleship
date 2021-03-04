package battleship;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        char c;
        for (c = 'A'; c <= 'H'; c++) {
            System.out.println(c + " ");
        }

        int rows = 10;
        int columns = 10;
        char[][] charArray = new char[rows][columns];

        for (char[] chars : charArray) {
            Arrays.fill(chars, '~');
            System.out.println(chars);
        }
    }
}
