import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dirs = {-1, 0, 1};
	static char[][] map;
	static int R, C;

	public static int dfs(int y, int x) {
		if (x == C - 1) {
			return 1;
		}
		int answer = 0;
		for (int i = 0; i < dirs.length; i++) {
			int nY = y + dirs[i];
			int nX = x + 1;
			if (nY < 0 || nY >= R || map[nY][nX] == 'x') continue;
			map[nY][nX] = 'x';
			if (dfs(nY, nX) == 1) {
				++answer;
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			sum += dfs(i, 0);
		}
		System.out.println(sum);
	}
}