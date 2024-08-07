import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoScore = wanho[0] + wanho[1];
        int rank = 1;
        int max = 0;
        
        Arrays.sort(scores, (o1, o2) -> {
            return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]);
        });
        int highAttitude = scores[0][0];
        
        for (int[] score : scores) {
            if (max <= score[1]) {
                max = score[1];
                if (score[0] + score[1] > wanhoScore) rank++;
            } else if (score.equals(wanho)) return -1;
        }
        
        return rank;
    }
}