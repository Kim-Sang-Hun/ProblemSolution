import java.util.Scanner;

public class Main {
    public static void solution(int[] arr, int T, int start) {
        if (T == 0) {
            return;
        }
        if (start == arr.length - 1) {
            return;
        }
        int idx = 0;
        int max = 0;
        if (start + T >= arr.length - 1) {
            for (int i = start; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
        } else {
            for (int i = start; i <= start + T; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
        }
        for (int i = 0; i < idx - start; i++) {
            swap(arr, idx - i, idx - i - 1);
            T--;
        }
        solution(arr, T, start + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int T = sc.nextInt();
        
        solution(arr, T, 0);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}