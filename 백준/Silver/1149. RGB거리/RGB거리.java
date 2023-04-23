import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] DP = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        DP[0][0] = cost[0][0];
        DP[0][1] = cost[0][1];
        DP[0][2] = cost[0][2];
        
        int answer = Math.min(Math.min(paint(N - 1, 0, DP, cost), paint(N - 1, 1, DP, cost)), paint(N - 1, 2, DP, cost));

        System.out.println(answer);
    }

    public static int paint(int N, int idx, int[][] DP, int[][] cost) {
        if (DP[N][idx] == 0) {
            if (idx == 0) {
                DP[N][idx] = Math.min(paint(N - 1, 1, DP, cost), paint(N - 1, 2, DP, cost)) + cost[N][0];
            } else if (idx == 1) {
                DP[N][idx] = Math.min(paint(N - 1, 0, DP, cost), paint(N - 1, 2, DP, cost)) + cost[N][1];
            } else if (idx == 2) {
                DP[N][idx] = Math.min(paint(N - 1, 0, DP, cost), paint(N - 1, 1, DP, cost)) + cost[N][2];
            }
        }
        return DP[N][idx];
    }
}