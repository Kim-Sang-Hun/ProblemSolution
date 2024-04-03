import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, cleaner, dust;
	static int[][] map;
	static int[][] nextMap;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					cleaner = i;
				} else {
					dust += map[i][j];
				}
			}
		}
		for (int i = 0; i < t; i++) {
			spread();
			clean();
			map = nextMap;
		}
		System.out.println(dust);
	}
	
	private static void spread() {
		nextMap = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] <= 4) {
					nextMap[i][j] += map[i][j];
					continue;
				}
				
				int cnt = 0;
				int nextValue = map[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (ny >= r || ny < 0 || nx >= c || nx < 0 || map[ny][nx] == -1) continue;
					++cnt;
					nextMap[ny][nx] += nextValue;
				}
				nextMap[i][j] += map[i][j] - nextValue * cnt;
			}
		}
	}
	private static void clean() {
		dust -= nextMap[cleaner-2][0];
		dust -= nextMap[cleaner+1][0];
		// 시계반대방향 순환
		for (int i = cleaner-2; i > 0; i--) {
			nextMap[i][0] = nextMap[i-1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			nextMap[0][i] = nextMap[0][i+1];
		}
		for (int i = 0; i < cleaner-1; i++) {
			nextMap[i][c-1] = nextMap[i+1][c-1];
		}
		for (int i = c - 1; i > 1; i--) {
			nextMap[cleaner-1][i] = nextMap[cleaner-1][i-1];
		}
		// 시계방향 순환
		for (int i = cleaner + 1; i < r - 1; i++) {
			nextMap[i][0] = nextMap[i+1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			nextMap[r-1][i] = nextMap[r-1][i+1];
		}
		for (int i = r-1; i > cleaner; i--) {
			nextMap[i][c-1] = nextMap[i-1][c-1];
		}
		for (int i = c - 1; i > 1; i--) {
			nextMap[cleaner][i] = nextMap[cleaner][i-1];
		}
		nextMap[cleaner-1][1] = 0;
		nextMap[cleaner][1] = 0;
	}
}