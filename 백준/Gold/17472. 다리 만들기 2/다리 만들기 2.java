import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, sum;
	static int[][] map;
	static List<List<Point>> islands;
	static List<int[]> edges;
	static boolean[][] visited;
	static boolean valid;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Edge {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		islands = new ArrayList<>();
		islands.add(new ArrayList<>());
		edges = new ArrayList<>();
		edges.add(new int[] {0});
		int islandNum = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					islands.add(new ArrayList<>());
					union(i, j, islandNum);
					++islandNum;
				}
			}
		}
		
		for (int i = 1; i < islandNum; i++) {
			List<Point> points = islands.get(i);
			edges.add(new int[islandNum]);
			Arrays.fill(edges.get(i), Integer.MAX_VALUE);
			
			for (Point p : points) {
				
				for (int j = 0; j < 4; j++) {	
					int cnt = 0;
					int ny = p.y;
					int nx = p.x;
					while (true) {
						ny += dy[j];
						nx += dx[j];
						
						if (ny >= n || ny < 0 || nx >= m || nx < 0 || map[ny][nx] == i) break;
						if (map[ny][nx] != 0) {
							if (cnt >= 2) {
								edges.get(i)[map[ny][nx]] = Math.min(edges.get(i)[map[ny][nx]], cnt);
							}
							break;
						} else {
							++cnt;
						}
					}
				}
			}
		}
		mst();
		System.out.println(valid ? sum : -1);
	}

	private static void mst() {
		boolean[] visited2 = new boolean[islands.size()];
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		visited2[1] = true;
		int cnt = 1;
		int[] next = edges.get(1);
		for (int i = 2; i < next.length; i++) {
			if (next[i] != 0 && next[i] != Integer.MAX_VALUE) {
				pq.add(new Edge(i, next[i]));
			}
		}
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited2[cur.to]) continue;
			sum += cur.weight;
			++cnt;
			visited2[cur.to] = true;
			if (cnt == islands.size()-1) {
				valid = true;
				return;
			}
			next = edges.get(cur.to);
			for (int i = 1; i < next.length; i++) {
				if (next[i] != 0 && next[i] != Integer.MAX_VALUE && !visited2[i]) {
					pq.add(new Edge(i, next[i]));
				}
			}
		}
	}
	
	
	private static void union(int y, int x, int islandNum) {
		map[y][x] = islandNum;
		visited[y][x] = true;
		Queue<Point> qu = new ArrayDeque<>();
		Point p = new Point(y, x);
		qu.add(p);
		islands.get(islandNum).add(p);
		
		while (!qu.isEmpty()) {
			Point cur = qu.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (ny >= n || ny < 0 || nx >= m || nx < 0 || visited[ny][nx] || map[ny][nx] == 0) continue;
				map[ny][nx] = islandNum;
				visited[ny][nx] = true;
				Point np = new Point(ny, nx);
				qu.add(np);
				islands.get(islandNum).add(np);
			}
		}
	}
}