import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int answer, N, start[], end[], order[], arr[][];
    public static boolean[] visited;
    
    public static void checkLen(int count) {
        if (count == N) {
        	int Y = start[0];
        	int X = start[1];
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
        		int nY = arr[order[i]][0];
        		int nX = arr[order[i]][1];
				sum += Math.abs(Y - nY) + Math.abs(X - nX);
				Y = nY;
				X = nX;
			}
        	sum += Math.abs(Y - end[0]) + Math.abs(X - end[1]);
        	answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            order[count] = i;
        	checkLen(count + 1);
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
            start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
            	arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            order = new int[N];
            checkLen(0);
        	sb.append("#" + tc + " " + answer + System.lineSeparator());
        }
        System.out.print(sb);
    }
}