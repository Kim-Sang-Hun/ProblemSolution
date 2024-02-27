import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Edge implements Comparable<Edge> {
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		int[] minLen = new int[v + 1];
		minLen[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Edge>[] edges = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			minLen[i] = Integer.MAX_VALUE;
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
		}
		pq.add(new Edge(start, 0));
		minLen[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			for (Edge next : edges[cur.to]) {
				if (minLen[next.to] > minLen[cur.to] + next.weight) {
					minLen[next.to] = minLen[cur.to] + next.weight;
					pq.add(new Edge(next.to, minLen[next.to]));
				}
			}
		}
		for (int i = 1; i < minLen.length; i++) {
			sb.append(minLen[i] != Integer.MAX_VALUE ? minLen[i] : "INF")
			.append(System.lineSeparator());
		}
		System.out.println(sb);
	}

}