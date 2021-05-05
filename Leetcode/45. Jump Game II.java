// TLE
class Solution {
    int count = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        reachToEnd(nums, nums.length - 1, 0, 0);
        return count;
    }
    
    public void reachToEnd(int[] nums, int end, int curr, int jump){
        if(curr > nums.length - 1){
            return;
        }
        if(curr == end){
            if(count > jump){
                count = jump;
            }
            return;
        }
        
        for(int i = 1; i <= nums[curr]; i++){
            reachToEnd(nums, end, curr + i, jump + 1);
        }
        
        
    }
}

// Optimal
class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            int steps = nums[i];
            
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= steps && i + j < nums.length; j++){
                if(dp[i + j] != null && dp[i + j] < min){
                    min = dp[i + j];
                }
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}
