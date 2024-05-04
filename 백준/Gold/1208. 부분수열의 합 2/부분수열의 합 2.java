import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static long cnt;
    static int[] arr;
    static List<Integer> left;
    static List<Integer> right;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        makeList(0, n / 2, 0, left);
        makeList(n / 2, n, 0, right);
        Collections.sort(left);
        Collections.sort(right);
        twoPointer();
        System.out.println(cnt);
    }

    private static void makeList(int idx, int end, int sum, List<Integer> list) {
        if (idx == end) {
            list.add(sum);
            return;
        }

        makeList(idx+1, end, sum + arr[idx], list);
        makeList(idx+1, end, sum, list);
    }

    private static void twoPointer() {
        int l = 0;
        int r = right.size() - 1;

        while (l < left.size() && r >= 0) {
            int lv = left.get(l);
            int rv = right.get(r);
            int sum = lv + rv;

            if (sum > s) {
                --r;
            } else if (sum < s) {
                ++l;
            } else {
                long cnt1 = 0;
                while (l < left.size() && left.get(l) == lv) {
                    ++l;
                    ++cnt1;
                }
                long cnt2 = 0;
                while (r >= 0 && right.get(r) == rv) {
                    --r;
                    ++cnt2;
                }
                cnt += cnt1 * cnt2;
            }
        }
        if (s == 0) --cnt;
    }
}