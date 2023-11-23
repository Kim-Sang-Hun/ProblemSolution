class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int hap = sequence[0];
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        while (left <= sequence.length) {

            if (hap < k) {
                if (right == sequence.length - 1) {
                    break;
                }
                right++;
                hap += sequence[right];
            } else if (hap > k) {
                hap -= sequence[left];
                left++;
            } else if (hap == k) {
                if (min > right - left) {
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                    if (min == 0) {
                        return new int[]{minLeft, minRight};
                    }
                }
                if (right == sequence.length - 1) {
                    break;
                }
                right++;
                hap += sequence[right];
            }
        }
        return new int[] {minLeft, minRight};
    }
}