import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] triangle = new int[N][];
		triangle[0] = new int[1];
		triangle[0][0] = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			triangle[i] = new int[i + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				if (j == i) {
					triangle[i][j] = Integer.parseInt(st.nextToken()) + triangle[i-1][j-1];
				} else if (j == 0) {
					triangle[i][j] = Integer.parseInt(st.nextToken()) + triangle[i-1][j];
				} else {
					triangle[i][j] = Integer.parseInt(st.nextToken()) + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, triangle[N-1][i]);
		}
		System.out.println(max);
	}
}