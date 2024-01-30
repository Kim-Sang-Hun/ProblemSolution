import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = s.nextInt();
			PriorityQueue<Integer> max = new PriorityQueue<>((i1, i2) -> i2 - i1);
			PriorityQueue<Integer> min = new PriorityQueue<>();
			for (int i = 0; i < 100; i++) {
				int num = s.nextInt();
				max.add(num);
				min.add(num);
			}
			while (max.peek() - 1 > min.peek()) {
				if (N == 0) break;
				N--;
				max.add(max.poll() - 1);
				min.add(min.poll() + 1);
			}
			System.out.printf("#%d %d\n", tc, max.peek() - min.peek());
		}
	}
}
