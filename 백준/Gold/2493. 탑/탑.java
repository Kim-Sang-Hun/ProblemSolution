import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] < tmp) {
					stack.pop();
				} else {
					break;
				}
			}
			if (stack.isEmpty()) {
				sb.append(0 + " ");
			} else {
				sb.append(stack.peek()[0] + 1 + " ");
			}
			stack.push(new int[] {i, tmp});			
		}
		System.out.print(sb);
	}
}