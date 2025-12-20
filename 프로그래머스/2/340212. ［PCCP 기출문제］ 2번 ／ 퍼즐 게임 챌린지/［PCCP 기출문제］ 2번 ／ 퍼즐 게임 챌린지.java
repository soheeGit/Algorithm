import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (solve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    public boolean solve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        
        for (int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int timePrev;
                if(i == 0) timePrev = 0;
                else timePrev = times[i - 1];
                
                int mistakes = diffs[i] - level;
                totalTime += (long)(times[i] + timePrev) * mistakes + times[i];
            }
        }
        
        if(totalTime <= limit) return true;
        return false;
    }
}