class Solution {
  public int solution(int[][] board) {
    int max = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 1 && i > 0 && j > 0) {
          int min = Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1]);
          board[i][j] = min + 1;
          max = Math.max(max, board[i][j]);
        } else if (board[i][j] == 1) {
          if (max == 0) {
            max = 1;
          }
        }
      }
    }
    return max * max;
  }
}