import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static int[][] map;
	static Set<Integer>[] row;
	static Set<Integer>[] col;
	static Set<Integer>[][] square;
	static List<int[]> remaining;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		row = new Set[9];
		col = new Set[9];
		square = new Set[3][3];
		remaining = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			row[i] = new HashSet<>();
			col[i] = new HashSet<>();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				square[i][j] = new HashSet<>();
			}
		}
		
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				int cur = line.charAt(j) - '0';
				map[i][j] = cur;
				 
				if (cur != 0) {
					row[i].add(cur);
					col[j].add(cur);
					square[i/3][j/3].add(cur);
				} else {
					remaining.add(new int[] {i, j});
				}
			}
		}
		
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int count) {
		if (count == remaining.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		if (sb.length() != 0) {
			return;
		}
		
		int[] cur = remaining.get(count);
		int y = cur[0];
		int x = cur[1];
		int sy = y / 3;
		int sx = x / 3;
		for (int i = 1; i <= 9; i++) {
			if (row[y].contains(i) || col[x].contains(i) || square[sy][sx].contains(i)) continue;
			row[y].add(i);
			col[x].add(i);
			square[sy][sx].add(i);
			map[y][x] = i;
			
			dfs(count + 1);
			
			row[y].remove(i);
			col[x].remove(i);
			square[sy][sx].remove(i);
			map[y][x] = 0;
		}
	}
}