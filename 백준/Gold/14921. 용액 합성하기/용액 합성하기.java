import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N-1;
        int minDiff = Integer.MAX_VALUE;

        while (left < right) {
            int first = arr[left];
            int second = arr[right];
            int value = first + second;
            if (value < 0) {
                ++left;
            } else if (value > 0) {
                --right;
            } else {
                minDiff = 0;
                break;
            }
            if (Math.abs(value) < Math.abs(minDiff)) {
                minDiff = value;
            }
        }
        System.out.println(minDiff);
    }
}