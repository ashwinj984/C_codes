class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        Boolean [][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, s2, s3, 0, 0, dp);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            dp[i][j] = isInterleave(s1, s2, s3, i + 1, j, dp);
        }
        
        if ((dp[i][j] == null || dp[i][j] == false) && 
            j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            dp[i][j] = isInterleave(s1, s2, s3, i, j + 1, dp);
        }
        
        return dp[i][j] == null ? false : dp[i][j];
    }
}

// next approach
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp[0].length; i++){
            if(s2.charAt(i - 1) == s3.charAt(i - 1)){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 1; i < dp.length; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s3.charAt(i + j - 1) == s1.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                if(s3.charAt(i + j - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
