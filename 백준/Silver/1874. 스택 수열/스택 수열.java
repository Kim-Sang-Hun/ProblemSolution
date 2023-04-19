import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");
            while (stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
                sb.append("-\n");
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}