class Solution {
    int mod = (int)(1e9 + 7);
    public int countVowelPermutation(int n) {
        long[][] dp = new long[5][n + 1];
        for(int i = 0; i < 5; i++){
            dp[i][1] = 1;
        }
        
        for(int i = 2; i <=n; i++){
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % mod;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1] + dp[3][i - 1] + dp[4][i - 1]) % mod;
            dp[3][i] = (dp[2][i - 1] + dp[4][i - 1]) % mod;
            dp[4][i] = dp[0][i - 1];
        }
        
        long sum = 0;
        sum = dp[0][n] + dp[1][n] + dp[2][n] + dp[3][n] + dp[4][n];
        return (int)(sum % mod);
    } 
}
