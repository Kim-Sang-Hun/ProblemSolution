import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        PriorityQueue<String> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
        );
        queue.addAll(set);
        for (int i = 0; i < set.size(); i++) {
            System.out.println(queue.poll());
        }
    }
}