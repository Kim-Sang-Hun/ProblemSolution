class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int N = board.length;
        int M = board[0].length;
        int[][] acc = new int[N + 1][M + 1];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) degree *= -1;
            acc[r1][c1] += degree;
	        acc[r1][c2 + 1] -= degree;
	        acc[r2 + 1][c1] -= degree;
	        acc[r2 + 1][c2 + 1] += degree;
        }
        
        int cnt = 0;
        int status = 0;
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                acc[y][x] += acc[y - 1][x];
            }
        }
        // 좌우
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                acc[y][x] += acc[y][x - 1];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + acc[i][j] > 0) ++cnt;
            }
        }

        return cnt;
    }
}