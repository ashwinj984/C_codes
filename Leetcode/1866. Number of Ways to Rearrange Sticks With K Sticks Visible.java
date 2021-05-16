class Solution {
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];
        dp[0][0] = 1;
        int mod = (int) 1e9 + 7;
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = ((j - 1) * dp[i][j - 1] % mod + dp[i - 1][j - 1]) % mod;
            }
        }
        return (int) dp[k][n];
    }
}
