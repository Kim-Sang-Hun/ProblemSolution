import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Set<Integer> set = new HashSet<>();
			set.add(0);
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				Set<Integer> clone = new HashSet<>(set);
				Iterator<Integer> iterator = clone.iterator();
				while (iterator.hasNext()) {
					set.add(iterator.next() + tmp);
				}
			}
			sb.append("#" + tc + " " + set.size() + "\n");
		}
		System.out.print(sb);
	}
}