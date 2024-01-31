import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		arr[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(arr[end] - (start == 1 ? 0 : arr[start - 1]));
		}
	}
}