import java.util.Scanner;

public class Main {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		sb = new StringBuilder();
		makeNum(0, "");
		
		System.out.print(sb);
	}
	
	public static boolean validate(int depth, int num) {
		if (num / (int)Math.pow(10, depth) == 0) return false;
		if (num == 1) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void makeNum(int depth, String num) {
		if (depth == N) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 0; i < 10; i++) {
			String next = num + i;
			if (validate(depth, Integer.parseInt(next))) {
				makeNum(depth + 1, next);
			}
		}
	}
}