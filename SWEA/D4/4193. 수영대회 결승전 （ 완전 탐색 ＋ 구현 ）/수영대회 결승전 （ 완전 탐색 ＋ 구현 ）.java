import java.util.*;

class Solution {
    static int N, answer, map[][];
    static int[] dirY = {1, -1, 0, 0};
    static int[] dirX = {0, 0, 1, -1};
    static Queue<Node> qu;
    public static class Node implements Comparable<Node> {
    	int totalTime, y, x;
        Node(int totalTime, int y, int x) {
        	this.totalTime = totalTime;
            this.y = y;
            this.x = x;
        }
        @Override
     	public int compareTo(Node o) {
        	if (this.totalTime > o.totalTime) {
            	return 1;
            } else if (this.totalTime < o.totalTime) {
            	return -1;
            } else return 0;
        }
    }
    
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	N = s.nextInt();
            answer = Integer.MAX_VALUE;
			map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                	map[i][j] = s.nextInt();
                }
            }
            int startY = s.nextInt();
            int startX = s.nextInt();
            int targetY = s.nextInt();
            int targetX = s.nextInt();
            qu = new PriorityQueue<>();
            qu.add(new Node(0, startY, startX));
            visited[startY][startX] = true;
            while (!qu.isEmpty()) {
            	Node now = qu.poll();
                if (now.totalTime >= answer) break;
            	if (now.y == targetY && now.x == targetX) {
                	answer = now.totalTime;
                    continue;
                }
                int tornadoExist = (now.totalTime + 1) % 3;

                for (int i = 0; i < 4; i++) {
                	int newY = now.y + dirY[i];
                    int newX = now.x + dirX[i];
                    if (newY < 0 || newY >= N || newX < 0 || newX >= N) continue;
                    if (map[newY][newX] == 1 || visited[newY][newX]) continue;
                    if (map[newY][newX] == 2 && tornadoExist != 0) {
                        qu.add(new Node(now.totalTime + 1, now.y, now.x));
                        continue;
                    }
                    qu.add(new Node(now.totalTime + 1, newY, newX));
                    visited[newY][newX] = true;
                }
            }
            System.out.printf("#%d %d\n", tc, answer == Integer.MAX_VALUE? -1 : answer);
        }
    }
}