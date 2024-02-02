import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		System.out.print(dp(0, 1, 0));
	}

	public static int dp(int y, int x, int dir) {
		if (y == N - 1 && x == N - 1) {
			return 1;
		}
		int a = 0;
		int b = 0;
		int c = 0;
		if (y + 1 < N && dir != 0) {
			if (map[y + 1][x] == 0) {
				a = dp(y + 1, x, 2);
			}
		}
		if (x + 1 < N && dir != 2) {
			if (map[y][x + 1] == 0) {
				b = dp(y, x + 1, 0);
			}
		}
		if (y + 1 < N && x + 1 < N) {
			if (map[y + 1][x] == 0 && map[y][x + 1] == 0 && map[y+1][x+1] == 0) {
				c = dp(y+1,x+1, 1);
			}
		}
		return a + b + c;
	}
}