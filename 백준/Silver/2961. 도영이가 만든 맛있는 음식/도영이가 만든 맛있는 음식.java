import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N; 
	public static int min = Integer.MAX_VALUE;
	public static int[][] ingredients;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ingredients = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		makeFood();
		System.out.println(min);
	}

	public static void makeFood() {
		for (int i = 1; i < 1 << N; i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sour *= ingredients[j][0];
					bitter += ingredients[j][1];
				}
			}
			min = Math.min(min, Math.abs(sour - bitter));
		}
	}
}