import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Edge>[] map = new ArrayList[V];
			boolean[] visited = new boolean[V];
			
			for (int i = 0; i < V; i++) {
				map[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				map[from - 1].add(new Edge(to - 1, weight));
				map[to - 1].add(new Edge(from - 1, weight));
			}

			long result = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0, 0));

			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (!visited[cur.to]) {
					visited[cur.to] = true;
					result += cur.weight;
					for (Edge next : map[cur.to]) {
						pq.add(next);
					}
				}
			}

			sb.append("#" + (tc + 1) + " " + result + System.lineSeparator());
		}
		System.out.println(sb);
	}
}