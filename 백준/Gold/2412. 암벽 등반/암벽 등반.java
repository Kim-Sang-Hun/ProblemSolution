import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	   static int n, T, min = -1;
	   static List<List<Point>> list;
	   static class Point {
	      int x, y, time;

	      public Point(int x, int y, int time) {
	         this.x = x;
	         this.y = y;
	         this.time = time;
	      }
	   }
	   public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      n = Integer.parseInt(st.nextToken());
	      T = Integer.parseInt(st.nextToken());
	      if (T > 100000) {
	         System.out.println(-1);
	      }
	      list = new ArrayList<>();
	      for (int i = 0; i < 100000; i++) {
			list.add(new ArrayList<>());
		}
	      for (int i = 0; i < n; i++) {
	         st = new StringTokenizer(br.readLine());
	         int x = Integer.parseInt(st.nextToken());
	         int y = Integer.parseInt(st.nextToken());
	         if (x > 100000) continue;
	         Point tmp = new Point(x, y, 0);
	         list.get(x).add(tmp);
	      }
	      bfs();
	      System.out.println(min);
	   }

	   private static void bfs() {
	      Queue<Point> qu = new ArrayDeque<>();
	      qu.add(new Point(0, 0, 0));

	      while (!qu.isEmpty()) {
	         Point cur = qu.poll();
	         if (cur.y >= T) {
	            min = cur.time;
	            break;
	         }
	         for (int i = -2; i <= 2; i++) {
	        	 if (cur.x + i < 0) continue;
	        	 List<Point> tmp = list.get(cur.x + i);
	        	 for (int j = 0; j < tmp.size(); j++) {
	        		 Point p = tmp.get(j);
	        		 if (Math.abs(p.y - cur.y) <= 2) {
	        			 p.time = cur.time + 1;
	        			 qu.add(p);
	        			 tmp.remove(p);
	        			 j--;
	        		 }
	        	 }
	         }
	      }
	   }
}