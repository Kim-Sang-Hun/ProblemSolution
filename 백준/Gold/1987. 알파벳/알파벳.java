import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int max;
	static Set<Character> set = new HashSet<>();
	static int[] dirY = {0, 1, 0, -1};
	static int[] dirX = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited[0][0] = true;
		set.add(map[0][0]);
		dfs(0, 0);
		System.out.println(max);
	}

	public static void dfs(int y, int x) {
		boolean isEnd = true;
		for (int i = 0; i < 4; i++) {
			int nY = y + dirY[i];
			int nX = x + dirX[i];
			if (nY >= R || nY < 0 || nX >= C || nX < 0 || visited[nY][nX] || set.contains(map[nY][nX])) continue;
			isEnd = false;
			visited[nY][nX] = true;
			set.add(map[nY][nX]);
			dfs(nY, nX);
			visited[nY][nX] = false;
			set.remove(map[nY][nX]);
		}
		if (isEnd) {
			max = Math.max(max, set.size());
		}
	}
}