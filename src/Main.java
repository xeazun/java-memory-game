import java.util.Scanner;

public class Main {
    private static Card[][] cards = new Card[6][6];

    public static void main(String[] args) {

        cards[0][0] = new Card('D');
        cards[0][1] = new Card('C');
        cards[0][2] = new Card('F');
        cards[0][3] = new Card('M');
        cards[0][4] = new Card('B');
        cards[0][5] = new Card('H');
        cards[1][0] = new Card('J');
        cards[1][1] = new Card('E');
        cards[1][2] = new Card('A');
        cards[1][3] = new Card('N');
        cards[1][4] = new Card('K');
        cards[1][5] = new Card('G');
        cards[2][0] = new Card('P');
        cards[2][1] = new Card('B');
        cards[2][2] = new Card('L');
        cards[2][3] = new Card('N');
        cards[2][4] = new Card('O');
        cards[2][5] = new Card('G');
        cards[3][0] = new Card('K');
        cards[3][1] = new Card('J');
        cards[3][2] = new Card('E');
        cards[3][3] = new Card('P');
        cards[3][4] = new Card('O');
        cards[3][5] = new Card('M');
        cards[4][0] = new Card('R');
        cards[4][1] = new Card('H');
        cards[4][2] = new Card('S');
        cards[4][3] = new Card('I');
        cards[4][4] = new Card('A');
        cards[4][5] = new Card('R');
        cards[5][0] = new Card('C');
        cards[5][1] = new Card('S');
        cards[5][2] = new Card('L');
        cards[5][3] = new Card('D');
        cards[5][4] = new Card('I');
        cards[5][5] = new Card('F');


        while (IsTheGameOver() == false) {
            GameBoard();
            ToGuess();
        }
    }

    public static void ToGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Guess: ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        cards[i1][j1].setGuess(true);
        GameBoard();

        System.out.print("Second Guess: ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            cards[i2][j2].setGuess(true);
        } else {
            cards[i1][j1].setGuess(false);
        }
    }

    public static boolean IsTheGameOver() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (cards[i][j].isGuess() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void GameBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.println("______________________________");
            for (int j = 0; j < 6; j++) {
                if (cards[i][j].isGuess()) {

                    System.out.print(" |" + cards[i][j].getValue() + "| ");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("______________________________");
    }
}
