import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int solution(String[][] book_time) {
    PriorityQueue<int[]> queueStart = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    PriorityQueue<int[]> queueEnd = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    for (int i = 0; i < book_time.length; i++) {
      String startTime = book_time[i][0];
      String endTime = book_time[i][1];

      int start = (startTime.charAt(0) - '0') * 600 + (startTime.charAt(1) - '0') * 60
          + (startTime.charAt(3) - '0') * 10 + (startTime.charAt(4) - '0');
      int end = (endTime.charAt(0) - '0') * 600 + (endTime.charAt(1) - '0') * 60
          + (endTime.charAt(3) - '0') * 10 + (endTime.charAt(4) - '0');
      queueStart.add(new int[] {start, end});
    }

    int tmp = 0;
    int total = 0;
    
    while (!queueStart.isEmpty()) {
      int[] customer = queueStart.poll();
      int tmpTime = customer[0];

      if (!queueEnd.isEmpty()) {
        int[] usingRoom = queueEnd.poll();
        if (tmpTime < usingRoom[1] + 10) {
          queueEnd.add(usingRoom);
          tmp++;
        }
      } else {
        tmp++;
      }

      if (total < tmp) {
        total = tmp;
      }

      queueEnd.add(customer);
    }
    
    return total;
  }
}