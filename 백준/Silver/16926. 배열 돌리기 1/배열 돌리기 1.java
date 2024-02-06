import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int N, M, R;
	static int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static void rotate(int depth) {
		if (depth == N / 2) return;
		
		int limitY = N - depth;
		int limitX = M - depth;
		int y = depth;
		int x = depth;
		int startNum = arr[depth][depth];
		if (limitY - y < 2 || limitX - x < 2) return;
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				while (y + dirs[i][0] < limitY && x + dirs[i][1] < limitX
						&& y + dirs[i][0] >= depth && x + dirs[i][1] >= depth) {
					arr[y][x] = arr[y + dirs[i][0]][x + dirs[i][1]];
					y += dirs[i][0];
					x += dirs[i][1];
				}
			} else {
				while (y + dirs[i][0] < limitY && x + dirs[i][1] < limitX
						&& y + dirs[i][0] >= depth && x + dirs[i][1] >= depth) {
					arr[y][x] = arr[y + dirs[i][0]][x + dirs[i][1]];
					y += dirs[i][0];
					x += dirs[i][1];
				}
			}
		}
		arr[depth+1][depth] = startNum;
		rotate(depth + 1);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		R = s.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			rotate(0);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append(System.lineSeparator());
		}
		System.out.print(sb);
	}
}