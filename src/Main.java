package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] numbers = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 || j == 0) {
                    System.out.print(i == 0 ? numbers[j] : letters[i]);
                } else System.out.print("~");
                System.out.print(" ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        String ship1 = scanner.nextLine();

//        char[] chars = ship1.toCharArray();

        String startLetter = ship1.substring(0, 1);
        String startNumber = ship1.substring(1, 2);

        System.out.println(startLetter);
        System.out.println(startNumber);


        for (int i = 0; i < letters.length; i++) {
            if (ship1.substring(0, 1).contains(letters[i])) {
                letters[i] = "O";
                System.out.println("TEST");
            }
        }

    }
}
