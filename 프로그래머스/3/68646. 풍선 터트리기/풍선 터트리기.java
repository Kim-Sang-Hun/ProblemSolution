class Solution {
    public int solution(int[] a) {
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int left = a[0];
        int right = a[a.length-1];
        
        for(int i = 1; i < a.length - 1; i++) {
            if (left > a[i]) {
                left = a[i];
            }
            leftMin[i] = left;
        }
        
        for(int i = a.length - 2; i > 0; i--) {
            if(right > a[i]) {
                right = a[i];
            }
            rightMin[i] = right;
        }
        
        if(a.length == 1) return 1;
        int answer = 2;
        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }
        return answer;
    }
}