import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			List<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int operationTime = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < operationTime; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int times = Integer.parseInt(st.nextToken());
				
				for (int j = idx; j < idx + times; j++) {
					list.add(j, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("#" + tc);
			for (int i = 0; i < 10; i++) {
				sb.append(" " + list.get(i));
			}
			sb.append(System.lineSeparator());
		}
		System.out.print(sb);
	}

}