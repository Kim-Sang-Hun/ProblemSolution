import java.util.Scanner;

public class Main {

	static String[] str;
	static int max, len;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine().split("");
		len = str.length;
		if (len < 10) {
			max = 9;
		} else {
			max = (len - 9) / 2 + 9;
		}
		visited = new boolean[max + 1];
		dfs(0, "");
	}
	
	private static void dfs(int idx, String cur) {
		if (idx == len) {
			System.out.println(cur.trim());
			System.exit(0);
		}
		int tmp = Integer.parseInt(str[idx]);
		if (!visited[tmp]) {
			visited[tmp] = true;
			dfs(idx + 1, cur + " " + tmp);
			visited[tmp] = false;
		}
		if (idx + 1 < len) {
			tmp = Integer.parseInt(str[idx] + str[idx + 1]);
			if (tmp > max) return;
			if (!visited[tmp]) {
				visited[tmp] = true;
				dfs(idx + 2, cur + " " + tmp);
				visited[tmp] = false;
			}
		}
	}
}