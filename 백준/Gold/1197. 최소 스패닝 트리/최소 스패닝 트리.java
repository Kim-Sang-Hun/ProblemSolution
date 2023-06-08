import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static int solution(int[][] lines, int V, int E) {
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            arr.get(lines[i][0]).add(new Node(lines[i][1], lines[i][2]));
            arr.get(lines[i][1]).add(new Node(lines[i][0], lines[i][2]));
        }
        int costSum = 0;
        boolean[] visited = new boolean[V + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            costSum += cur.cost;

            for (Node adjNode : arr.get(cur.to)) {
                if (!visited[adjNode.to]) {
                    pq.add(adjNode);
                }
            }
        }
        return costSum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] lines = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
            lines[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(lines, V, E));
    }
}