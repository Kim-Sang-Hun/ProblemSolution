import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int N, start, max;
	static int[][] map, dp;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static int dfs(int y, int x, int count) {
		if (dp[y][x] != 0) {
			return count - 1 + dp[y][x];
		}
		for (int i = 0; i < dirs.length; i++) {
			int nY = y + dirs[i][0];
			int nX = x + dirs[i][1];

			if (nY >= N || nX >= N || nY < 0 || nX < 0 || map[nY][nX] - map[y][x] != 1) continue;
			dp[y][x] = dfs(nY, nX, count + 1);
			return dp[y][x];
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][];
			dp = new int[N][N];
			max = 0;
			start = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dp[i][j] != 0) {
						continue;
					}
					int tmp = dfs(i, j, 1);
					if (max == tmp) {
						max = tmp;
						start = Math.min(start, map[i][j]);
					} else if (max < tmp) {
						max = tmp;
						start = map[i][j];
					}
				}
			}
			sb.append("#" + tc + " " + start + " " + max + System.lineSeparator());
		}
		System.out.print(sb);
	}
}