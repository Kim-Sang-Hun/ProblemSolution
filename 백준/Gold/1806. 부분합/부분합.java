import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            arr[i] += arr[i-1];
        }
        int left = n-1, right = n, min = Integer.MAX_VALUE;

        while (true) {
            long sum = arr[right] - arr[left];

            if (sum >= s) {
                int len = right - left;
                if (len < min) {
                    min = len;
                    if (len == 1) break;
                }
                if (right == 1) break;
                --right;
            } else {
                if (left == 0) break;
                --left;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}