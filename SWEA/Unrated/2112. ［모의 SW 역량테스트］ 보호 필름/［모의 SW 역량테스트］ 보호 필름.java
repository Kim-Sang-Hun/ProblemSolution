import java.util.Scanner;

class Solution {
    static int K;
    static int answer;
    
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
        for (int i = 0; i < T; i++) {
            int Y = sc.nextInt(); int X = sc.nextInt(); K = sc.nextInt();
            answer = Integer.MAX_VALUE;
            
            int[][] graph = new int[Y][X];
            for (int j = 0; j < Y; j++) {
             	for (int k = 0;  k < X; k++) {
              		graph[j][k] = sc.nextInt();   
             	}
            }
			dfs(graph, 0, 0);
            System.out.printf("#%d %d\n", i+1, answer);
        }
	}
    public static void dfs(int[][] graph, int idx, int count) {
    	if (isValid(graph)) {
        	answer = Math.min(answer, count);
            return;
        }
        if (count >= answer) {
        	return;
        }
        if (idx >= graph.length) {
        	return;
        }
        int[][] graph1 = new int[graph.length][graph[0].length];
        int[][] graph0 = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            if (i == idx) {
            	for (int j = 0; j < graph[0].length; j++) {
                	graph1[i][j] = 1;
                    graph0[i][j] = 0;
                }
                continue;
            }
			graph1[i] = graph[i].clone();
            graph0[i] = graph[i].clone();
        }
        dfs(graph, idx + 1, count);
        dfs(graph1, idx + 1, count + 1);
        dfs(graph0, idx + 1, count + 1);
    }
    
    public static boolean isValid(int[][] graph) {
        for (int i = 0; i < graph[0].length; i++) {
            int count = 1;
         	int tmp = graph[0][i];
            for (int j = 1; j < graph.length; j++) {
                if (tmp == graph[j][i]) {
                	count++;
                } else {
                	tmp = graph[j][i];
                    count = 1;
                }
                if (count >= K) {
                	break;
                }
                if (j == graph.length - 1) {
                	return false;
                }
            }
        }
       return true;        
    }
}