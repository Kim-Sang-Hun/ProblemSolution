import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = N % 5;
        int answer = -1;
        if (N == 4 || N == 7) {
            System.out.println(-1);
        } else {
            if (A == 0) {
                answer = N / 5;
            } else if (A == 1 || A == 3) {
                answer = N / 5 + 1;
            } else if (A == 2 || A == 4) {
                answer = N / 5 + 2;
            }
            System.out.println(answer);
        }
    }
}