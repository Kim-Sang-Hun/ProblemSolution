import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, targetY, targetX, startY, startX;
	static int time = Integer.MAX_VALUE;
	static Queue<Point> waters = new LinkedList<>();
	static int[] dirY = {0, 1, 0, -1};
	static int[] dirX = {1, 0, -1, 0};
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'D') {
					targetY = i;
					targetX = j;
				}
				else if (map[i][j] == 'S') {
					startY = i;
					startX = j;
				}
				else if (map[i][j] == '*') {
					waters.add(new Point(i, j));
				}
			}
		}
		System.out.println(bfs() ? time : "KAKTUS");
	}
	
	public static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		visited[startY][startX] = true;
		queue.add(new Point(startY, startX, 0));
		int curTime = 0;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if (cur.y == targetY && cur.x == targetX) {
				time = Math.min(time, cur.time);
				return true;
			}
			if (curTime < cur.time) {
				++curTime;
				extendWater();
			}
			if (map[cur.y][cur.x] == '*') {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nY = cur.y + dirY[i];
				int nX = cur.x + dirX[i];
				
				if (isImpossible(nY, nX)) continue;
				if (visited[nY][nX]) continue;
				visited[nY][nX] = true;
				queue.offer(new Point(nY, nX, cur.time + 1));
			}
		}
		return false;
	}
	
	public static void extendWater() {
		int waterSize = waters.size();
		
		for (int i = 0; i < waterSize; i++) {
			Point water = waters.poll();
			
			for (int j = 0; j < 4; j++) {
				int nY = water.y + dirY[j];
				int nX = water.x + dirX[j];
				
				if (isImpossible(nY, nX)) continue;
				if (map[nY][nX] == 'D') continue;
				map[nY][nX] = '*';
				waters.add(new Point(nY, nX));
			}
		}
	}
	
	public static class Point {
		int y;
		int x;
		int time;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public Point(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

	public static boolean isImpossible(int y, int x) {
		return (y >= R || y < 0 || x >= C || x < 0 || map[y][x] == 'X' || map[y][x] == '*');
	}
}