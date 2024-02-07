import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	public static void func1() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[N - 1 - i][j];
			}
		}
		map = tmp;
	}
	public static void func2() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[j][i] = map[j][M - 1 - i];
			}
		}
		map = tmp;
	}
	public static void func3() {
		int[][] tmp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[N - 1 - j][i];
			}
		}
		map = tmp;
		int Y = M;
		M = N;
		N = Y;
	}
	public static void func4() {
		int[][] tmp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[j][M - 1 - i];
			}
		}
		map = tmp;
		int Y = M;
		M = N;
		N = Y;
	}
	public static void func5() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][j] = map[i + N / 2][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[i][j] = map[i][j - M / 2];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[i][j] = map[i - N / 2][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][j] = map[i][j + M / 2];
			}
		}
		
		map = tmp;
	}
	public static void func6() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][j] = map[i][j + M / 2];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[i][j] = map[i + N / 2][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[i][j] = map[i][j - M / 2];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][j] = map[i - N / 2][j];
			}
		}
		map = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int funcNum = Integer.parseInt(st.nextToken());
			switch (funcNum) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append(System.lineSeparator());
		}
		System.out.print(sb);
	}
}