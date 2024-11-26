import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		parents = new int[G + 1];
		for (int i = 1; i < G + 1; i++) {
			parents[i] = i;
		}
		int P = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			int input = Integer.parseInt(br.readLine());
			int max = find(input);
			if (max == 0) {
				System.out.println(cnt);
				return;
			}
			++cnt;
			union(max, max - 1);
		}
		System.out.println(cnt);
	}

	static int[] parents;
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a > b) {
			parents[a] = b;
		} else {
			parents[b] = a;
		}
	}
}
