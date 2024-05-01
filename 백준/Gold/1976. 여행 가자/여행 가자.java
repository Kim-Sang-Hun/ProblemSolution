import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        parent = new int[n+1];
        StringTokenizer st;
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int pivot = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int cur = find(Integer.parseInt(st.nextToken()));
            if (pivot != cur) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA > pB) {
            parent[a] = pB;
        } else {
            parent[b] = pA;
        }
    }
}