import java.util.Arrays;
import java.util.Stack;

class Solution {
  class N {
    int num;
    int idx;

    public N(int num, int idx) {
      this.num = num;
      this.idx = idx;
    }
  }
 public int[] solution(int[] numbers) {
    Stack<N> stack = new Stack<>();
    stack.add(new N(numbers[0], 0));
    int[] answer = new int[numbers.length];
    Arrays.fill(answer, -1);
    for (int i = 1; i < numbers.length; i++) {
      while (!stack.isEmpty()) {
          N n = stack.pop();
          if (numbers[i] > n.num) {
            answer[n.idx] = numbers[i];
          } else {
            stack.push(n);
            break;
          }
      }
      stack.push(new N(numbers[i], i));
    }
    return answer;
  }
}