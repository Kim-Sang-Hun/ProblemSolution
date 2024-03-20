import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] knows;
	static List<Integer>[] partyWent;
	static List<Integer>[] partyPeople;
	static boolean[] visited;
	static boolean[] trueParty;
	static List<Integer> start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		knows = new boolean[N + 1];
		partyWent = new List[N + 1];
		partyPeople = new List[M];
		visited = new boolean[M];
		trueParty = new boolean[M];
		start = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			partyWent[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			partyPeople[i] = new ArrayList<>();
		}
		for (int i = 0; i < truth; i++) {
			int p = Integer.parseInt(st.nextToken());
			knows[p] = true;
			start.add(p);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			for (int j = 0; j < person; j++) {
				int p = Integer.parseInt(st.nextToken());
				partyWent[p].add(i);
				partyPeople[i].add(p);
			}
		}
		bfs();
		int cnt = 0;
		for (int i = 0; i < trueParty.length; i++) {
			if (!trueParty[i]) ++cnt;
		}
		System.out.println(cnt);
	}
	
	private static void bfs() {
		for (int i = 0; i < start.size(); i++) {
			Queue<Integer> qu = new ArrayDeque<>();
			qu.add(start.get(i));
			
			while (!qu.isEmpty()) {
				int no = qu.poll();
				List<Integer> parties = partyWent[no];
				for (int party : parties) {
					trueParty[party] = true;
					List<Integer> peoples = partyPeople[party];
					for (int people : peoples) {
						if (!knows[people]) {
							knows[people] = true;
							qu.add(people);
						}
					}
				}
			}
		}
	}
}