import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Edge>[] edge;
    static int[] min;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge = new List[v + 1];
            min = new int[v + 1];
            for (int j = 1; j < v + 1; j++) {
                edge[j] = new ArrayList<>();
            }

            for (int j = 0; j < e + w; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if (j < e) {
                    edge[from].add(new Edge(to, weight));
                    edge[to].add(new Edge(from, weight));
                } else {
                    edge[from].add(new Edge(to, -weight));
                }
            }
            min[1] = 0;
            bfs();
        }
    }

    private static void bfs() {
        boolean update = false;

        for(int i = 1; i < min.length; i++){
            update = false;
            for(int j = 1; j < min.length; j++){
                for (Edge n : edge[j]) {
                    if(min[n.to] > min[j] + n.weight){
                        min[n.to] = min[j]+ n.weight;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        if (update) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}