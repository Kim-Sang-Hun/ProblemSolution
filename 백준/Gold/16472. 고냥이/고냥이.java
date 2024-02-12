import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String catSound = br.readLine();
    int[] charCount = new int[26];

    int alphaCnt = 0;
    int len = 0;
    int maxLen = 0;

    for (int i = 0; i < catSound.length(); i++) {
      int charIdx = catSound.charAt(i) - 'a';
      if (charCount[charIdx]++ == 0) {
        ++alphaCnt;
      }
      ++len;
      while (alphaCnt > N) {
        int removeIdx = catSound.charAt(i - len + 1) - 'a';
        --charCount[removeIdx];
        --len;
        if (charCount[removeIdx] == 0) {
          --alphaCnt;
        }
      }
      maxLen = Math.max(maxLen, len);
    }
    System.out.println(maxLen);
  }
}