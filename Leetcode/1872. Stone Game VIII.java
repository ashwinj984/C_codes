
// Meaning -> the dp[i] means "if Alice first pick is i, the max score difference we could have"?
/* There will be two side on every i
The logic says that if alice choses i then bob will choose left and hence we have to chose max from sum[i] - dp[i + 1] and dp[i + 1];
*/


class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[stones.length];
        prefixSum[0] = stones[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i -1] + stones[i];
        }
        
        int[] dp = new int[n];
        dp[n -1] = prefixSum[n - 1];
        for(int i = n - 2; i >= 0; i--){
            dp[i] = Math.max(prefixSum[i] - dp[i + 1], dp[i + 1]);
        }
        
        return dp[1];
    }
}

// Better Approach

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for(int i = 1; i< n; i++)stones[i] += stones[i-1];
        int best = stones[n-1];
        for(int i = n-2; i> 0; i--)
            best = Math.max(best, stones[i]-best);
        return best;
    }
}
