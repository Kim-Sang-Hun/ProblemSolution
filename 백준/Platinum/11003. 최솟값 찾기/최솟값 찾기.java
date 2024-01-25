import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast()[0] > num) {
                deque.pollLast();
            }
            deque.addLast(new int[] {num, i});
            if (deque.peekFirst()[1] <= i - L) {
                deque.pollFirst();
            }
            bw.write(deque.peekFirst()[0] + " ");
        }
        bw.flush();
        bw.close();
    }
}