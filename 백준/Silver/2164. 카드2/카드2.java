import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N = s.nextInt();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}

}