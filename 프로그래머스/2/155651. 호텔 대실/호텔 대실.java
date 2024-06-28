import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] parsed_time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
                        
            parsed_time[i][0] = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            parsed_time[i][1] = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        }
        Arrays.sort(parsed_time, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        int max = 0;
        
        for (int i = 0; i < parsed_time.length; i++) {
            while (!qu.isEmpty() && qu.peek() <= parsed_time[i][0]) {
                qu.poll();
            }
            qu.add(parsed_time[i][1] + 10);
            max = Math.max(max, qu.size());
        }

        return max;
    }
}