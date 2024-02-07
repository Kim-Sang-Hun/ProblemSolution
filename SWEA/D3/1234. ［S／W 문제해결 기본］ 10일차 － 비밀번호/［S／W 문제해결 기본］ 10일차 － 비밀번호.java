import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int N = s.nextInt();
			String str = s.next();
			Deque<Character> deque = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				if (deque.isEmpty()) {
					deque.addLast(str.charAt(i));
				} else if (deque.peekLast() == str.charAt(i)) {
					deque.pollLast();
				} else {
					deque.addLast(str.charAt(i));
				}
			}
			sb.append("#" + tc + " ");
			int dequeSize = deque.size();
			for (int i = 0; i < dequeSize; i++) {
				sb.append(deque.pollFirst());
			}
			sb.append(System.lineSeparator());
		}
		System.out.print(sb);
	}
}