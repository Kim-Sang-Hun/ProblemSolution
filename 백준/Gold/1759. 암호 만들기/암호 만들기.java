import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
    static char[] list;
    static char[] code;
    static PriorityQueue<String> queue = new PriorityQueue<>();

    public static void combi(int idx, int start) {
        if (idx == L) {
            int count = 0;
            for (int i = 0; i < L; i++) {
                char c = code[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') ++count;
            }
            if (count != 0 && L - count >= 2) {
            	StringBuilder sb = new StringBuilder();
            	for (int i = 0; i < code.length; i++) {
					sb.append(code[i]);
				}
            	queue.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < C; i++) {
			code[idx] = list[i];
			combi(idx + 1, i + 1);
		}
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
        list = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }
        code = new char[L];
        Arrays.sort(list);
        combi(0, 0);
        for (String str: queue) {
            sb.append(str).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}