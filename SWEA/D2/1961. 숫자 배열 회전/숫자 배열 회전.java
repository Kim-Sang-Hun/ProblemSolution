import java.util.*;

class Solution {
    
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
   		int T = s.nextInt();
    
    	for (int tc = 1; tc <= T; tc++) {
    		System.out.printf("#%d\n", tc);
            int N = s.nextInt();
            StringBuffer sb = new StringBuffer();
            int[][] arr = new int[N][N];
        	for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		arr[i][j] = s.nextInt();
            	}
            }
        	for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		sb.append(arr[N - 1 - j][i]);
            	}
                sb.append(" ");
                for (int j = 0; j < N; j++) {
            		sb.append(arr[N - 1 - i][N - 1 - j]);
            	}
                sb.append(" ");
                for (int j = 0; j < N; j++) {
            		sb.append(arr[j][N - 1 - i]);
            	}
                sb.append("\n");
            }
            System.out.print(sb);
    	}
    }
}