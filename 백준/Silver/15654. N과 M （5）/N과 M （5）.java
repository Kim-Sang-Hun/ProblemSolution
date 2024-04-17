import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int[] str, arr;
	static boolean[] visited;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		str = new int[m];
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		perpetual(0);
		System.out.println(sb);
	}
	private static void perpetual(int i) {
		if (i == m) {
			for (int j = 0; j < str.length; j++) {
				sb.append(str[j] + " ");
			}
			sb.append(System.lineSeparator());
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (!visited[j]) {
				visited[j] = true;
				str[i] = arr[j];
				perpetual(i + 1);
				visited[j] = false;
			}
		}
	}
}