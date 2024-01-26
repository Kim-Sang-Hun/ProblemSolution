import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        int time;
        int answer = -1;
        for (int i = 0; i < N; i++) {
            queue.add(arr[i]);
            time = arr[i][0];
            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                queue.poll();
            }
            answer = Math.max(answer, queue.size());
        }
        System.out.println(answer);
    }
}
