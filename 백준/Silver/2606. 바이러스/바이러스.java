import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<>();
		visited = new boolean[N + 1];
		
		StringTokenizer st;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		bfs(list);
	}

	private static void bfs(List<List<Integer>> list) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			List<Integer> nexts = list.get(cur);
			for(int next : nexts) {
				if (visited[next]) continue;
				visited[next] = true;
				++cnt;
				qu.add(next);
			}
		}
		System.out.println(cnt);
	}
	
}