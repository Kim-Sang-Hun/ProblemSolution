class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[4][11][11];
        int answer = 0;
        int y = 5; 
        int x = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if (c == 'U') {
                if (y - 1 < 0) continue;
                if (!visited[0][y][x]) {
                    ++answer;
                    visited[0][y][x] = true;
                    visited[2][y-1][x] = true;
                }
                y -= 1;
            } else if (c == 'L') {
                if (x - 1 < 0) continue;
                if (!visited[1][y][x]) {
                    ++answer;
                    visited[1][y][x] = true;
                    visited[3][y][x-1] = true;
                }
                x -= 1;
            } else if (c == 'D') {
                if (y + 1 > 10) continue;
                if (!visited[2][y][x]) {
                    ++answer;
                    visited[2][y][x] = true;
                    visited[0][y+1][x] = true;
                }
                y += 1;
            } else if (c == 'R') {
                if (x + 1 > 10) continue;
                if (!visited[3][y][x]) {
                    ++answer;
                    visited[3][y][x] = true;
                    visited[1][y][x+1] = true;
                }
                x += 1;
            }
        }        
        
        return answer;
    }
}