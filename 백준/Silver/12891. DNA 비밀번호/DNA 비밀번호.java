import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int lenT, lenP, A, C, G, T, count, arr[];

	public static void add(char c) {
		if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
			arr[4]++;
		} else if (c == 'A') {
			arr[0]++;
		} else if (c == 'C') {
			arr[1]++;
		} else if (c == 'G') {
			arr[2]++;
		} else if (c == 'T') {
			arr[3]++;
		}
	}
	public static void remove(char c) {
		if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
			arr[4]--;
		} else if (c == 'A') {
			arr[0]--;
		} else if (c == 'C') {
			arr[1]--;
		} else if (c == 'G') {
			arr[2]--;
		} else if (c == 'T') {
			arr[3]--;
		}
	}
	public static void validate() {
		if (arr[4] != 0 || arr[0] < A || arr[1] < C || arr[2] < G || arr[3] < T)
			return;
		
		count++;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		lenT = Integer.parseInt(st.nextToken());
		lenP = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[5];

		for (int i = 0; i < lenP; i++) {
			char c = str.charAt(i);
			add(c);
		}
		validate();
		for (int i = lenP; i < lenT; i++) {
			remove(str.charAt(i - lenP));
			add(str.charAt(i));
			validate();
		}
		System.out.println(count);
	}
}