import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N];
		int time = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		if (N == 1) {
			System.out.println(arr[0] > 1440 ? -1 : arr[0]);
			return;
		}
		Arrays.sort(arr);
		while (arr[N - 2] > 0) {
			arr[N - 1] -= arr[N - 2];
			time += arr[N - 2];
			arr[N - 2] = 0;
			Arrays.sort(arr);
		}
		time += arr[N - 1];
		System.out.println(time > 1440 ? -1 : time);
	}
}