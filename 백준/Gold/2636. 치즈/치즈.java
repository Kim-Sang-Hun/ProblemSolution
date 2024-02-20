import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, remainingCheese;
	static int[][] map;
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, 1, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					++remainingCheese;
				}
			}
		}
		int countLastCheese = 0;
		int time = 0;
		while (remainingCheese > 0) {
			countLastCheese = remainingCheese;
			++time;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			// 다음으로 녹을 치즈들 마크
			bfs();
		}
		System.out.println(time);
		System.out.println(countLastCheese);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nY = cur[0] + dirY[i];
				int nX = cur[1] + dirX[i];
				
				if (nY < 0 || nY >= N || nX < 0 || nX >= M || visited[nY][nX]) continue;
				visited[nY][nX] = true;
				
				if (map[nY][nX] == 0) {
					q.add(new int[] {nY, nX});
				} else {
					map[nY][nX] = 0;
					--remainingCheese;
				}
			}
		}
	}
}