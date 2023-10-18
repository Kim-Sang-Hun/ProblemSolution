import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void getDP(int[][] dp, List<Integer> score, int idx) {
    if (idx >= dp.length) return;

    dp[idx][0] = Math.max(dp[idx - 2][0], dp[idx - 2][1])  + score.get(idx);
    dp[idx][1] = dp[idx - 1][0]  + score.get(idx);
    getDP(dp, score, idx + 1);
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    List<Integer> score = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      score.add(s.nextInt());
    }
    if (n == 1) {
      System.out.println(score.get(0));
      return;
    }
    int[][] dp = new int[n][2];

    dp[0][0] = score.get(0); dp[0][1] = score.get(0);
    dp[1][0] = score.get(1); dp[1][1] = dp[0][0] + score.get(1);
    getDP(dp, score, 2);

    System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
  }

}