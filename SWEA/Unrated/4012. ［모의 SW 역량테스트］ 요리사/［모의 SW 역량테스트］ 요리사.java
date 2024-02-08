import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static int[][] ingredients;
	static int N, minDiff;
	static int[] foodA;
	static int[] foodB;
	
	public static void calcDiff() {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				sumA += ingredients[foodA[i]][foodA[j]];
				sumB += ingredients[foodB[i]][foodB[j]];
			}
		}
		minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
	}
	
	public static void combi(int count, int start) {
		if (count == N / 2) {
			List<Integer> foodAList = new ArrayList<>();
			for (int i = 0; i < foodA.length; i++) {
				foodAList.add(foodA[i]);
			}
			for (int i = 0, j = 0; j < N / 2 && i < N;) {
				if (!foodAList.contains(i)) {
					foodB[j++] = i++;
				} else {
					++i;
				}
			}
			calcDiff();
			return;
		}
		for (int i = start; i < N; i++) {
			foodA[count] = i;
			combi(count + 1, i + 1);			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			minDiff = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			ingredients = new int[N][N];
			for (int i = 0; i < N; i++) {
				ingredients[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			foodA = new int[N / 2];
			foodB = new int[N / 2];
			combi(0, 0);
			sb.append("#" + tc + " " + minDiff + System.lineSeparator());
		}
		System.out.print(sb);
	}

}