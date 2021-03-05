package battleship;

public class Main {

    public static void main(String[] args) {
        String[] numbers = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0 ; i <= 10 ; i++){
            for (int j = 0 ; j <= 10 ; j++){
                if (i == 0 || j == 0) {
                    System.out.print(i == 0 ? numbers[j] : letters[i]);
                }
                else System.out.print("~");
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}
