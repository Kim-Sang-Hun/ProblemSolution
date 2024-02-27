import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static long[][] dp; 
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		System.out.println(makeDP(0, 0));
	}

	public static long makeDP(int i, int j) {
		if (dp[i][j] != 0) return dp[i][j];
		if (i == N-1 && j == N-1) return 1;
		if (map[i][j] == 0) return 0;
		long sum = 0;
		if (i + map[i][j] < N) {
			sum += makeDP(i + map[i][j], j);
		}
		if (j + map[i][j] < N) {
			sum += makeDP(i, j + map[i][j]);
		}
		return dp[i][j] = sum;
	}
}