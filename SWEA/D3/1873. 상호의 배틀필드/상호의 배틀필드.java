import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int H, W;
	static int Y, X;
	static char dir;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			Y = -1;
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				
				// 전차의 위치와 방향을 확인해준다.
				for (int j = 0; j < W; j++) {
					if (Y != -1) break;
					switch (map[i][j]) {
					case '^':
						dir = 'U';
						Y = i;
						X = j;
						break;
					case 'v':
						dir = 'D';
						Y = i;
						X = j;
						break;
					case '<':
						dir = 'L';
						Y = i;
						X = j;
						break;
					case '>':
						dir = 'R';
						Y = i;
						X = j;
						break;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			char[] input = new char[N];
			input = br.readLine().toCharArray();
			
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case 'U':
					up();
					break;
				case 'D':
					down();
					break;
				case 'L':
					left();
					break;
				case 'R':
					right();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append(System.lineSeparator());
			}
		}
		System.out.print(sb);
	}

	public static void up() {
		dir = 'U';
		map[Y][X] = '^';
		if (Y - 1 >= 0 && map[Y - 1][X] == '.') {
			map[Y - 1][X] = '^';
			map[Y][X] = '.';
			Y = Y - 1;
		}
	}
	
	public static void down() {
		dir = 'D';
		map[Y][X] = 'v';
		if (Y + 1 < H && map[Y + 1][X] == '.') {
			map[Y + 1][X] = 'v';
			map[Y][X] = '.';
			Y = Y + 1;
		}
	}
	public static void left() {
		dir = 'L';
		map[Y][X] = '<';
		if (X - 1 >= 0 && map[Y][X - 1] == '.') {
			map[Y][X - 1] = '<';
			map[Y][X] = '.';
			X = X - 1;
		}
	}
	public static void right() {
		dir = 'R';
		map[Y][X] = '>';
		if (X + 1 < W && map[Y][X + 1] == '.') {
			map[Y][X + 1] = '>';
			map[Y][X] = '.';
			X = X + 1;
		}
	}
	public static void shoot() {
		int bY = Y;
		int bX = X;
		switch (dir) {
		case 'U':
			while (--bY >= 0) {
				if (map[bY][bX] == '*') {
					map[bY][bX] = '.';
					break;
				}
				if (map[bY][bX] == '#') {
					break;
				}
			}
			break;
		case 'D':
			while (++bY < H) {
				if (map[bY][bX] == '*') {
					map[bY][bX] = '.';
					break;
				}
				if (map[bY][bX] == '#') {
					break;
				}
			}
			break;
		case 'L':
			while (--bX >= 0) {
				if (map[bY][bX] == '*') {
					map[bY][bX] = '.';
					break;
				}
				if (map[bY][bX] == '#') {
					break;
				}
			}
			break;
		case 'R':
			while (++bX < W) {
				if (map[bY][bX] == '*') {
					map[bY][bX] = '.';
					break;
				}
				if (map[bY][bX] == '#') {
					break;
				}
			}
			break;
		}
	}
}