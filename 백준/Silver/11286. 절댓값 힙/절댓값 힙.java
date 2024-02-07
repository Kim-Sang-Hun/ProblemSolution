import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs = Integer.compare(Math.abs(o1), Math.abs(o2));
				return abs == 0 ? Integer.compare(o1, o2) : abs;
			}
		});
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			int tmp = s.nextInt();
			if (tmp == 0) {
				if (queue.isEmpty()) {
					sb.append(0 + System.lineSeparator());
				} else {
					sb.append(queue.poll() + System.lineSeparator());
				}
			} else {
				queue.add(tmp);
			}
		}
		System.out.print(sb);
	}
}