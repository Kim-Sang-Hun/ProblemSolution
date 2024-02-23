import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, highScore;
	static int[] hitOrder;
	static int[][] expected;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		expected = new int[N][9];
		visited = new boolean[9];
		hitOrder = new int[9];
		hitOrder[3] = 0;
		visited[0] = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				expected[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perpetual(0);
		System.out.println(highScore);
	}

	public static void perpetual(int count) {
		if (count == 9) {
			getScore();
			return;
		}
		if (count == 3) {
			perpetual(count + 1);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			hitOrder[count] = i;
			perpetual(count + 1);
			visited[i] = false;
		}
	}

	public static void getScore() {
		int hitter = 0;
		int score = 0;
		int out = 0;
		int inning = 0;
		Queue<Integer> q = new LinkedList<>();
		while (inning < N) {
			int hit = expected[inning][hitOrder[hitter++ % 9]];
			int qSize = q.size();
			if (hit == 0) {
				++out;
			} else if (hit == 1 || hit == 2) {
				for (int i = 0; i < qSize; i++) {
					int tmp = q.poll();
					if (tmp + hit >= 4) {
						++score;
					} else {
						q.add(tmp + hit);
					}
				}
				q.add(hit);
			} else if (hit == 3) {
				score += q.size();
				q.clear();
				q.add(hit);
			} else if (hit == 4) {
				score += q.size();
				q.clear();
				++score;
			}
			if (out == 3) {
				++inning;
				out = 0;
				q.clear();
			}
		}
		if (highScore < score) {
			highScore = score;
		}
	}
}