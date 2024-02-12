import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();
    int len = bomb.length();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      stack.add(str.charAt(i));

      if (stack.size() >= len) {
        for (int j = 0; j < len; j++) {
          if (stack.get(stack.size() - len + j) != bomb.charAt(j)) {
            break;
          }
          if (j == len - 1) {
            for (int k = 0; k < len; k++) {
              stack.pop();
            }
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }

    System.out.println(stack.isEmpty() ? "FRULA" : sb);
  }
}