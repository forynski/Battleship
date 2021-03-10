package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean bDef;

    public static void main(String[] args) {
        System.out.println(bDef);


        String[][] multi = new String[11][11];
        multi[0][0] = " ";
        multi[0][1] = "1";
        multi[0][2] = "2";
        multi[0][3] = "3";
        multi[0][4] = "4";
        multi[0][5] = "5";
        multi[0][6] = "6";
        multi[0][7] = "7";
        multi[0][8] = "8";
        multi[0][9] = "9";
        multi[0][10] = "10";

        multi[1][0] = "A";
        multi[2][0] = "B";
        multi[3][0] = "C";
        multi[4][0] = "D";
        multi[5][0] = "E";
        multi[6][0] = "F";
        multi[7][0] = "G";
        multi[8][0] = "H";
        multi[9][0] = "I";
        multi[10][0] = "J";

//        System.out.println(Arrays.deepToString(multi));



        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0) {
                    System.out.println(Arrays.toString(multi[j])
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
//                } else System.out.print("~");
//                    System.out.print(" ");
                }
//                System.out.println();
            }
        }


        //        for (int i = 0; i <= 10; i++) {
//            for (int j = 0; j <= 10; j++) {
//                if (i == 0 || j == 0) {
//                    System.out.print(i == 0 ? numbers[j] : letters[i]);
//                } else System.out.print("~");
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
//        String ship1 = scanner.nextLine();

//        char[] chars = ship1.toCharArray();

//        String startLetter = ship1.substring(0, 1);
//        String startNumber = ship1.substring(1, 2);
//
//        System.out.println(startLetter);
//        System.out.println(startNumber);
//
//
//        for (int i = 0; i < letters.length; i++) {
//            if (ship1.substring(0, 1).contains(letters[i])) {
//                letters[i] = "O";
//                System.out.println("TEST");
//            }
//        }

    }
}

