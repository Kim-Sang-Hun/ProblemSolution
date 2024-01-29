import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static Deque<Integer> deque;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            s.nextInt();
            deque = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                deque.add(s.nextInt());
            }
            loop:
            while (true) {
                for (int i = 1; i <= 5; i++) {
                    int tmp = deque.pollFirst() - i;
                    deque.addLast(tmp);
                    if (tmp <= 0) {
                        deque.pollLast();
                        deque.addLast(0);
                        break loop;

                    }
                }
            }

            System.out.printf("#%d ", tc);
            for (int j = 0; j < 8; j++) {
                System.out.print(deque.pollFirst() + " ");
            }
            System.out.println();
        }
    }
}
