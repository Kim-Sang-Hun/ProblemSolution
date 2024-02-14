import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb;
	static char[][] video;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new char[N][];
		for (int i = 0; i < N; i++) {
			video[i] = br.readLine().toCharArray();
		}
		sb = new StringBuilder();
		compress(0, 0, N);
		System.out.print(sb);
	}
	
	public static void compress(int y, int x, int len) {
		char pivot = video[y][x];
		boolean isEqual = true;
		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (pivot != video[i][j]) {
					isEqual = false;
					break;
				}
			}
		}
		if (isEqual) {
			sb.append(pivot);
		} else {
			sb.append('(');
			compress(y, x, len / 2);
			compress(y, x + len / 2, len / 2);
			compress(y + len / 2, x, len / 2);
			compress(y + len / 2, x + len / 2, len / 2);
			sb.append(')');
		}
	}
}