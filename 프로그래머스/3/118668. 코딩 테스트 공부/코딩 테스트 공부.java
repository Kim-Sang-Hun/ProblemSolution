public class Solution {

    public static int solution(int alp, int cop, int[][] problems) {
        // 초기 알고리즘 레벨과 코딩 레벨의 최댓값을 설정
        int maxAlp = alp;
        int maxCop = cop;

        // 주어진 문제들을 순회하며 최댓값 갱신
        for (int[] problem : problems) {
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }

        // DP 테이블 초기화
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                // 초기값으로 10000 설정
                dp[i][j] = 10000;
            }
        }
        // 시작점 초기화
        dp[alp][cop] = 0;

        // DP 테이블 채우기
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                int minAlp = Math.min(i + 1, maxAlp);
                int minCop = Math.min(j + 1, maxCop);

                // 알고리즘 공부 레벨을 1 증가시키는 경우
                dp[minAlp][j] = Math.min(dp[minAlp][j], dp[i][j] + 1);
                // 코딩 레벨을 1 증가시키는 경우
                dp[i][minCop] = Math.min(dp[i][minCop], dp[i][j] + 1);

                // 주어진 문제들을 풀 경우의 DP 값 갱신
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int newAlp = Math.min(maxAlp, i + problem[2]);
                        int newCop = Math.min(maxCop, j + problem[3]);
                        dp[newAlp][newCop] =
                            Math.min(dp[newAlp][newCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        // 최종 결과값 반환
        return dp[maxAlp][maxCop];
    }
}

