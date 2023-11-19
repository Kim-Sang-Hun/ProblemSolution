import java.util.Arrays;

public class Solution {

    int[] max;

    public int[] solution(int[][] users, int[] emoticons) {
        max = new int[users.length + 1];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] usedMoney = new int[users.length];
        boolean[] gotService = new boolean[users.length];

        dfs(users, emoticons, usedMoney, gotService, 0);

        for (int i = max.length - 1; i >= 0; i--) {
            if (max[i] >= 0) {
                return new int[]{i, max[i]};
            }
        }
        return new int[]{0, 0};
    }

    public void dfs(int[][] users, int[] emoticons, int[] usedMoney, boolean[] gotService, int idx) {
        if (idx == emoticons.length) {
            int totalMoney = 0;
            int count = 0;
            for (int i = 0; i < gotService.length; i++) {
                if (!gotService[i]) {
                    totalMoney += usedMoney[i];
                } else {
                    count++;
                }
            }
            if (max[count] < totalMoney) {
                max[count] = totalMoney;
            }
            return;
        }
        for (int i = 10; i <= 40; i += 10) {
            int price = emoticons[idx] * (100 - i) / 100;
            int[] tmpUsedMoney = Arrays.copyOf(usedMoney, usedMoney.length);
            boolean[] tmpGotService = Arrays.copyOf(gotService, gotService.length);

            for (int j = 0; j < users.length; j++) {
                if (tmpGotService[j]) {
                    continue;
                }
                if (users[j][0] > i) {
                    continue;
                }
                if (users[j][1] > price + tmpUsedMoney[j]) {
                    tmpUsedMoney[j] += price;
                    continue;
                }
                tmpGotService[j] = true;
            } 
            dfs(users, emoticons, tmpUsedMoney, tmpGotService, idx + 1);
        }
    }
}
