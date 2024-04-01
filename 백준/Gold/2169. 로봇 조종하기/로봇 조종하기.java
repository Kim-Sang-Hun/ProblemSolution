import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[3][m];
		Arrays.fill(dp[1], Integer.MIN_VALUE);
		Arrays.fill(dp[2], Integer.MIN_VALUE);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < m; i++) {
			map[0][i] += map[0][i-1];
		}
		dp[0] = map[0].clone();
		for (int i = 1; i < n; i++) {
			
			dp[1][0] = dp[0][0] + map[i][0];
			dp[2][m-1] = dp[0][m-1] + map[i][m-1];
			for (int j = 1; j < m; j++) {
				dp[1][j] = Math.max(dp[1][j-1], dp[0][j]) + map[i][j];
				dp[2][m-j-1] = Math.max(dp[2][m-j], dp[0][m-j-1]) + map[i][m-j-1];
			}
			for (int j = 0; j < m; j++) {
				dp[0][j] = Math.max(dp[1][j], dp[2][j]);
			}
		}
		System.out.println(dp[0][m-1]);
	}
}