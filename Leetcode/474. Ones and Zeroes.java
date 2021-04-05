// Brute Force

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }
    
    public int helper(String[] strs, int zeros, int ones, int idx){
        if(idx == strs.length || zeros + ones == 0){
            return 0;
        }
        // count no of 1's and 0's present in the coming value;
        
        int[] count = getCount(strs[idx]);
        // either we have to consider or we have to skip
        
        // consider
        int consider = 0;
        if(zeros >= count[0] && ones >= count[1]){
            consider = 1 + helper(strs, zeros - count[0], ones - count[1], idx + 1);
        }
        
        // skip
        
        int skip = helper(strs, zeros, ones, idx + 1);
        
        return Math.max(consider, skip);
        
    }
    
    public int[] getCount(String s){
        int[] count = new int[2];
        for(char ch : s.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}

// Memoization
class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1][strs.length];
        return helper(strs, m, n, 0);
    }
    
    public int helper(String[] strs, int zeros, int ones, int idx){
        if(idx == strs.length || zeros + ones == 0){
            return 0;
        }
        if(dp[zeros][ones][idx] > 0){
            return dp[zeros][ones][idx];
        }
        // count no of 1's and 0's present in the coming value;
        
        int[] count = getCount(strs[idx]);
        // either we have to consider or we have to skip
        
        // consider
        int consider = 0;
        if(zeros >= count[0] && ones >= count[1]){
            consider = 1 + helper(strs, zeros - count[0], ones - count[1], idx + 1);
        }
        
        // skip
        
        int skip = helper(strs, zeros, ones, idx + 1);
        
        dp[zeros][ones][idx] =  Math.max(consider, skip);
        return  dp[zeros][ones][idx];

    }
    
    public int[] getCount(String s){
        int[] count = new int[2];
        for(char ch : s.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}

// Dyanammic Programming
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for(String s : strs){
            int[] count = getCount(s);
            
            for(int zeros = m; zeros >= count[0] ; zeros--){
                for(int ones = n; ones >= count[1]; ones--){
                    dp[zeros][ones] = Math.max(1 + dp[zeros - count[0]][ones - count[1]], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }
    
    public int[] getCount(String s){
        int[] count = new int[2];
        for(char ch : s.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}
