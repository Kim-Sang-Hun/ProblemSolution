class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] sumArr = new int[sequence.length];
        sumArr[0] = sequence[0];
        int left = 0;
        if (sumArr[0] == k) {
            return new int[] {0, 0};
        }
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + sequence[i];
            if (sumArr[i] > k) {
                while (sumArr[i] - sumArr[left] > k) {
                    left++;
                }
                if (sumArr[i] - sumArr[left] == k) {
                    if (answer[1] == answer[0] && answer[1] == 0) {
                        answer[0] = left + 1;
                        answer[1] = i;
                    } else if (i - left - 1 < answer[1] - answer[0]) {
                        answer[0] = left + 1;
                        answer[1] = i;
                        if (i - left - 1 == 0) {
                            return answer;
                        }
                    }
                }
            } else if (sumArr[i] == k) {
                answer[1] = i;
            
            }
        }
        return answer;
    }
}