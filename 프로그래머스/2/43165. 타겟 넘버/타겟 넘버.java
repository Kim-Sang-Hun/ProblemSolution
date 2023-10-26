class Solution {
    
  int answer = 0;

// DFS를 이용한다. 각 번호의 숫자를 뺀 경우와 더한 경우의 수로 나누어 재귀적으로 찾는다.
// 예상 시간복잡도 O(2^n)
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