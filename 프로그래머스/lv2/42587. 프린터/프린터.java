import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            queue.add(i);
        }
        Arrays.sort(priorities);
        int cnt = 0;

        for (int i = priorities.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                while (map.get(queue.peek()) != priorities[i]) {
                    queue.add(queue.poll());
                }
                int isTarget = queue.poll();
                cnt++;
                if (isTarget == location) {
                    break;
                }
            }
        }
        return cnt;
    }
}