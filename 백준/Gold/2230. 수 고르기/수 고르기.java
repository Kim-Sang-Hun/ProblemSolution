import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int minDiff, n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minDiff = Integer.MAX_VALUE;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0, right = 0;
        while (left < n) {
            int diff = arr[right] - arr[left];
            if (diff == m) {
                minDiff = m;
                break;
            }
            if (diff < m) {
                right++;
                if (right >= n) break;
            } else {
                minDiff = Math.min(minDiff, diff);
                left++;
            }
        }
        System.out.println(minDiff);
    }

}