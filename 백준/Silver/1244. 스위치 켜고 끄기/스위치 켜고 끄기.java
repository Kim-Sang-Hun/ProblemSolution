import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = s.nextInt();
		}
		int student = s.nextInt();
		for (int i = 0; i < student; i++) {
			int sex = s.nextInt();
			int num = s.nextInt();
			
			if (sex == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % num == 0) {
						arr[j] = arr[j] == 1 ? 0 : 1;
					}
				}
			} else {
				int left = num;
				int right = num;
				while (true) {
					--left;
					++right;
					if (left < 1 || right > N) break;
					if (arr[left] != arr[right]) break;
				}
				++left; --right;
				for (int j = left; j <= right; j++) {
					arr[j] = arr[j] == 1 ? 0 : 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}