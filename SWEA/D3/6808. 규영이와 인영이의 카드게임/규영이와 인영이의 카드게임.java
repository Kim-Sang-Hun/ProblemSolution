import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static int[] GY, IY, leftCard, perpetual;
	static boolean[] selected;
	static int GYWin, IYWin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			GY = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.sorted()
					.toArray();
			IY = new int[GY.length];
			leftCard = new int[GY.length];
			selected = new boolean[GY.length];
			
			for (int i = 1, idx = 0; i <= 18; i++) {
				boolean flag = false;
				for (int j = 0; j < GY.length; j++) {
					if (GY[j] == i) {
						flag = true;
						break;
					}
				}
				if (flag) continue;
				leftCard[idx++] = i;
			}
			GYWin = 0;
			IYWin = 0;
			perpetual(0);
			sb.append("#" + tc + " " + GYWin + " " + IYWin + System.lineSeparator());
		}
		System.out.print(sb);
	}
	
	public static void perpetual(int count) {
		if (count == 9) {
			checkWinner();
			return;
		}
		
		for (int i = 0; i < IY.length; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			IY[count] = leftCard[i];
			perpetual(count + 1);
			selected[i] = false;
		}
		
	}
	
	public static void checkWinner() {
		int GYPoint = 0;
		int IYPoint = 0;
		for (int i = 0; i < GY.length; i++) {
			if (GY[i] > IY[i]) {
				GYPoint += GY[i] + IY[i];
			} else if (GY[i] < IY[i]) {
				IYPoint += GY[i] + IY[i];
			}
		}
		if (GYPoint > IYPoint) ++GYWin;
		else if (GYPoint < IYPoint) ++IYWin;
	}
	
}