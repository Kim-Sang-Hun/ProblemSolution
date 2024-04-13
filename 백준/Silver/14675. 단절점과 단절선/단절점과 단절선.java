import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   static class Edge {
      int from, to;

      public Edge(int from, int to) {
         this.from = from;
         this.to = to;
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st;
      int[] count = new int[N + 1];
      Edge[] order = new Edge[N];
      List<List<Integer>> edges = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
         edges.add(new ArrayList<>());
      }

      for (int i = 1; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         int from = Integer.parseInt(st.nextToken());
         int to = Integer.parseInt(st.nextToken());
         edges.get(from).add(to);
         edges.get(to).add(from);
         Edge cur = new Edge(from, to);
         order[i] = cur;
         count[from]++;
         count[to]++;
      }
      int q = Integer.parseInt(br.readLine());
      for (int i = 0; i < q; i++) {
         st = new StringTokenizer(br.readLine());
         int type = Integer.parseInt(st.nextToken());
         int target = Integer.parseInt(st.nextToken());
         if (type == 1) {
            if (count[target] == 1) {
               System.out.println("no");
            } else {
               System.out.println("yes");
            }
         } else {
            System.out.println("yes");
         }
      }
   }
}