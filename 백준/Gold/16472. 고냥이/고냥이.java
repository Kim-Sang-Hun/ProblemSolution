import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String catSound = br.readLine();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      map.put((char)(i + 'a'), 0);
    }
    int var = 0;
    int len = 0;
    int maxLen = 0;

    for (int i = 0; i < catSound.length(); i++) {
      if (map.get(catSound.charAt(i)) == 0) {
        ++var;
        ++len;
      } else {
        ++len;
      }
      map.put(catSound.charAt(i), map.get(catSound.charAt(i)) + 1);
      while (var > N) {
        int removeIdx = i - len + 1;
        map.put(catSound.charAt(removeIdx), map.get(catSound.charAt(removeIdx)) - 1);
        --len;
        if (map.get(catSound.charAt(removeIdx)) == 0) {
          --var;
        }
      }
      maxLen = Math.max(maxLen, len);
    }
    System.out.println(maxLen);
  }
}