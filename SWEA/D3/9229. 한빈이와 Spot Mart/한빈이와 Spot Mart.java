import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, max;
	static int[] snacks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < snacks.length; j++) {
				snacks[j] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			for (int j = 0; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int tmp = snacks[j] + snacks[k];
					if (tmp <= M) {
						max = Math.max(max, tmp);
					}
				}
			}

			sb.append("#").append(i + 1).append(" ").append(max).append(System.lineSeparator());
		}
		System.out.print(sb);
	}

}