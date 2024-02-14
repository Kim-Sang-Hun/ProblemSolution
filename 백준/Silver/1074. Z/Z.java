import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int r = s.nextInt();
		int c = s.nextInt();
		int len = 1 << (N - 1);
		int[] pivot = {len - 1, len - 1};
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			if (pivot[0] < r && pivot[1] < c) {
				pivot[0] += len / 2;
				pivot[1] += len / 2;
				idx += len * len * 3;
			} else if (pivot[0] < r) {
				pivot[0] += len / 2;
				pivot[1] -= len / 2;
				idx += len * len * 2;
			} else if (pivot[1] < c) {
				pivot[0] -= len / 2;
				pivot[1] += len / 2;
				idx += len * len;
			} else {
				pivot[0] -= len / 2;
				pivot[1] -= len / 2;
			}
			len /= 2;
		}
		System.out.println(idx);
	}
}