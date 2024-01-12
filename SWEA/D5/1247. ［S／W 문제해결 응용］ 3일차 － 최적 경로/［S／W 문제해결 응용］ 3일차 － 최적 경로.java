import java.util.*;

class Solution {
    public static int answer, N, start[], end[], arr[][];
    
    public static void checkLen(boolean[] visited, int idx, int count, int len) {
        if (len >= answer) return;
        if (count == N) {
        	answer = Math.min(answer, len + Math.abs(arr[idx][0] - end[0]) + Math.abs(arr[idx][1] - end[1]));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
        	checkLen(visited, i, count + 1, len + Math.abs(arr[idx][0] - arr[i][0]) + Math.abs(arr[idx][1] - arr[i][1]));
            visited[i] = false;
        }
        
    }
    
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	N = s.nextInt();
            answer = Integer.MAX_VALUE;
            start = new int[] {s.nextInt(), s.nextInt()};
            end = new int[] {s.nextInt(), s.nextInt()};
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
            	arr[i][0] = s.nextInt();
                arr[i][1] = s.nextInt();
            }
            for (int i = 0; i < N; i++) {
            	boolean[] visited = new boolean[N];
                visited[i] = true;
                checkLen(visited, i, 1, Math.abs(start[0] - arr[i][0]) + Math.abs(start[1] - arr[i][1]));
            }
        	System.out.printf("#%d %d\n", tc, answer);
        }
        
    }
}