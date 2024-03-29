import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String key = br.readLine();
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		int[] P = new int[key.length()];
		int idx = 0;
		for (int i = 1; i < P.length; i++) {
			while (idx > 0 && key.charAt(i) != key.charAt(idx)) {
				idx = P[idx - 1];
			}
			if (key.charAt(i) == key.charAt(idx)) {
				P[i] = ++idx;
			}
		}
		idx = 0;
		for (int i = 0; i < str.length(); i++) {
			while (idx > 0 && str.charAt(i) != key.charAt(idx)) {
				idx = P[idx - 1];
			}
			if (str.charAt(i) == key.charAt(idx)) {
				if (idx == key.length()-1) {
					++count;
					sb.append(i - key.length() + 2 + " ");
					idx = P[idx];
				} else {
					++idx;
				}
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}