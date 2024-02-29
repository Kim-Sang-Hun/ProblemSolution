import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static List<People> peoples;
	static List<Stair> stairs;
	static boolean[] selected;
	static int minTime;
	
	static class People {
		int y, x, t1, t2;

		public People(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static class Stair {
		int y, x, len;

		public Stair(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			peoples = new ArrayList<>();
			stairs = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());
					if (cur == 0) continue;
					if (cur == 1) peoples.add(new People(i, j));
					else stairs.add(new Stair(i, j, cur));
				}
			}
			minTime = Integer.MAX_VALUE;
			Stair s1 = stairs.get(0);
			Stair s2 = stairs.get(1);
			for (int i = 0; i < peoples.size(); i++) {
				People cur = peoples.get(i);
				cur.t1 = Math.abs(cur.y - s1.y) + Math.abs(cur.x - s1.x);
				cur.t2 = Math.abs(cur.y - s2.y) + Math.abs(cur.x - s2.x);
			}
			select();
			sb.append("#" + tc + " " + (minTime + 1)).append(System.lineSeparator());
		}
		System.out.println(sb);
	}

	private static void select() {
		int size = peoples.size();
		
		for (int i = 0; i < 1 << size; i++) {
			selected = new boolean[size];
			for (int j = 0; j < size; j++) {
				if ((i & 1 << j) != 0) {
					selected[j] = true;
				}
			}
			getTime();
		}
	}

	private static void getTime() {
		PriorityQueue<Integer> firstStair = new PriorityQueue<>();
		PriorityQueue<Integer> secondStair = new PriorityQueue<>();
		Queue<Integer> onStair1 = new LinkedList<>();
		Queue<Integer> onStair2 = new LinkedList<>();
		Stair s1 = stairs.get(0);
		Stair s2 = stairs.get(1);
		
		for (int i = 0; i < peoples.size(); i++) {
			People cur = peoples.get(i);
			if (!selected[i]) firstStair.add(cur.t1);
			else secondStair.add(cur.t2);
		}
		int firstTime = 0;
		int secondTime = 0;
		
		while (!firstStair.isEmpty()) {
			int tmpTime = firstStair.poll();
			if (firstTime < tmpTime) {
				firstTime = tmpTime;
			}
			if (onStair1.size() < 3) {
				onStair1.add(firstTime);
			} else {
				firstTime = Math.max(firstTime, onStair1.poll() + s1.len);
				onStair1.add(firstTime);
			}
		}
		while (!secondStair.isEmpty()) {
			int tmpTime = secondStair.poll();
			if (secondTime < tmpTime) {
				secondTime = tmpTime;
			}
			if (onStair2.size() < 3) {
				onStair2.add(secondTime);
			} else {
				secondTime = Math.max(secondTime, onStair2.poll() + s2.len);
				onStair2.add(secondTime);
			}
		}
		while (!onStair1.isEmpty()) {
			firstTime = onStair1.poll() + s1.len;
		}
		while (!onStair2.isEmpty()) {
			secondTime = onStair2.poll() + s2.len;
		}
		minTime = Math.min(Math.max(firstTime, secondTime), minTime);
	}
	
}