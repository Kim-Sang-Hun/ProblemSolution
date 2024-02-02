import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int len, operand[];
	static char[] operator;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		len = Integer.parseInt(st.nextToken());
		String[] op = br.readLine().split("");
		operand = new int[len / 2 + 1];
		operator = new char[len / 2];
		operand[0] = Integer.parseInt(op[0]);
		for (int i = 1; i < len; i++) {
			if (i % 2 == 1) {
				operator[i / 2] = op[i].charAt(0);
			} else {
				operand[i / 2] = Integer.parseInt(op[i]);
			}
		}
		bfs(0, operand[0], 0, false);
		System.out.print(max);
	}

	private static int operate(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		default:
			return 0;
		}
	}

	private static void bfs(int last, int now, int depth, boolean inParens) {
		if (depth == len / 2) {
			max = Math.max(now, max);
			return;
		}
		bfs(now, operate(now, operand[depth + 1], operator[depth]), depth + 1, false);
		if (!inParens && depth >= 1) {
			int tmp = operate(operand[depth], operand[depth + 1], operator[depth]);
			bfs(now, operate(last, tmp, operator[depth - 1]), depth + 1, true);
		}
	}
}