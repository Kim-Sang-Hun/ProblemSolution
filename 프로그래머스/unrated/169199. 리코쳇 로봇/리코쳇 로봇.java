import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public final int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int result = Integer.MAX_VALUE;
    boolean[][] visited;

    public int[] goStraight(int[] myPosition, int dir, String[] board) {
        int myY = myPosition[0];
        int myX = myPosition[1];
        while (myY + dirs[dir][0] >= 0 && myY + dirs[dir][0] < board.length &&
                myX + dirs[dir][1] >= 0 && myX + dirs[dir][1] < board[0].length() &&
                board[myY + dirs[dir][0]].charAt(myX + dirs[dir][1]) != 'D'
        ) {
            myY += dirs[dir][0];
            myX += dirs[dir][1];
        }
        return new int[] {myY, myX};
    }

    public void bfs(int[] myPosition, int[] target, String[] board, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {myPosition[0], myPosition[1], 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == target[0] && cur[1] == target[1]) {
                result = Math.min(result, cur[2]);
                return;
            }
            for (int i = 0; i < dirs.length; i++) {
                int[] newPosition = goStraight(new int[] {cur[0], cur[1]}, i, board);
                if (visited[newPosition[0]][newPosition[1]]) {
                    continue;
                }
                visited[newPosition[0]][newPosition[1]] = true;
                queue.add(new int[] {newPosition[0], newPosition[1], cur[2] + 1});
            }

        }
    }
    public int solution(String[] board) {
        int[] target = new int[2];
        int[] myPosition = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'G') {
                    target[0] = i;
                    target[1] = j;
                } else if (board[i].charAt(j) == 'R') {
                    myPosition[0] = i;
                    myPosition[1] = j;
                }
            }
        }
        boolean isPromising = false;
        for (int i = 0; i < dirs.length; i++) {
            int newY = target[0] + dirs[i][0];
            int newX = target[1] + dirs[i][1];
            if (newY >= 0 && newY < board.length &&
                    newX >= 0 && newX < board[0].length()) {
                if (board[newY].charAt(newX) == 'D') {
                    isPromising = true;
                }
            } else isPromising = true;
        }
        if (!isPromising) {
            return -1;
        }
        visited = new boolean[board.length][board[0].length()];
        bfs(myPosition, target, board, 0);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else return result;
    }
}