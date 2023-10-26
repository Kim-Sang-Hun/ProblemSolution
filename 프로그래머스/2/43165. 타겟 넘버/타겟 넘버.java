class Solution {
  int answer = 0;

  public int solution(int[] numbers, int target) {
    dfs(numbers, target, 0, numbers[0]);
    dfs(numbers, target, 0, -numbers[0]);
    return answer;
  }

  public void dfs(int[] numbers, int target, int idx, int sum) {
    if (idx == numbers.length - 1 && sum == target) {
      answer++;
    }
    if (idx + 1 >= numbers.length) {
      return;
    }
    dfs(numbers, target, idx + 1, sum - numbers[idx + 1]);
    dfs(numbers, target, idx + 1, sum + numbers[idx + 1]);
  }
}