import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static char[] tree;
	public static int validateTree(int idx, boolean digit) {
		if (idx > N || tree[idx] == '\u0000') {
			if (digit) return 1;
			else return 0;
		}
		
		int isValid = 0;
		if (Character.isDigit(tree[idx])) {
			digit = true;
		} else {
			digit = false;
		}
		isValid = validateTree(idx * 2, digit) + validateTree(idx * 2 + 1, digit);
		
		if (isValid == 2) {
			return 1;
		} else return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			sb.append("#").append(tc).append(" ").append(validateTree(1, Character.isDigit(tree[1])));
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}