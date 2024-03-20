import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Edge>[] edge;
	
	static class Edge {
		int to, weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	static boolean[] visited;
	static int max, idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		edge = new List[N];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			edge[from].add(new Edge(to, weight));
			edge[to].add(new Edge(from, weight));
		}
		dfs(0, 0);
		Arrays.fill(visited, false);
		dfs(idx, 0);
		System.out.println(max);
	}

	private static void dfs(int to, int weight) {
		if (weight > max) {
			max = weight;
			idx = to;
		}
		visited[to] = true;
		List<Edge> next = edge[to];
		for (Edge edge : next) {
			if (visited[edge.to]) continue;
			dfs(edge.to, weight + edge.weight);
		}
	}
}