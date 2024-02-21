import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, emptyCount, minEmpty;
	static int[][] map;
	static int[] dirY = {0, 1, 0, -1};
	static int[] dirX = {1, 0, -1, 0};
	static boolean[][] visited;
	static List<int[]> CCTV;
	static int[] directions;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		CCTV = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0 && tmp != 6) {
					CCTV.add(new int[] {i, j, tmp});
				} else if (tmp == 0) ++emptyCount;
				map[i][j] = tmp;
			}
		}
		minEmpty = Integer.MAX_VALUE;
		directions = new int[CCTV.size()];
		getDirections(0);
		System.out.println(minEmpty);
	}
	
	public static void getDirections(int count) {
		if (count == CCTV.size()) {
			minEmpty = Math.min(minEmpty, emptyCount - mark());
			return;
		}
		for (int i = 0; i < 4; i++) {
			directions[count] = i;
			getDirections(count + 1);
		}
		
	}
	
	public static int mark() {
		visited = new boolean[N][M];
		int sum = 0;
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < CCTV.size(); i++) {
			int[] cctv = CCTV.get(i);
			int direction = directions[i];
			int type = cctv[2];
			int nY = cctv[0] + dirY[direction];
			int nX = cctv[1] + dirX[direction];
			
			if (!isOut(nY, nX)) {
				q.add(new int[] {nY, nX, direction});
			}
			if (type == 2 || type == 4 || type == 5) {
				int back = (direction + 2) % 4;
				nY = cctv[0] + dirY[back];
				nX = cctv[1] + dirX[back];
				if (!isOut(nY, nX)) {
					q.add(new int[] {nY, nX, back});
				}
			}
			if (type == 3 || type == 4 || type == 5) {
				int left = (direction + 3) % 4;
				nY = cctv[0] + dirY[left];
				nX = cctv[1] + dirX[left];
				if (!isOut(nY, nX)) {
					q.add(new int[] {nY, nX, left});
				}
			}
			if (type == 5) {
				int right = (direction + 1) % 4;
				nY = cctv[0] + dirY[right];
				nX = cctv[1] + dirX[right];
				if (!isOut(nY, nX)) {
					q.add(new int[] {nY, nX, right});
				}
			}
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (!visited[now[0]][now[1]] && map[now[0]][now[1]] == 0) {
				++sum;
				visited[now[0]][now[1]] = true;
			}
			int nY = now[0] + dirY[now[2]];
			int nX = now[1] + dirX[now[2]];
			
			if (!isOut(nY, nX)) {
				q.add(new int[] {nY, nX, now[2]});
			}
		}
		return sum;
	}
	
	public static boolean isOut(int a, int b) {
		return (a >= N || a < 0 || b >= M || b < 0 || map[a][b] == 6);
	}
}