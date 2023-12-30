import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

class Solution {

  static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  static class Node {

    int Y;
    int X;
    int count;

    public Node(int y, int x, int count) {
      Y = y;
      X = x;
      this.count = count;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int i = 0; i < T; i++) {
      int N = s.nextInt();
      s.nextLine();
      int[][] map = new int[N][N];
      int[][] dp = new int[N][N];
      Queue<Node> queue = new LinkedList<>();
      for (int j = 0; j < N; j++) {
        map[j] = Arrays.stream(s.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(dp[j], Integer.MAX_VALUE);
      }
      queue.add(new Node(0, 0, 0));
      while (!queue.isEmpty()) {
        Node node = queue.poll();
        if (node.Y == N - 1 && node.X == N - 1) {
          continue;
        }

        for (int j = 0; j < 4; j++) {
          int newY = node.Y + dirs[j][0];
          int newX = node.X + dirs[j][1];

          if (newY >= 0 && newY < N && newX >= 0 && newX < N) {
            int newCount = node.count + map[newY][newX];
            if (dp[newY][newX] <= newCount) continue;
            queue.add(new Node(newY, newX, newCount));
            dp[newY][newX] = newCount;
          }
        }
      }
      System.out.printf("#%d %d\n", i + 1, dp[N-1][N-1]);
    }
  }
}