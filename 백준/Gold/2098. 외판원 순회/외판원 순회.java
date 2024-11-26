import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] W, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(input[j]);
			}
			Arrays.fill(dp[i], -1);
		}

		System.out.println(findMin(0, 0));
	}

	private static int findMin(int from, int visit) {
		visit |= (1 << from);

		if (visit == (1 << N) - 1) {
			if (W[from][0] > 0) {
				return W[from][0];
			}
			return 17_000_000;
		}

		if (dp[from][visit] != -1) return dp[from][visit];
		dp[from][visit] = 17_000_000;

		for (int i = 0; i < N; i++) {
			if (from != i && (visit & (1 << i)) == 0 && W[from][i] != 0) {
				dp[from][visit] = Math.min(findMin(i, visit) + W[from][i], dp[from][visit]);
			}
		}

		return dp[from][visit];
	}
}
