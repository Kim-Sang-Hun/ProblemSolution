import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static int T, V, E;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
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
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edges);
			makeSet();
			long weight = 0;
			int count = 0;
			for (Edge edge : edges) {
				if (!union(edge.from, edge.to)) continue;
				weight += edge.weight;
				if (++count == V - 1) break;
			}
			sb.append("#" + (tc + 1) + " " + weight + System.lineSeparator());
		}
		System.out.println(sb);
	}

	public static void makeSet() {
		parents = new int[V + 1];
		
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}