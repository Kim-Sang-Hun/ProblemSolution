import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int aX, aY, bX, bY, sum, time, chargerAmount, aMove[], bMove[];
	static BC[] chargers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			aX = 1;
			aY = 1;
			bX = 10;
			bY = 10;
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			chargerAmount = Integer.parseInt(st.nextToken());
			aMove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			bMove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			chargers = new BC[chargerAmount];
			for (int i = 0; i < chargerAmount; i++) {
				st = new StringTokenizer(br.readLine());
				chargers[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			chargeMax();
			getMax();
			sb.append("#" + tc + " " + sum + System.lineSeparator());
		}
		System.out.print(sb);
	}

	static void getMax() {
		for (int i = 0; i < time; i++) {
			// 움직임에 맞춰 좌표변경
			if (aMove[i] == 1) {
				--aY;
			} else if (aMove[i] == 2) {
				++aX;
			} else if (aMove[i] == 3) {
				++aY;
			} else if (aMove[i] == 4) {
				--aX;
			}
			if (bMove[i] == 1) {
				--bY;
			} else if (bMove[i] == 2) {
				++bX;
			} else if (bMove[i] == 3) {
				++bY;
			} else if (bMove[i] == 4) {
				--bX;
			}
			chargeMax();
		}
	}

	static void chargeMax() {
		// 가능한 Battery Charger list로 받아오기
		List<BC> A = new ArrayList<>();
		List<BC> B = new ArrayList<>();
		for (int i = 0; i < chargers.length; i++) {
			BC charger = chargers[i];
			if (Math.abs(aY - charger.y) + Math.abs(aX - charger.x) <= charger.coverage) {
				A.add(charger);
			}
			if (Math.abs(bY - charger.y) + Math.abs(bX - charger.x) <= charger.coverage) {
				B.add(charger);
			}
		}
		int max = 0;

		// 둘 다 비어있지 않다면 for문 돌면서 가장 높은 값 가져오기
		// 만약 같은 charger를 보고 있다면 하나의 performance값만 가져오기
		if (!A.isEmpty() && !B.isEmpty()) {
			for (int i = 0; i < A.size(); i++) {
				for (int j = 0; j < B.size(); j++) {
					BC chargerA = A.get(i);
					BC chargerB = B.get(j);
					if (chargerA.equals(chargerB)) {
						max = Math.max(max, chargerA.performance);
					} else {
						max = Math.max(max, chargerA.performance + chargerB.performance);
					}
				}
			}
		} else if (!A.isEmpty()) {
			for (int i = 0; i < A.size(); i++) {
				max = Math.max(max, A.get(i).performance);
			}
		} else if (!B.isEmpty()) {
			for (int i = 0; i < B.size(); i++) {
				max = Math.max(max, B.get(i).performance);
			}
		}
		sum += max;
	}

	static class BC {
		int x;
		int y;
		int coverage;
		int performance;

		public BC(int x, int y, int coverage, int performance) {
			this.x = x;
			this.y = y;
			this.coverage = coverage;
			this.performance = performance;
		}
	}
}