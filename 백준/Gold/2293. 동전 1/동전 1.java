import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] values, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		values = new int[N];
		dp = new int[K + 1];
		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			int coin = values[i];
			for (int j = coin; j <= K; j++) {
				dp[j] += dp[j - coin];
			}
		}

		System.out.println(dp[K]);
	}
}