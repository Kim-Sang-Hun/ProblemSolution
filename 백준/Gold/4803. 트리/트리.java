import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 0;
		while (true) {
			++tc;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			makeSet(n);
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < parent.length; i++) {
				if (find(i) != 0)
				set.add(find(i));
			}
			if (set.size() == 0) {
				sb.append("Case " + tc + ": No trees." + System.lineSeparator());
			} else if (set.size() == 1) {
				sb.append("Case " + tc + ": There is one tree." + System.lineSeparator());
			} else {
				sb.append("Case " + tc + ": A forest of " + set.size() + " trees." + System.lineSeparator());
			}
		}
		System.out.println(sb);
	}
	
	private static void makeSet(int n) {
		parent = new int[n + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static int find(int a) {
		if (parent[a] == 0) return 0;
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(parent[a]);
		int bRoot = find(parent[b]);

		if (aRoot == bRoot) {
			parent[bRoot] = 0;
		} else if (aRoot > bRoot) parent[aRoot] = parent[bRoot];
		else parent[bRoot] = parent[aRoot];
	}
}