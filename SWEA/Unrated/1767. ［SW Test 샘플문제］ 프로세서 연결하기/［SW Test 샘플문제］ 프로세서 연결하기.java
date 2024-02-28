import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static boolean[][] map;
	static List<Core> cores;
	static int maxConnected;
	static int minLenSum;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static class Core {
		int y, x;
		List<Integer> possibleDir;
		public Core(int y, int x, List<Integer> possibleDir) {
			this.y = y;
			this.x = x;
			this.possibleDir = possibleDir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			cores = new ArrayList<>();
			maxConnected = 0;
			minLenSum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = true;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] && i != 0 && i != N-1 && j != 0 && j != N-1) {
						List<Integer> possibleDir = new ArrayList<>();
						for (int k = 0; k < 4; k++) {
							if (checkLen(i, j, k) != -1) possibleDir.add(k);
						}
						if (!possibleDir.isEmpty()) {
							cores.add(new Core(i, j, possibleDir));
						}
					}
				}
			}

			getLen(0, 0, 0);
			sb.append("#" + tc + " " + minLenSum).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
	
	public static void getLen(int cnt, int lenSum, int connected) {
		if (cnt == cores.size()) {
			if (maxConnected < connected) {
				maxConnected = connected;
				minLenSum = lenSum;
			} else if (maxConnected == connected) {
				minLenSum = Math.min(minLenSum, lenSum);
			}
			return;
		}
		if (connected + (cores.size() - cnt) < maxConnected) return;
		Core cur = cores.get(cnt);
		
		for (int dir : cur.possibleDir) {
			int y = cur.y;
			int x = cur.x;
			int len = checkLen(y, x, dir);
			if (len == -1) continue;
			drawMap(y, x, dir, true, len);
			getLen(cnt + 1, lenSum + len, connected + 1);
			drawMap(y, x, dir, false, len);
		}
		getLen(cnt + 1, lenSum, connected);
	}
	
	public static boolean isOut(int y, int x) {
		if (y >= N || y < 0 || x >= N || x < 0) return true;
		return false;
	}
	
	public static int checkLen(int y, int x, int dir) {
		int len = 0;
		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (isOut(y, x)) {
				return len;
			}
			if (map[y][x]) return -1;
			++len;
		}
	}
	
	public static void drawMap(int y, int x, int dir, boolean to, int cnt) {
		while (cnt-- > 0) {
			y += dy[dir];
			x += dx[dir];
			map[y][x] = to;
		}
	}
}