class Solution {
    public int answer = 0;
    public void dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        } else {
            dfs(numbers, target, sum + numbers[depth], depth + 1);
            dfs(numbers, target, sum - numbers[depth], depth + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
}