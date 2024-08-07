import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m, min, sum, first, second;
	static int max = 1_000_000_007;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], max);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					map[j][k] = map[k][j] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}

		min = max;

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				sum = 0;
				for (int k = 1; k <= n; k++) {
					if (k == i || k == j) continue;

					sum += Math.min(map[i][k], map[j][k]);
				}

				if (min > sum) {
					min = sum;
					first = i;
					second = j;
				}
			}
		}

		System.out.println(first + " " + second + " " + min * 2);
		br.close();
	}
}