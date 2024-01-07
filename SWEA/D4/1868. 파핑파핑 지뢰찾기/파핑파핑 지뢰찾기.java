import java.util.*;

class Solution {
    static char map[][];
    static int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    static int[][] marked;
    static boolean[][] visited;
    
    public static int count(int y, int x) {
        int count = 0;
    	for (int i = 0; i < 8; i++) {
        	int Y = y + dirs[i][0];
            int X = x + dirs[i][1];
            
            if (Y < 0 || Y >= map.length || X < 0 || X >= map.length) continue;
            if (map[Y][X] == '*') count++;
        }
        return count;
    }
    
    public static void mark(int y, int x) {
        int count = count(y, x);
        visited[y][x] = true;
        if (count == 0) {
        	for (int i = 0; i < 8; i++) {
            	int Y = y + dirs[i][0];
           		int X = x + dirs[i][1];
                
                if (Y < 0 || Y >= map.length || X < 0 || X >= map.length || visited[Y][X]) continue;
                mark(Y, X);
            }
        }
    }
    
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int tc = 1; tc <= t; tc++) {
        	int N = s.nextInt(); s.nextLine();
            map = new char[N][N];
            marked = new int[N][N];
            visited = new boolean[N][N];
            int answer = 0;
            for (int i = 0; i < N; i++) {
            	map[i] = s.nextLine().toCharArray();
            }
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != '*' && count(i, j) == 0) {
                    	mark(i, j);
                        answer++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != '*') {
                    	mark(i, j);
                        answer++;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}