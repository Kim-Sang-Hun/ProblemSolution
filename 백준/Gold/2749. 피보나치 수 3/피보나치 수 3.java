import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000;
		int P = 15 * mod / 10;
		int[] fibo = new int[P];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (int i = 2; i < P; i++) {
			fibo[i] = (fibo[i-2] + fibo[i-1]) % mod;
		}
		
		long N = sc.nextLong();
		System.out.println(fibo[(int) (N%P)]);
	}
}