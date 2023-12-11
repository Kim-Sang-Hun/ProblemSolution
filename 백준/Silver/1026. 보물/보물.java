import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> queueA = new PriorityQueue<>();
    PriorityQueue<Integer> queueB = new PriorityQueue<>(Comparator.reverseOrder());

    String[] strings = br.readLine().split(" ");
    for (String string : strings) {
      queueA.add(Integer.parseInt(string));
    }
    strings = br.readLine().split(" ");
    for (String string : strings) {
      queueB.add(Integer.parseInt(string));
    }
    br.close();
    int answer = 0;
    for (int i = 0; i < N; i++) {
      answer += queueA.poll() * queueB.poll();
    }
    System.out.println(answer);
  }
}