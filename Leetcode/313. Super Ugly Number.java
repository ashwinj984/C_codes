class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ind = new int[primes.length];
        int[] dp = new int[n];
        int currMin = 1;
        for(int i = 0; i < n; i++){
            dp[i] = currMin;
            currMin = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if(dp[i] == primes[j] * dp[ind[j]]){
                    ind[j]++;
                }
                currMin = Math.min(currMin, primes[j] * dp[ind[j]]);
            }
        }
        return dp[n - 1];
    }
}
