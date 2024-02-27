import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[i][0] = R;
			map[i][1] = G;
			map[i][2] = B;
		}
		int R = getMin(N - 1, 0);
		int G = getMin(N - 1, 1);
		int B = getMin(N - 1, 2);
		System.out.println(Math.min(Math.min(R, G), B));
	}

	private static int getMin(int depth, int color) {
		if (depth == 0)
			return map[0][color];
		if (dp[depth][color] != 0) return dp[depth][color];

		if (color == 0) {
			int G = dp[depth - 1][1] = getMin(depth - 1, 1);
			int B = dp[depth - 1][2] = getMin(depth - 1, 2);
			return Math.min(G, B) + map[depth][0];
		} else if (color == 1) {
			int R = dp[depth - 1][0] = getMin(depth - 1, 0);
			int B = dp[depth - 1][2] = getMin(depth - 1, 2);
			return Math.min(R, B) + map[depth][1];
		} else {
			int R = dp[depth - 1][0] = getMin(depth - 1, 0);
			int G = dp[depth - 1][1] = getMin(depth - 1, 1);
			return Math.min(R, G) + map[depth][2];
		}
	}
}