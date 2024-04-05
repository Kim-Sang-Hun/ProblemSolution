import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			char prev;
			if (Character.isAlphabetic(c)) {
				sb.append(c);
			} else if (c == '(') {
				stack.add(c);
			} else if (c == ')') {
				while (!stack.isEmpty()) {
					prev = stack.pop();
					if (prev == '(') break;
					sb.append(prev);
				}
			} else if (c == '*' || c == '/') {
				while (!stack.isEmpty()) {
					prev = stack.peek();
					if (!(prev == '*' || prev == '/')) break;
					sb.append(stack.pop());
				}
				stack.add(c);
			} else if (c == '+' || c == '-') {
				while (!stack.isEmpty()) {
					prev = stack.peek();
					if (prev == '*' || prev == '/' || prev == '+' || prev == '-') {
						sb.append(stack.pop());
					} else break;
				}
				stack.add(c);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}