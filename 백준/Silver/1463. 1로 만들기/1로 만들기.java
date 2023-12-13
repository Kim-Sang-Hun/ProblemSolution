import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i < N + 1; i++) {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i / 3] + i % 3, dp[i / 2] + i % 2)) + 1;
        }
        System.out.println(dp[N]);
    }

}
