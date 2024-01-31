import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		double[] arr = new double[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextDouble();
		}
		Arrays.sort(arr);
		double sum = arr[N - 1];
		for(int i = N - 2; i >= 0; --i) {
			sum += arr[i] / 2;
		}
		System.out.printf("%.5f", sum);
	}
}