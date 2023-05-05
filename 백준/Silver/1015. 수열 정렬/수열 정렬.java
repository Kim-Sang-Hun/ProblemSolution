import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void sort(int[][] A) {
        Arrays.sort(A, (next, cur) ->
        {
            if (next[0] < cur[0]) {
                return -1;
            } else if (next[0] > cur[0]) {
                return 1;
            } else {
                return Integer.compare(next[1], cur[1]);
            }
        });
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i;
        }
        sort(arr);
        int[] B = new int[N];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int idx = arr[i][1];
            B[idx] = i;
        }
        for (int i = 0; i < N; i++) {
            sb.append(B[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}