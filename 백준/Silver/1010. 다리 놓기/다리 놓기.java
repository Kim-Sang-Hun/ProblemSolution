import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[30][30];

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(combi(B, A, dp));
        }
    }
    public static int combi(int n, int r, int[][] dp) {

        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

         dp[n][r] = combi(n - 1, r - 1, dp) + combi(n - 1, r, dp);
        return dp[n][r];
    }
}