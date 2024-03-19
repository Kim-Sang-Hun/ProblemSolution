import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Map<Integer, Integer> event = new HashMap<>();
	static int[] dp = new int[101];
	static class Player {
		int idx;
		int time;
		public Player(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			event.put(from, to);
		}
		bfs();
		System.out.println(dp[100]);
	}
	private static void bfs() {
		Player player = new Player(1, 0);
		Queue<Player> qu = new LinkedList<>();
		qu.add(player);
		
		while (!qu.isEmpty()) {
			player = qu.poll();
			
			for (int i = 1; i <= 6; i++) {
				int newIdx = player.idx + i;
				int newTime = player.time + 1;
				if (newIdx > 100) continue;
				if (event.containsKey(newIdx)) {
					newIdx = event.get(newIdx);
				}
				if (dp[newIdx] < newTime) continue;
				dp[newIdx] = newTime;
				if (newIdx == 100) continue;
				qu.add(new Player(newIdx, newTime));
			}
		}
	}
}