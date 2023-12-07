import java.util.*;
class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, int[]> timeCheck = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < records.length; i++) {
            String s = records[i];
            StringTokenizer st = new StringTokenizer(s);

            String time = st.nextToken();
            String carNo = st.nextToken();
            String[] timeSplit = time.split(":");
            int minute = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            int carNoInt = Integer.parseInt(carNo);

            int[] defaultArr = new int[] {0, 0, 0};
            int[] check = timeCheck.getOrDefault(carNoInt, defaultArr);
            int isIn = check[1];

            // 처음 입차시
            if (Arrays.equals(check, defaultArr)) {
                timeCheck.put(carNoInt, new int[] {minute, 1, 0});
                continue;
                // 이미 입차 후 두번 째 입차시
            }
            if (isIn == 0) {
                check[0] = minute;
                check[1] = 1;
                timeCheck.put(carNoInt, check);
                continue;
            }
            // 출차시
            check[2] = check[2] + minute - check[0];
            check[1] = 0;
            check[0] = minute;
            timeCheck.put(carNoInt, check);
        }
        for (Integer i : timeCheck.keySet()) {
            int[] val = timeCheck.get(i);
            int usedTime = val[2];
            if (val[1] == 1) {
                usedTime += 24 * 60 - 1 - val[0];
            }
            queue.add(new int[] {i, usedTime});
        }
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            int usedTime = queue.poll()[1];
            if (usedTime < fees[0]) {
                answer[i] = fees[1];
                continue;
            }
            int extraTime = (usedTime - fees[0]) / fees[2];
            int haveToAdd = (usedTime - fees[0]) % fees[2];
            if (haveToAdd != 0) {
                extraTime++;
            }
            answer[i] = fees[1] + extraTime * fees[3];
        }
        return answer;
    }
}