import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, minCost, start;
	static int[][] W;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			start = i;
			visited[i] = true;
			dfs(i, 0, 0);
		}
		System.out.println(minCost);
	}
	
	private static void dfs(int idx, int count, int cost) {
		if (count == N - 1) {
			if (W[idx][start] != 0) {
				minCost = Math.min(minCost, cost + W[idx][start]);
			}
			return;
		}
		if (cost >= minCost) return;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && W[idx][i] != 0) {
				visited[i] = true;
				dfs(i, count + 1, cost + W[idx][i]);
				visited[i] = false;
			}
		}
	}

}