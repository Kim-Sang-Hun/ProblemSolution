import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();

        int pivot = 0;
        int cnt = 0;
        while (true) {
            cnt++;
            pivot += cnt;

            if (pivot >= X) {
                break;
            }
        }
        int diff = pivot - X;
        int dividend = 0;
        int divider = 0;
        if (cnt % 2 == 0) {
            dividend = cnt - diff;
            divider = 1 + diff;
        } else {
            dividend = 1 + diff;
            divider = cnt - diff;
        }
        System.out.printf("%d/%d", dividend, divider);
    }
}