// TLE 
// Kya faaltu approach ka DP se socha maine
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= k; j++){
                if(i + j < nums.length){
                    max = Math.max(max, dp[i + j]);
                }
            }
            dp[i] = max + nums[i];
        }
        return dp[0];
    }
}

// better appraoch
// abhi soch raha hoon.............
class Solution {
    public int maxResult(int[] A, int k) {
        int n = A.length;
        int[] dp = new int[n];
        dp[n - 1] = A[n - 1];
        
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(n - 1);
        for(int i = n - 2; i >= 0; i--){
            // remove index out of current window
            while(dq.peekLast() > i + k){
                dq.removeLast();
            }
            
            dp[i] = A[i] + dp[dq.peekLast()];
            
            while(dq.isEmpty() == false && dp[i] > dp[dq.peekFirst()]){
                dq.removeFirst();
            }
            dq.addFirst(i);
        }
        return dp[0];
    }
}
