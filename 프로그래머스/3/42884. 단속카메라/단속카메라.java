import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        int pos = -30001;
        for (int[] cur : routes) {
            if (pos < cur[0]) {
                ++cnt;
                pos = cur[1];
            }
        }
        
        return cnt;
    }
}