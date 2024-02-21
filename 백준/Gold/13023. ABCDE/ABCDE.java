import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;

	static int answer = 0;
	static boolean visited[];
	static Person[] peoples;

	public static class Person {
		List<Integer> list;
		public Person(List<Integer> list) {
			this.list = list;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		peoples = new Person[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			peoples[i] = new Person(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			peoples[a].list.add(b);
			peoples[b].list.add(a);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 1);
		}

		System.out.println(answer);
	}
	
	static void dfs(int num, int count) {
		if (answer == 1) return;
		if (count == 5) {
			answer = 1;
			return;
		}
		visited[num] = true;
		List<Integer> list = peoples[num].list;
		for (int i = 0; i < list.size(); i++) {
			int next = list.get(i);
			if (visited[next]) continue;
			
			visited[next] = true;
			dfs(next, count + 1);
			visited[next] = false;
		}
		visited[num] = false;
	}
}