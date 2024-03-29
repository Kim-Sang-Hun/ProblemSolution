import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, max;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[2][N];
			max = 0;
			for (int j = 0; j < map.length; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			if (N >= 2) {
				map[0][1] += map[1][0];
				map[1][1] += map[0][0];
			}
			if (N > 2) {
				for (int j = 2; j < N; j++) {
					map[0][j] += Math.max(map[1][j-1], map[1][j-2]);
					map[1][j] += Math.max(map[0][j-1], map[0][j-2]);
				}
			}
			System.out.println(Math.max(map[0][N-1], map[1][N-1]));
		}
	}
}