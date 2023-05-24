class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i < r2; i++) {
            double maxY2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            int Y2toInt = (int) maxY2;
            if (i < r1) {
                double maxY1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
                int Y1toInt = (int) maxY1;
                if (maxY1 == Y1toInt) {
                    answer += Y2toInt - Y1toInt + 1;
                } else {
                    answer += Y2toInt - Y1toInt;
                }
            } else {
                answer += Y2toInt;
            }
        }
        return answer * 4 + (r2 - r1 + 1) * 4L;
    }
}