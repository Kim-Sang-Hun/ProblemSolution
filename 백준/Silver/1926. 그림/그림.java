import java.util.Scanner;

public class Main {
    static int[] dirY = {1, -1};
    static int[] dirX = {1, -1};
    static int cnt1 = 0;
    static int cnt2 = 0;

    static void count(int y, int x, int[][] paint, boolean[][] visited, int depth) {
        if (visited[y][x] || paint[y][x] == 0) {
            return;
        }
        visited[y][x] = true;
        cnt1++;
        if (depth == 1) {
            cnt2++;
        }

        for (int i = 0; i < dirY.length; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (newY >= 0 && newY < paint.length) {
                count(newY, x, paint, visited, depth + 1);
            }
            if (newX >= 0 && newX < paint[0].length) {
                count(y, newX, paint, visited, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int[][] paint = new int[y][x];
        boolean[][] visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                paint[i][j] = sc.nextInt();
            }
        }
        int[] answer = new int[]{0, 0};
        int max = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int depth = 1;
                cnt1 = 0;
                count(i, j, paint, visited, depth);
                if (max < cnt1) {
                    max = cnt1;
                }
            }
        }
        System.out.println(cnt2);
        System.out.print(max);
    }
}