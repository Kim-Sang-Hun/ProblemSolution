import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int min;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Minsik {
		int y, x, time, key;
		
		public Minsik(int y, int x, int time, int key) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.key = key;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		min = Integer.MAX_VALUE;
		visited = new boolean[1<<6][n][m];
		
		Minsik start = null;
		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j);
				if (map[i][j] == '0') {
					start = new Minsik(i, j, 0, 0);
				}
			}
		}
		bfs(start);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void bfs(Minsik start) {
		Queue<Minsik> qu = new ArrayDeque<>();
		qu.add(start);
		visited[0][start.y][start.x] = true;
		
		while (!qu.isEmpty()) {
			Minsik cur = qu.poll();
			if (map[cur.y][cur.x] == '1') {
				min = cur.time;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (ny >= n || ny < 0 || nx >= m || nx < 0 || map[ny][nx] == '#' || visited[cur.key][ny][nx]) continue;
				visited[cur.key][ny][nx] = true;
				char c = map[ny][nx];
				int nextKey = cur.key;
				if (c >= 'a' && c <= 'f') {
					nextKey |= 1 << (c - 'a');
				} else if (c >= 'A' && c <= 'F') {
					if ((nextKey & (1 << (c - 'A'))) == 0) continue;
				}
				qu.add(new Minsik(ny, nx, cur.time + 1, nextKey));
			}
		}
	}
}