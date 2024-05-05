import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][3];
        arr[0] = Integer.parseInt(br.readLine());
        dp[0][1] = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }
        System.out.println(Math.max(Math.max(dp[n-1][1], dp[n-1][2]), dp[n-1][0]));
    }
}