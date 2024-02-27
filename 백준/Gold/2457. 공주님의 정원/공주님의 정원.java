import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static class Project implements Comparable<Project> {
		int startM;
		int startD;
		int endM;
		int endD;

		public Project(int startM, int startD, int endM, int endD) {
			this.startM = startM;
			this.startD = startD;
			this.endM = endM;
			this.endD = endD;
		}

		@Override
		public int compareTo(Project o) {
			int comparingMonth = Integer.compare(this.startM, o.startM);
			int comparingDay = Integer.compare(this.startD, o.startD);

			return comparingMonth == 0 ? comparingDay : comparingMonth;
		}
	}
	
	static int cnt, curM, curD;
	static Project lastProject, tmp = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Project> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			list.add(new Project(startMonth, startDay, endMonth, endDay));
		}
		curM = 3;
		curD = 1;
		int maxM = curM;
		int maxD = curD;
		int idx = 0;
		Collections.sort(list);
		
		while (curM < 12 && idx < list.size()) {
			boolean canGoFurther = false;
			
			for (int i = idx; i < list.size(); i++) {
				Project cur = list.get(i);
				if (cur.startM > curM || cur.startM == curM && cur.startD > curD) break;
				if (maxM < cur.endM || maxM == cur.endM && maxD < cur.endD) {
					canGoFurther = true;
					maxM = cur.endM;
					maxD = cur.endD;
					idx = i + 1;
				}
			}
			if (canGoFurther) {
				++cnt;
				curM = maxM;
				curD = maxD;
			} else {
				break;
			}
		}
		
		if (curM < 12) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
		}
	}
	
}