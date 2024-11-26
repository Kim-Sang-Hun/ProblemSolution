import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] cards = new int[M];
		parent = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		// parent[M] = M;
		Arrays.sort(cards);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cardNum = Integer.parseInt(st.nextToken());
			int idx = find(binarySearch(cards, cardNum));
			sb.append(cards[idx]).append(System.lineSeparator());
			union(idx, idx + 1);
		}
		System.out.print(sb);
	}

	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		int f = find(a);
		int s = find(b);
		if (f == s) return false;
		if (f > s) {
			parent[s] = f;
		}
		if (f <= s) {
			parent[f] = s;
		}
		return true;
	}

	private static int binarySearch(int[] cards, int cardNum) {
		int left = 0;
		int right = cards.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int cur = cards[mid];
			if (cur <= cardNum) {
				left = mid + 1;
			}
			if (cur > cardNum) {
				right = mid - 1;
			}
		}
		return left;
	}
}
