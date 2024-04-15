import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   static int min, cnt;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());

      int[] obUp = new int[H + 1];
      int[] obDown = new int[H + 1];
      min = N / 2;
      cnt = 1;
      int obstacle = N / 2;
      boolean even = true;
      for (int i = 0; i < N; i++) {
         int height = Integer.parseInt(br.readLine());
         if (even) {
            obDown[height]++;
         } else {
            obUp[H - height]++;
         }
         even = !even;
      }

      for (int i = 1; i < H; i++) {
         obstacle = obstacle - obDown[i] + obUp[i];
         if (obstacle < min) {
            min = obstacle;
            cnt = 1;
         } else if (obstacle == min) {
            ++cnt;
         }
      }
      System.out.println(min + " " + cnt);
   }
}