import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static Set<Integer>[] links;
	static int[] order;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			links = new HashSet[101];
			order = new int[101];
			visited = new boolean[101];
			for (int i = 0; i < links.length; i++) {
				links[i] = new HashSet<Integer>();
			}
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				links[from].add(to);
			}
			visited[start] = true;
			bfs(start);
			int highestNum = 0;
			int highestOrder = 0;
			for (int i = 0; i < order.length; i++) {
				if (highestOrder <= order[i]) {
					highestOrder = order[i];
					highestNum = i;
				}
			}
			
			sb.append("#" + (tc + 1) + " " + highestNum + System.lineSeparator());
		}
		System.out.println(sb);
	}
	
	public static void bfs(int num) {
		Set<Integer> set = links[num];
		Queue<int[]> queue = new LinkedList<>();
		for (int next : set) {
			visited[next] = true;
			order[next] = 1;
			queue.add(new int[] {next, 1});
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			Set<Integer> nexts = links[cur[0]];
			for (int next : nexts) {
				if (visited[next]) continue;
				visited[next] = true;
				order[next] = cur[1] + 1;
				queue.add(new int[] {next, order[next]});
			}
		}
	}
}