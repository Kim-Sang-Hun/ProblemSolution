import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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


/*
 * 10
 * 1
 * 2
 * 5
 * 1 1 - 1
 * 2 11 2 - 2
 * 3 111 12 - 2
 * 4 1111 112 22 - 3
 * 5 11111 1112 122 5 - 4
 * 6 111111 11112 1122 222 15 - 5
 * 
 * 10
 * 2
 * 3
 * 5
 * 1 0
 * 2 2 - 1
 * 3 3 - 1
 * 4 0
 * 5 23 5 - 2
 * 6 222 33 - 2
 * 
 */