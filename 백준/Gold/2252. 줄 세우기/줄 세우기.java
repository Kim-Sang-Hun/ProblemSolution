import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] students = new int[N + 1];
		List<List<Integer>> compares = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			compares.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			compares.get(first).add(second);
			++students[second];
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (students[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			
			for (int student : compares.get(cur)) {
				if (--students[student] == 0) {
					q.add(student);
				}
			}
		}
		
		System.out.println(sb);
	}

}