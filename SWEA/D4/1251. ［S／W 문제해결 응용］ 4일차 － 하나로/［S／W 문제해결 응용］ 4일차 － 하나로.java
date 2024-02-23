import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static double minTotalLevy;
	static boolean[] visited;
	static Island[] islands;
	static double E;
	
	static class Island {
		int y, x;

		public Island(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int to;
		double weight;

		public Edge(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			islands = new Island[N];
			visited = new boolean[N];
			minTotalLevy = 0;

			for (int i = 0; i < N; i++) {
				islands[i] = new Island(0, 0);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, 0));
			int count = 0;
			
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if (visited[cur.to]) continue;
				if (count++ == N) break;
				Island curIsland = islands[cur.to];
				visited[cur.to] = true;
				minTotalLevy += cur.weight;
				for (int i = 0; i < N; i++) {
					if (visited[i]) continue;
					Island nextIsland = islands[i];
					pq.add(new Edge(i, getWeight(curIsland.y, curIsland.x, nextIsland.y, nextIsland.x)));
				}
				
			}
			
			sb.append("#" + tc + " " + Math.round(minTotalLevy) + System.lineSeparator());
		}
		System.out.println(sb);
	}
	
	public static double getWeight(int y, int x, int nY, int nX) {
		return (Math.pow(x - nX, 2) + Math.pow(y - nY, 2)) * E;
	}

}