import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<int[]> homes, chickens;
	static int[] picked;
	static int chickenLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					homes.add(new int[] { i, j });
				} else if (tmp == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}
		chickenLen = Integer.MAX_VALUE;
		picked = new int[M];
		combi(0, 0);

		System.out.println(chickenLen);
	}
	
	public static void combi(int count, int start) {
		if (count == M) {
			int sum = 0;
			for (int[] home : homes) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < M; i++) {
					int[] chicken = chickens.get(picked[i]);
					int tmp = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
					if (tmp < min) {
						min = tmp;
					}
				}
				sum += min;
				if (sum >= chickenLen) return;
			}
			if (sum < chickenLen) {
				chickenLen = sum;
			}
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			picked[count] = i;
			combi(count + 1, i + 1);
		}
		
	}
	
}