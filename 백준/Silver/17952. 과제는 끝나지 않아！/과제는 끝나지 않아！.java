import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static class Job {
		int score, cost;

		public Job(int score, int cost) {
			this.score = score;
			this.cost = cost;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Job> stack = new Stack<>();
		int totalScore = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int added = Integer.parseInt(st.nextToken());
			if (added == 1) {
				int score = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				stack.add(new Job(score, cost));
			}
			if (!stack.isEmpty()) {
				Job cur = stack.peek();
				if (--cur.cost == 0) {
					stack.pop();
					totalScore += cur.score;
				}
			}
		}
		System.out.println(totalScore);
	}

}