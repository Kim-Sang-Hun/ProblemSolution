import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, map[][];
	static int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void goAndRight(int y, int x, int dir, int count) {
		map[y][x] = count;
		int nY = y + dirs[dir][0];
		int nX = x + dirs[dir][1];
		if (nY < 0 || nX < 0 || nY >= N || nX >= N || map[nY][nX] != 0) {
			if (count == N * N) return;
			goAndRight(y, x, (dir + 1) % 4, count);
		} else {
			goAndRight(nY, nX, dir, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			goAndRight(0, 0, 0, 1);
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}