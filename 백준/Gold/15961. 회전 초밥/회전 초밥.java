import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, maxType, tmpType;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		tmpType = 1;
		Map<Integer, Integer> sushiCount = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			int type = sushi[i];
			if (q.size() == k) {
				int cur = q.poll();
				if (cur != c) {
					sushiCount.put(cur, sushiCount.get(cur) - 1);
					if (sushiCount.get(cur) == 0) --tmpType;
				}
			}
			q.add(type);
			if (type != c) {
				sushiCount.put(type, sushiCount.getOrDefault(type, 0) + 1);
				if (sushiCount.get(type) == 1) ++tmpType;
			}
			
			if (maxType < tmpType) {
				maxType = tmpType;
			}
		}
		for (int i = 0; i < k; i++) {
			int type = sushi[i];
			if (q.size() == k) {
				int cur = q.poll();
				if (cur != c) {
					sushiCount.put(cur, sushiCount.get(cur) - 1);
					if (sushiCount.get(cur) == 0) --tmpType;
				}
			}
			q.add(type);
			if (type != c) {
				sushiCount.put(type, sushiCount.getOrDefault(type, 0) + 1);
				if (sushiCount.get(type) == 1) ++tmpType;
			}
			
			if (maxType < tmpType) {
				maxType = tmpType;
			}
		}
		
		
		System.out.println(maxType);
	}

}