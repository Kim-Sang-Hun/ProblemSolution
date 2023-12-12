import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String[] input;
    int[] parsedInput;
    for (int i = 0; i < T; i++) {
      input = br.readLine().split(" ");
      parsedInput = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      int x1 = parsedInput[0];
      int y1 = parsedInput[1];
      double len1 = parsedInput[2];
      int x2 = parsedInput[3];
      int y2 = parsedInput[4];
      double len2 = parsedInput[5];
      double lenBetween = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

      // 두 좌표가 같은 경우
      if (x1 == x2 && y1 == y2 && len1 == len2) {
        System.out.println(-1);
      } else if (lenBetween > Math.pow(len1 + len2, 2)) {
        System.out.println(0);
      } else if (lenBetween < Math.pow(len1 - len2, 2)) {
        System.out.println(0);
      } else if (lenBetween == Math.pow(len1 + len2, 2)) {
        System.out.println(1);
      } else if (lenBetween == Math.pow(len1 - len2, 2)){
        System.out.println(1);
      } else {
        System.out.println(2);
      }
    }
  }
}