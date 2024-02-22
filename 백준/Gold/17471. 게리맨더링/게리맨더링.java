import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] districts;
	static int totalPopulation;
	static int minDiff = Integer.MAX_VALUE;
	static boolean[] selected;
	static boolean connected;
	static List<List<Integer>> linkedDistricts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		districts = new int[N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			districts[i] = Integer.parseInt(st.nextToken());
			totalPopulation += districts[i];
		}
		
		linkedDistricts = new ArrayList<>();
		linkedDistricts.add(new ArrayList<>());
		for (int i = 0; i < N; i++) {
			linkedDistricts.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for (int j = 0; j < T; j++) {
				int linkedDistrict = Integer.parseInt(st.nextToken());
				linkedDistricts.get(i).add(linkedDistrict - 1);
			}
		}
		
		//subset
		for (int i = 1; i < (1 << N) - 1; ++i) {
			Arrays.fill(selected, false);
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					selected[j] = true;
				}
			}
			getResult();
		}
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
	}

	private static void getResult() {
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				aList.add(i);
			} else bList.add(i);
		}
		
		if (check(aList) && check(bList)) {
			getDiff();
		}
	}
	
	private static void getDiff() {
		int aSum = 0;
		int bSum = 0;
		for (int i = 0; i < districts.length; i++) {
			if (selected[i]) {
				aSum += districts[i];
			} else bSum += districts[i];
		}
		minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
	}

	public static boolean check(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		visited[list.get(0)] = true;
		q.add(list.get(0));
		
		int count = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			List<Integer> nexts = linkedDistricts.get(cur);
			for (int next : nexts) {
				if (list.contains(next) && !visited[next]) {
					visited[next] = true;
					q.add(next);
					++count;
				}
			}
		}
		return count == list.size();
	}

}