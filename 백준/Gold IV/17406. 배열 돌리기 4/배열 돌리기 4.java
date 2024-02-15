import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, min = Integer.MAX_VALUE, map[][], rotateOps[][];
	static int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int dirsD[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int order[];
	static boolean selected[];
	
	public static void rotate(int y, int x, int len) {
		if (len == 0) return;
		int nY = y - len, nX = x - len;
		int startPointValue = map[nY + 1][nX];
		int preValue = map[nY][nX];
		int tmpValue;
		for (int i = 0; i < dirs.length; i++) {
			for (int j = 0; j < 2 * len; j++) {
				nY += dirs[i][0];
				nX += dirs[i][1];
				tmpValue = map[nY][nX];
				map[nY][nX] = preValue;
				preValue = tmpValue;
			}
		}
		map[y - len][x - len] = startPointValue;
		rotate(y, x, len - 1);
	}
	
	public static void deRotate(int y, int x, int len) {
		if (len == 0) return;
		int nY = y - len, nX = x - len;
		int startPointValue = map[nY][nX + 1];
		int preValue = map[nY][nX];
		int tmpValue;
		for (int i = 0; i < dirs.length; i++) {
			for (int j = 0; j < 2 * len; j++) {
				nY += dirsD[i][0];
				nX += dirsD[i][1];
				tmpValue = map[nY][nX];
				map[nY][nX] = preValue;
				preValue = tmpValue;
			}
		}
		map[y - len][x - len] = startPointValue;
		deRotate(y, x, len - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rotateOps = new int[K][3];
		order = new int[K];
		selected = new boolean[K];
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotateOps[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rotateOps[i][1] = Integer.parseInt(st.nextToken()) - 1;
			rotateOps[i][2] = Integer.parseInt(st.nextToken());
		}
		perpetual(0);
		System.out.println(min);
	}

	public static void perpetual(int count) {
		if (count == K) {
			for (int i = 0; i < K; i++) {
				rotate(rotateOps[order[i]][0], rotateOps[order[i]][1], rotateOps[order[i]][2]);
			}
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < M; j++) {
					tmp += map[i][j];
				}
				min = Math.min(min, tmp);
			}
			for (int i = K - 1; i >= 0; i--) {
				deRotate(rotateOps[order[i]][0], rotateOps[order[i]][1], rotateOps[order[i]][2]);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			order[count] = i;
			perpetual(count + 1);
			selected[i] = false;
		}
	}
}