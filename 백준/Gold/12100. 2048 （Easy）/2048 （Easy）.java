import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int N, maxBlock;
	static int[][] map;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		map = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j]) max = map[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			dfs(map, 0, max);
		}
		
		System.out.println(maxBlock);
//		System.out.println(sb);
	}

	public static void dfs(int[][] map, int depth, int max) {
		if (depth == 5) {
			if (maxBlock < max) {
				maxBlock = max;
			}
//			for (int j = 0; j < map.length; j++) {
//				for (int j2 = 0; j2 < map.length; j2++) {
//					sb.append(map[j][j2]+ " ");
//				}
//				sb.append(System.lineSeparator());
//			}
//			sb.append(System.lineSeparator());
			return;
		}
		if (max * Math.pow(2, 5 - depth) <= maxBlock) return;

		for (int i = 0; i < 4; i++) {
			int[][] tmp = new int[N][];
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = map[j].clone();
			}
			int tmpMax = goDir(tmp, i, max);
			dfs(tmp, depth + 1, tmpMax);
		}
	}

	public static int goDir(int[][] map, int dir, int max) {
		
		
		// 오른쪽으로 이동
		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				int startPoint = N - 2;
				int targetPoint = N - 1;

				while (targetPoint > 0) {
					while (startPoint > 0 && map[i][startPoint] == 0 || startPoint == targetPoint) {
						--startPoint;
					}
					if (startPoint < 0 || map[i][startPoint] == 0)
						break;
					
					if (map[i][targetPoint] == 0) {
						map[i][targetPoint] = map[i][startPoint];
						map[i][startPoint] = 0;
					} else {
						if (map[i][startPoint] == map[i][targetPoint]) {
							map[i][startPoint] = 0;
							map[i][targetPoint] *= 2;
							if (max < map[i][targetPoint]) max = map[i][targetPoint];
						}
						--targetPoint;
					}
				}
			}
		}
		// 아래로 이동
		if (dir == 1) {
			for (int i = 0; i < N; i++) {
				int startPoint = N - 2;
				int targetPoint = N - 1;

				while (targetPoint > 0) {
					while (startPoint > 0 && map[startPoint][i] == 0 || startPoint == targetPoint) {
						--startPoint;
					}
					if (startPoint < 0 || map[startPoint][i] == 0)
						break;
					if (max < map[startPoint][i]) max = map[startPoint][i];
					
					if (map[targetPoint][i] == 0) {
						map[targetPoint][i] = map[startPoint][i];
						map[startPoint][i] = 0;
					} else {
						if (map[startPoint][i] == map[targetPoint][i]) {
							map[startPoint][i] = 0;
							map[targetPoint][i] *= 2;
							if (max < map[targetPoint][i]) max = map[targetPoint][i];
						}
						--targetPoint;
					}
				}
			}
		}
		
		// 왼쪽으로 이동
		if (dir == 2) {
			for (int i = 0; i < N; i++) {
				int startPoint = 1;
				int targetPoint = 0;

				while (targetPoint < N - 1) {
					while (startPoint < N - 1 && map[i][startPoint] == 0 || startPoint == targetPoint) {
						++startPoint;
					}
					if (startPoint > N - 1 || map[i][startPoint] == 0)
						break;
					if (max < map[i][startPoint]) max = map[i][startPoint];
					
					if (map[i][targetPoint] == 0) {
						map[i][targetPoint] = map[i][startPoint];
						map[i][startPoint] = 0;
					} else {
						if (map[i][startPoint] == map[i][targetPoint]) {
							map[i][startPoint] = 0;
							map[i][targetPoint] *= 2;
							if (max < map[i][targetPoint]) max = map[i][targetPoint];
						}
						++targetPoint;
					}
				}
			}
		}
		
		// 위로 이동
		if (dir == 3) {
			for (int i = 0; i < N; i++) {
				int startPoint = 1;
				int targetPoint = 0;

				while (targetPoint < N - 1) {
					while (startPoint < N - 1 && map[startPoint][i] == 0 || startPoint == targetPoint) {
						++startPoint;
					}
					if (startPoint > N - 1 || map[startPoint][i] == 0)
						break;
					if (max < map[startPoint][i]) max = map[startPoint][i];
					
					if (map[targetPoint][i] == 0) {
						map[targetPoint][i] = map[startPoint][i];
						map[startPoint][i] = 0;
					} else {
						if (map[startPoint][i] == map[targetPoint][i]) {
							map[startPoint][i] = 0;
							map[targetPoint][i] *= 2;
							if (max < map[targetPoint][i]) max = map[targetPoint][i];
						}
						++targetPoint;
					}
				}
			}
		}

		return max;
	}

}