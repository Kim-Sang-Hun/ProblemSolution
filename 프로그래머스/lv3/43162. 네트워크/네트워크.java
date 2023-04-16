import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    int cnt = 0;

    public boolean checkNetwork(List<ArrayList<Integer>> list, int idx, boolean[] visited) {
        if (visited[idx]) {
            return false;
        }
        visited[idx] = true;
        for (int i = 0; i < list.get(idx).size(); i++) {
            checkNetwork(list, list.get(idx).get(i), visited);
        }
        return true;
    }

    public int solution(int n, int[][] computers) {
        if (n == 1) {
            return 1;
        }
        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    arr.add(j);
                }
            }
            list.add(arr);
        }
        int[] linked = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (checkNetwork(list, i, visited)) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return 1;
        }

        return cnt;
    }
}