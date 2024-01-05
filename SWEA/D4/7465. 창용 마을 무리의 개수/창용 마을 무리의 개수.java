import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static int N, M, count, answer, arr[];
    static Set<Integer> set;
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	N = s.nextInt();
            M = s.nextInt();
            answer = 0;
            count = 0;
            arr = new int[N + 1];
            set = new HashSet<>();
            for (int i = 0; i < M; i++) {
            	int a = s.nextInt();
                int b = s.nextInt();
                if (arr[a] != 0 && arr[b] != 0) {
                    int from = arr[a] > arr[b] ? arr[a] : arr[b];
                    int to = arr[a] > arr[b] ? arr[b] : arr[a];
                    for (int j = 1; j <= N; j++) {
                    	if (arr[j] == from) {
                            arr[j] = to;
                        }
                    }
                } else if (arr[a] != 0) {
                	arr[b] = arr[a];
                } else if (arr[b] != 0) {
                	arr[a] = arr[b];
                } else {
                	arr[a] = arr[b] = a > b ? b : a;
                }
            }
            for (int i = 1; i <= N; i++) {
            	if (arr[i] != 0) {
					set.add(arr[i]);
                } else {
                	count++;
                }
            }
            System.out.printf("#%d %d\n", tc, set.size() + count);
        }
        
    }
}