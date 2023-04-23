import java.util.Scanner;

public class Main {
    static int answer = 0;
    public static void dfs(int sum, int depth, int N, int[] arr, int target) {
        if (depth == N) {
            if (sum == target) {
                answer++; 
            }
            return;
        }

        dfs(sum + arr[depth], depth + 1, N, arr, target);
        dfs(sum, depth + 1, N, arr, target);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, N, arr, target);
        if (target == 0) {
            answer -= 1;
        }
        System.out.println(answer);
    }
}