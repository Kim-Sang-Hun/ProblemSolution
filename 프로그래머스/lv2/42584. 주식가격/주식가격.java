import java.util.PriorityQueue;
import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        for (int i = 0; i < prices.length; i++) {
            if (!pq.isEmpty()) {
                if (prices[i] < pq.peek()[1]) {
                    while (prices[i] < pq.peek()[1]) {
                        int[] a = pq.poll();
                        answer[a[0]] = i - a[0];
                        if (pq.isEmpty()) {
                            break;
                        }
                    }
                }
                pq.add(new int[] {i, prices[i]});
            } else {
                pq.add(new int[] {i, prices[i]});
            }
        }
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            answer[a[0]] = prices.length - 1 - a[0];
        }
        return answer;
    }
}