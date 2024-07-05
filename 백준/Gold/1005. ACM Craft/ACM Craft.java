import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, target, answer;
    static int[] time;
    static boolean[] constructed;
    static List<List<Integer>> childs;
    static List<List<Integer>> parents;

    public static class Constructure {
        int num, cost;

        public Constructure(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int T = 0; T < tc; T++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            time = new int[n + 1];
            constructed = new boolean[n + 1];
            childs = new ArrayList<>();
            parents = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                childs.add(new ArrayList<>());
                parents.add(new ArrayList<>());
            }
            childs.add(new ArrayList<>());
            parents.add(new ArrayList<>());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                childs.get(parent).add(child);
                parents.get(child).add(parent);
            }
            target = Integer.parseInt(br.readLine());
            bfs();
            System.out.println(answer);
        }
    }

    private static void bfs() {
        PriorityQueue<Constructure> qu = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 1; i <= n; i++) {
            if (parents.get(i).isEmpty()) {
                qu.add(new Constructure(i, time[i]));
            }
        }
        while (!qu.isEmpty()) {
            Constructure c = qu.poll();
            constructed[c.num] = true;
            if (c.num == target) {
                answer = c.cost;
                break;
            }

            for (int child : childs.get(c.num)) {
                if (constructed[child]) continue;

                boolean valid = true;
                for (int parent : parents.get(child)) {
                    if (!constructed[parent]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    qu.add(new Constructure(child, c.cost + time[child]));
                }
            }
        }
    }
}