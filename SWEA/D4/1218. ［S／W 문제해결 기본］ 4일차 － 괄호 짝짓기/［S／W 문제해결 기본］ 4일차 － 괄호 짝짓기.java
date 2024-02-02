import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static Stack<String> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			stack = new Stack<>();
			sb = new StringBuilder().append("#" + tc + " ");
			loop:
			for (int i = 0; i < str.length; i++) {
				if (stack.isEmpty()) {
					switch (str[i]) {
					case ")":
					case "]":
					case "}":
					case ">":
						sb.append(0);
						break loop;
					default :
						stack.push(str[i]);
					}
				} else {
					switch (str[i]) {
					case ")":
					case "]":
					case "}":
					case ">":
						if (!validate(str[i])) {
							sb.append(0);
							break loop;
						}
						break;
					default :
						stack.push(str[i]);
					}
				}
				if (i == str.length - 1) {
					if (stack.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
	public static boolean validate(String str) {
		String tmp = stack.pop();
		switch (tmp) {
		case "(":
			if (!str.equals(")")) return false;
			break;
		case "[":
			if (!str.equals("]")) return false;
			break;
		case "{":
			if (!str.equals("}")) return false;
			break;
		case "<":
			if (!str.equals(">")) return false;
		}
		return true;
	}
}