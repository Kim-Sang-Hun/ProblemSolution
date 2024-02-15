import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int answer, N, home[], arr[][];
    public static int Y, X;
    public static boolean[] visited;
    
    public static void checkLen(int count, int len) {
    	if (answer <= len) return;
        if (count == N) {
        	len += Math.abs(Y - home[0]) + Math.abs(X - home[1]);
        	answer = Math.min(answer, len);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int tmpY = Y;
            int tmpX = X;
            Y = arr[i][0];
            X = arr[i][1];
        	checkLen(count + 1, len + Math.abs(tmpY - arr[i][0]) + Math.abs(tmpX - arr[i][1]));
        	Y = tmpY;
        	X = tmpX;
            visited[i] = false;
        }
        
    }
    
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
            	arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            checkLen(0, 0);
        	sb.append("#" + tc + " " + answer + System.lineSeparator());
        }
        System.out.print(sb);
    }
}