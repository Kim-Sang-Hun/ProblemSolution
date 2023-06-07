class Solution {
    
    int min = Integer.MAX_VALUE;

    public void mine(int[][] count, int[] picks, int idx, int[] used, int sum) {
        if (min <= sum) {
            return;
        }
        if (idx == count.length || (picks[0] - used[0] == 0 && picks[1] - used[1] == 0 && picks[2] - used[2] == 0)) {
            min = sum;
            return;
        }
        for (int i = 0; i < picks.length; i++) {
            int available = picks[i] - used[i];
            int[] newUsed = used.clone();
            if (available > 0) {
                newUsed[i]++;
                if (i == 0) {
                    sum += count[idx][0] + count[idx][1] + count[idx][2];
                    mine(count, picks, idx + 1, newUsed, sum);
                    sum -= count[idx][0] + count[idx][1] + count[idx][2];
                } else if (i == 1) {
                    sum += count[idx][0] * 5 + count[idx][1] + count[idx][2];
                    mine(count, picks, idx + 1, newUsed, sum);
                    sum -= count[idx][0] * 5 + count[idx][1] + count[idx][2];
                } else {
                    sum += count[idx][0] * 25 + count[idx][1] * 5 + count[idx][2];
                    mine(count, picks, idx + 1, newUsed, sum);
                    sum -= count[idx][0] * 25 + count[idx][1] * 5 + count[idx][2];
                }
                newUsed[i]--;
            }
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int n;
        if (minerals.length % 5 == 0) {
            n = minerals.length / 5;
        } else {
            n = minerals.length / 5 + 1;
        }
        int[][] count = new int[n][3];
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                count[i / 5][0]++;
            } else if (minerals[i].equals("iron")) {
                count[i / 5][1]++;
            } else {
                count[i / 5][2]++;
            }
        }
        mine(count, picks, 0, new int[]{0, 0, 0}, 0);
        System.out.println(min);
        return min;
    }
}