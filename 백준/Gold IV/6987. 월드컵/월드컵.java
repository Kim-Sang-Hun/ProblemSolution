import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] allMatch;
	static int[][] result;
	static boolean isValid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		allMatch = new int[15][2];
		result = new int[6][3];
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				allMatch[idx][0] = i;
				allMatch[idx++][1] = j;
			}
		}

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			isValid = false;
			boolean isPossible = true;
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int even = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				if (win + even + lose != 5) {
					isPossible = false;
					break;
				}
				result[j][0] = win;
				result[j][1] = even;
				result[j][2] = lose;
			}
			if (!isPossible) {
				sb.append("0 ");
				continue;
			}
			dfs(0);
			sb.append(isValid ? "1 " : "0 ");
		}
		System.out.print(sb.toString().trim());
	}

	private static void dfs(int count) {
		if (isValid) return;
		if (count == 15) {
			isValid = true;
			return;
		}
		int team1 = allMatch[count][0];
		int team2 = allMatch[count][1];
		
		if (result[team1][0] > 0 && result[team2][2] > 0) {
			--result[team1][0];
			--result[team2][2];
			dfs(count + 1);
			++result[team1][0];
			++result[team2][2];
		}
		if (result[team1][1] > 0 && result[team2][1] > 0) {
			--result[team1][1];
			--result[team2][1];
			dfs(count + 1);
			++result[team1][1];
			++result[team2][1];
		}
		if (result[team1][2] > 0 && result[team2][0] > 0) {
			--result[team1][2];
			--result[team2][0];
			dfs(count + 1);
			++result[team1][2];
			++result[team2][0];
		}
	}
}