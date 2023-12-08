import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int cnt = 1;

        for (int i = 64; i >= 1; i /= 2) {
            int rest = num % i;
            if (rest == 0) {
                break;
            }
            if (rest != num) {
                num = rest;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
