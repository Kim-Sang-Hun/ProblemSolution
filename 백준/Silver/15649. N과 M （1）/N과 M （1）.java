import java.util.Scanner;

public class Main {
	
	public static int N, M;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			arr[depth] = i;
			permutation(depth + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		arr = new int[M];
		visited = new boolean[N + 1];
		permutation(0);
		System.out.println(sb);
	}
}
