import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static Point[] target = new Point[3];
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	static List<Point> candidates;
	static List<Point> virus;
	static int maxSafePlace;
	
	public static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		candidates = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) candidates.add(new Point(i, j));
				if (map[i][j] == 2) virus.add(new Point(i, j));
			}
		}
		makeTarget(0, 0);
		System.out.println(maxSafePlace);
	}

	private static void makeTarget(int cnt, int start) {
		if (cnt == 3) {
			getSafeSpot();
			return;
		}
		for (int i = start; i < candidates.size(); i++) {
			target[cnt] = candidates.get(i);
			makeTarget(cnt + 1, i + 1);
		}
	}

	private static void getSafeSpot() {
		int[][] clone = new int[N][];
		for (int i = 0; i < clone.length; i++) {
			clone[i] = map[i].clone();
		}
		
		for (int i = 0; i < target.length; i++) {
			int ty = target[i].y;
			int tx = target[i].x;
			clone[ty][tx] = 1;
		}
		Queue<Point> qu = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			qu.add(virus.get(i));
		}
		while (!qu.isEmpty()) {
			Point cur = qu.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (!isValid(clone, ny, nx)) continue;
				clone[ny][nx] = 2;
				qu.add(new Point(ny, nx));
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (clone[i][j] == 0) ++count;
			}
		}
		maxSafePlace = Math.max(maxSafePlace, count);
	}
	
	private static boolean isValid(int[][] map, int y, int x) {
		if (y >= N || y < 0 || x >= M || x < 0 
				|| map[y][x] != 0) return false;
		return true;
	}

}