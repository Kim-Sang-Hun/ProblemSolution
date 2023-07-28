import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int solution(String[] maps) {
    String[][] map = Arrays.stream(maps).map(str -> str.split("")).toArray(String[][]::new);
    int Y = map.length;
    int X = map[0].length;
    int[][] dp = new int[Y][X];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    int[] dirY = new int[]{1, -1, 0, 0};
    int[] dirX = new int[]{0, 0, 1, -1};

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < Y; i++) {
      for (int j = 0; j < X; j++) {
        if (map[i][j].equals("S")) {
          queue.add(new int[] {i, j, 0});
          break;
        }
      }
    }
    int[] leverAndCost = new int[] {0, 0, Integer.MAX_VALUE};

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowY = now[0];
      int nowX = now[1];
      int nowCost = now[2];

      if (map[nowY][nowX].equals("L")) {
        if (leverAndCost[2] > nowCost) {
          leverAndCost[0] = nowY;
          leverAndCost[1] = nowX;
          leverAndCost[2] = nowCost;
        }
        continue;
      }
      if (nowCost >= dp[nowY][nowX]) {
        continue;
      }
      dp[nowY][nowX] = nowCost;

      for (int i = 0; i < dirY.length; i++) {
        int newY = nowY + dirY[i];
        int newX = nowX + dirX[i];
        if (newY < Y && newY >= 0
            && newX < X && newX >= 0) {
          if (!map[newY][newX].equals("X")) {
            queue.add(new int[] {newY, newX, nowCost + 1});
          }
        }
      }
    }

    if (leverAndCost[2] == Integer.MAX_VALUE) {
      return -1;
    }
    queue.add(leverAndCost);
    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowY = now[0];
      int nowX = now[1];
      int nowCost = now[2];

      if (map[nowY][nowX].equals("E")) {
        if (answer > nowCost) {
          answer = nowCost;
        }
        continue;
      }
      if (nowCost >= dp[nowY][nowX]) {
        continue;
      }
      dp[nowY][nowX] = nowCost;

      for (int i = 0; i < dirY.length; i++) {
        int newY = nowY + dirY[i];
        int newX = nowX + dirX[i];
        if (newY < Y && newY >= 0
            && newX < X && newX >= 0) {
          if (!map[newY][newX].equals("X")) {
            queue.add(new int[] {newY, newX, nowCost + 1});
          }
        }
      }
    }
    if (answer == Integer.MAX_VALUE) {
      return -1;
    }
    return answer;
  }
}