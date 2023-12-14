import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] map = br.readLine().split(" ");
            int[][] field = new int[Integer.parseInt(map[0])][Integer.parseInt(map[1])];
            boolean[][] visited = new boolean[field.length][field[0].length];
            for (int j = 0; j < Integer.parseInt(map[2]); j++) {
                String[] axis = br.readLine().split(" ");
                field[Integer.parseInt(axis[0])][Integer.parseInt(axis[1])] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[0].length; k++) {
                    cnt += dfs(field, visited, j, k);
                }
            }
            System.out.println(cnt);
        }
    }

    public static int dfs(int[][] field, boolean[][] visited, int Y, int X) {
        if (visited[Y][X] || field[Y][X] == 0) {
            return 0;
        }
        visited[Y][X] = true;
        for (int i = 0; i < dirs.length; i++) {
            int newY = Y + dirs[i][0];
            int newX = X + dirs[i][1];

            if (newY >= 0 && newY < field.length && newX >= 0 && newX < field[0].length) {
                if (!visited[newY][newX]) {
                    dfs(field, visited, newY, newX);
                }
            }
        }

        return 1;
    }

}
