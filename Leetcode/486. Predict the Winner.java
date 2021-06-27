class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; j++,i++){
                 if(g == 0){
                     dp[i][j] = nums[i];
                 }else if(g == 1){
                     dp[i][j] = Math.max(nums[i], nums[j]);
                 }else{
                     int val1 = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                     int val2 = nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                     dp[i][j] = Math.max(val1, val2);
                 }
            }
        }
        
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        
        return dp[0][n - 1] >= sum[n - 1] - dp[0][n - 1];
    } 
}
