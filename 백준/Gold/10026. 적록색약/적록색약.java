import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, countNormal, countRG;
	static char[][] map;
	static boolean[][] visitedNormal;
	static boolean[][] visitedRG;
	static int[] dirY = {0, 0, -1, 1};
	static int[] dirX = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visitedNormal = new boolean[N][N];
		visitedRG = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedNormal[i][j])
					countNormal++;
					bfsNormal(i, j);
				if (!visitedRG[i][j])
					countRG++;
					bfsRG(i, j);
			}
		}
		System.out.println(countNormal + " " + countRG);
	}
	
	public static void bfsNormal(int y, int x) {
		visitedNormal[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nY = cur[0] + dirY[i];
				int nX = cur[1] + dirX[i];
				
				if (nY >= N || nX >= N || nY < 0 || nX < 0 || visitedNormal[nY][nX] || map[curY][curX] != map[nY][nX]) continue;
				visitedNormal[nY][nX] = true;
				q.add(new int[] {nY, nX});
			}
		}
	}

	public static void bfsRG(int y, int x) {
		visitedRG[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			char curColor = map[curY][curX];
			
			for (int i = 0; i < 4; i++) {
				int nY = curY + dirY[i];
				int nX = curX + dirX[i];
				
				if (nY >= N || nX >= N || nY < 0 || nX < 0 || visitedRG[nY][nX]) continue;
				if (curColor == 'R' || curColor == 'G') {
					if (map[nY][nX] == 'B') continue;
				} else if (curColor != map[nY][nX]) continue;
				
				visitedRG[nY][nX] = true;
				q.add(new int[] {nY, nX});
			}
		}
	}
}