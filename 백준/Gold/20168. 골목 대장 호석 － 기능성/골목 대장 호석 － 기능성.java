import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a, b, c, min = Integer.MAX_VALUE;
    static List<List<Edge>> edges;
    public static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.get(n1).add(new Edge(n2, weight));
            edges.get(n2).add(new Edge(n1, weight));
        }
        dfs(a, b, c, new boolean[n + 1], 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void dfs(int cur, int target, int money, boolean[] visited, int humil) {
        if (cur == target) {
            min = Math.min(min, humil);
            return;
        }
        visited[cur] = true;
        List<Edge> next = edges.get(cur);
        for (Edge e : next) {
            if (visited[e.to] || money < e.weight) continue;
            visited[e.to] = true;
            dfs(e.to, target, money - e.weight, visited, Math.max(humil, e.weight));
            visited[e.to] = false;
        }
    }
}