import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

   static int n, m, k;
   static long cnt;
   static char[][] map;
   static String cur;
   static Map<Character, List<Point>> points;
   static Map<String, Long> counts;
   static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
   static int[] dx = {1, 0, -1, 1, -1, 0, -1, 1};
   static class Point {
      int y, x;

      public Point(int y, int x) {
         this.y = y;
         this.x = x;
      }
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      map = new char[n][m];
      points = new HashMap<>();
      counts = new HashMap<>();

      points = new HashMap<>();
      for (int i = 0; i < n; i++) {
         map[i] = br.readLine().toCharArray();
         for (int j = 0; j < m; j++) {
            char cur = map[i][j];
            List<Point> list = points.getOrDefault(cur, new ArrayList<>());
            list.add(new Point(i, j));
            points.put(cur, list);
         }
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < k; i++) {
         cur = br.readLine();
         sb.append(count()).append(System.lineSeparator());
      }
      System.out.print(sb);
   }

   private static long count() {
      cnt = 0;
      if (counts.get(cur) != null) {
         return counts.get(cur);
      }
      List<Point> list = points.get(cur.charAt(0));
      if (list == null) {
         return 0;
      }
      for (Point p : list) {
         dfs(p, 1);
      }
      counts.put(cur, cnt);
      return cnt;
   }

   private static void dfs(Point before, int idx) {
      if (idx >= cur.length()) {
         ++cnt;
         return;
      }
      List<Point> list = points.get(cur.charAt(idx));
      if (list == null) {
         return;
      }
      for (Point p : list) {
         if (isNear(before, p)) {
            dfs(p, idx + 1);
         }
      }
   }

   private static boolean isNear(Point p1, Point p2) {
      int y = Math.abs(p1.y - p2.y);
      int x = Math.abs(p1.x - p2.x);

      if (y == 0 && x == 0) return false;
      if ((y < 2 && x < 2) || (y == n-1 && x < 2) || (y < 2 && x == m-1) || (y == n-1 && x == m-1)) {
         return true;
      }
      return false;
   }
}