// BRUTE FORCE
// TLE 
import java.util.*;

public class Solution {

	//static int sum = 0;
	static int max = 0;
	static int prod = 1;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		helper(n);
		System.out.println(max);
	}

	public static void helper(int n) {
		if(n < 0) {
			return;
		}
		if (n == 0) {
			if (prod > max) {
				max = prod;
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			prod = prod * i;

			helper(n - i);
			prod /= i;
		}
	}

}

// Another Approach
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j <= (int) Math.ceil(i / 2.0); j++) {
				dp[i] = Math.max(dp[i], dp[i - j] * j);
			}
			
			dp[i] = i != n ? Math.max(dp[i], i) : dp[i];
		}
        return dp[n];
    }
}
// BEST APPROACH 
class Solution {
  public int integerBreak(int n) {
    Integer[] dp = new Integer[n];
    return explore(n, 0, dp);
  }
  
  public int explore(int n, int sum, Integer[] dp) {
    if(sum > n) return 0;
    if(sum == n) return 1;
    if(dp[sum] != null) return dp[sum];
    
    int max = Integer.MIN_VALUE/2;
    
    for(int i = 1; i < n; i++) {
      int res = explore(n, sum + i, dp);
      max = Math.max(max, res * i);
    }
    dp[sum] = max;
    return max;
  }
}
