import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    char[] target = br.readLine().toCharArray();
    char[] start = new char[K];
    for (int i = 0; i < start.length; i++) {
      start[i] = (char) ('A' + i);
    }
    int center = 0;
    for (int i = 0; i < N; i++) {
      char[] line = br.readLine().toCharArray();
      if (line[0] == '?') {
        center = i + 1;
        break;
      }
      for (int j = 0; j < line.length; j++) {
        if (line[j] == '-') {
          char tmp = start[j];
          start[j] = start[j + 1];
          start[j + 1] = tmp;
        }
      }
    }
    char[][] memorizeNext = new char[N - center][K];
    for (int i = 0; i < N - center; i++) {
      char[] line = br.readLine().toCharArray();
      memorizeNext[i] = line;
    }
    for (int i = N - center - 1; i >= 0; i--) {
      char[] line = memorizeNext[i];
      for (int j = line.length - 1; j >= 0; j--) {
        if (line[j] == '-') {
          char tmp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = tmp;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    for (int i = 0; i < target.length - 1; i++) {
      if (start[i] != target[i]) {
        if (sb.length() > 0 && sb.substring(sb.length() - 1).charAt(0) == '-') {
          flag = true;
          break;
        }
        sb.append('-');
        char tmp = target[i];
        target[i] = target[i + 1];
        target[i + 1] = tmp;
      } else sb.append('*');
    }
    if (flag) {
      sb = new StringBuilder();
      for (int i = 0; i < K - 1; i++) {
        sb.append('x');
      }
    }
    System.out.println(sb);
  }
}