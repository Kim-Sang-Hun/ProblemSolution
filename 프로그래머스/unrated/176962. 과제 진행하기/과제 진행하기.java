import java.util.*;
class Solution {
    public void popStack(Stack<String[]> stack, List<String> list, String[] nowTime, String[] startTime) {
        if (!stack.isEmpty()) {
            String[] strings = stack.pop();
            int playTime = Integer.parseInt(strings[2]);
            int nowHour = Integer.parseInt(nowTime[0]);
            int nowMin = Integer.parseInt(nowTime[1]);
            int startHour = Integer.parseInt(startTime[0]);
            int startMin = Integer.parseInt(startTime[1]);
            int diff = (startHour - nowHour) * 60 + startMin - nowMin;
            
            if (playTime == diff) {
                list.add(strings[0]);
            } else if (playTime < diff) {
                list.add(strings[0]);
                if (nowMin + playTime < 60) {
                    nowTime[1] = String.valueOf(nowMin + playTime);
                } else {
                    nowTime[0] = String.valueOf(nowHour + 1);
                    nowTime[1] = String.valueOf(nowMin + playTime - 60);
                }
                popStack(stack, list, nowTime, startTime);
            } else {
                strings[2] = String.valueOf(playTime - diff);
                stack.push(strings);
            }
        }
    }

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparingInt(o -> Integer.parseInt(o[1].replace(":", "")))
                );
        Stack<String[]> stack = new Stack<>();
        String[] nowTime = plans[0][1].split(":");
        String[] answer = new String[plans.length];
        List<String> list = new ArrayList<>();

        for (int i = 0; i < plans.length; i++) {
            String[] startTime = plans[i][1].split(":");
            popStack(stack, list, nowTime, startTime);
            stack.push(plans[i]);
            nowTime = startTime;
        }

        while (!stack.isEmpty()) {
            String[] strings = stack.pop();
            list.add(strings[0]);
        }
        for (int i = 0; i < plans.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}