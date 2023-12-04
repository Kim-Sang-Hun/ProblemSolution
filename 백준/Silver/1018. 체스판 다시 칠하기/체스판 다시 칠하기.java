import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int Y = s.nextInt();
        int X = s.nextInt();
        s.nextLine();

        char[][] board = new char[Y][X];
        char[][] bBoard = new char[8][8];
        char[][] wBoard = new char[8][8];
        for (int i = 0; i < Y; i++) {
            String str = s.nextLine().trim();
            for (int j = 0; j < X; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    bBoard[i][j] = 'B';
                    wBoard[i][j] = 'W';
                } else {
                    bBoard[i][j] = 'W';
                    wBoard[i][j] = 'B';
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= Y - 8; i++) {
            for (int j = 0; j <= X - 8; j++) {
                minDiff = Math.min(minDiff, checkDiff(board, bBoard, wBoard, i, j));
            }
        }
        System.out.println(minDiff);
    }

    public static int checkDiff(char[][] board, char[][] bBoard, char[][] wBoard, int startY, int startX) {
        int bDiff = 0;
        int wDiff = 0;
        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (board[i][j] != bBoard[i-startY][j-startX]) {
                    bDiff++;
                }
                if (board[i][j] != wBoard[i-startY][j-startX]) {
                    wDiff++;
                }
            }
        }
        return Math.min(bDiff, wDiff);
    }
}
