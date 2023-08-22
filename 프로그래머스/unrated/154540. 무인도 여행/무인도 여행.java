
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
  int[] dirY = {1, -1, 0, 0};
  int[] dirX = {0, 0, 1, -1};
 public int[] solution(String[] maps) {
    char[][] map = new char[maps.length][maps[0].length()];
    for (int i = 0; i < map.length; i++) {
      map[i] = maps[i].toCharArray();
    }

    boolean visited[][] = new boolean[map.length][map[0].length];
    List<Integer> list = new ArrayList<>();
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == 'X') {
          continue;
        } else if (!visited[i][j]) {
          queue.add(new int[] {i, j});
          int cnt = 0;
          while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int y = coordinate[0];
            int x = coordinate[1];
            if (visited[y][x]) {
              continue;
            }
            cnt += map[y][x] - '0';
            visited[y][x] = true;
            for (int k = 0; k < dirY.length; k++) {
              int newY = y + dirY[k];
              int newX = x + dirX[k];
              if (newY >= 0 && newY < map.length
                  && newX >= 0 && newX < map[0].length) {
                if (!visited[newY][newX] && map[newY][newX] != 'X') {
                  queue.add(new int[] {newY, newX});
                }
              }
            }
          }
          list.add(cnt);
        }
      }
    }
    if (list.isEmpty()) {
      return new int[] {-1};
    }

    int[] answer = list.stream().mapToInt(x -> x).sorted().toArray();
    return answer;
  }
}