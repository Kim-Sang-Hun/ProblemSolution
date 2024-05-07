import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
   static int n, m, k;
   static boolean[] valid;
   static St[] sts;
   static List<List<Integer>> next, before;
   static class St {
      int cnt, need;
      Set<Integer> set;

      public St(int cnt, int need, Set<Integer> set) {
         this.cnt = cnt;
         this.need = need;
         this.set = set;
      }
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      sts = new St[n + 1];
      valid = new boolean[n + 1];
      next = new ArrayList<>();
      before = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
         sts[i] = new St(0, 0, new HashSet<>());
         next.add(new ArrayList<>());
         before.add(new ArrayList<>());
      }
      for (int i = 1; i <= m; i++) {
         st = new StringTokenizer(br.readLine());
         int from = Integer.parseInt(st.nextToken());
         int to = Integer.parseInt(st.nextToken());
         next.get(from).add(to);
         before.get(to).add(from);
         ++sts[to].need;
      }

      for (int i = 0; i < k; i++) {
         st = new StringTokenizer(br.readLine());
         int op = Integer.parseInt(st.nextToken());
         int target = Integer.parseInt(st.nextToken());
         if (op == 1) {
            if (valid[target] || sts[target].need == 0) {
               ++sts[target].cnt;
               valid[target] = true;

               List<Integer> list = next.get(target);
               for (int j = 0; j < list.size(); j++) {
                  St n = sts[list.get(j)];
                  n.set.add(target);
                  if (n.need == n.set.size()) {
                     valid[list.get(j)] = true;
                  }
               }
            } else {
               System.out.println("Lier!");
               return;
            }
         } else {
            if (sts[target].cnt == 0) {
               System.out.println("Lier!");
               return;
            } else {
               sts[target].cnt--;
            }

            if (sts[target].cnt == 0) {
               for (int next : next.get(target)) {
                  St n = sts[next];
                  n.set.remove(target);
                  valid[next] = false;
               }
            }
         }
      }
      System.out.println("King-God-Emperor");
   }
}