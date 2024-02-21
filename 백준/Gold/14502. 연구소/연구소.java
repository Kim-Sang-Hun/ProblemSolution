import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, safeSpot, spreadVirus, maxSafeSpot;
	static int[][] map;
	static int[] dirY = {0, 0, -1, 1};
	static int[] dirX = {-1, 1, 0, 0};
	static boolean[][] visited;
	static int[] walls;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		walls = new int[3];
		maxSafeSpot = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					++safeSpot;
				}
			}
		}
		safeSpot -= 3;
		combi(0, 0);
		System.out.println(maxSafeSpot);
	}

	public static void combi(int count, int start) {
		if (count == 3) {
			for (int i = 0; i < walls.length; i++) {
				map[walls[i] / M][walls[i] % M] = 1;
			}
			bfs();
			for (int i = 0; i < walls.length; i++) {
				map[walls[i] / M][walls[i] % M] = 0;
			}
			int tmpSafeSpot = safeSpot - spreadVirus;
			if (maxSafeSpot < tmpSafeSpot) {
				maxSafeSpot = tmpSafeSpot;
			}
			return;
		}

		for (int i = start; i < N * M; i++) {
			if (map[i / M][i % M] == 0) {
				walls[count] = i;
				combi(count + 1, i + 1);
			}
		}

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];
		spreadVirus = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			if (safeSpot - spreadVirus < maxSafeSpot) return;
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nY = tmp[0] + dirY[i];
				int nX = tmp[1] + dirX[i];

				if (nY >= N || nX >= M || nY < 0 || nX < 0 || visited[nY][nX])
					continue;
				if (map[nY][nX] != 0)
					continue;
				++spreadVirus;
				visited[nY][nX] = true;
				q.add(new int[] { nY, nX });
			}

		}
	}
}