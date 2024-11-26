import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class planet {
		int x, y, z, num;

		public planet(int x, int y, int z, int num) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.num = num;
		}
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		planet[] planets = new planet[N];
		parents = new int[N];
		List<Edge> edges = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			planets[i] = new planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			parents[i] = i;
		}

		Arrays.sort(planets, Comparator.comparingInt(o -> o.x));
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].num, planets[i+1].num, planets[i+1].x - planets[i].x));
		}
		Arrays.sort(planets, Comparator.comparingInt(o -> o.y));
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].num, planets[i+1].num, planets[i+1].y - planets[i].y));
		}
		Arrays.sort(planets, Comparator.comparingInt(o -> o.z));
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].num, planets[i+1].num, planets[i+1].z - planets[i].z));
		}
		edges.sort(Comparator.comparingInt(o -> o.weight));
		int answer = 0;
		for (Edge e : edges) {
			if (find(e.from) != find(e.to)) {
				answer += e.weight;
				union(e.from, e.to);
			}
		}
		System.out.println(answer);
	}

	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a == b) return false;
		if (a < b) {
			parents[b] = parents[a];
		} else {
			parents[a] = parents[b];
		}
		return true;
	}
}
