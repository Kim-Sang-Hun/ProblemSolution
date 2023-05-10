import java.util.Arrays;
import java.util.Comparator;
class Solution {
        public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(x -> x[1]));
        double fire = 0.5;

        for (int[] target : targets) {
            if (fire < target[0] || fire == 0.5) {
                answer++;
                fire = target[1] - 0.5;
            }
        }
        return answer;
    }
}