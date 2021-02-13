import java.util.*;
//https://www.hackerearth.com/problem/algorithm/even-subarray-2-641faa7a/description/
public class EvenSubarray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int[][] dp = new int[arr.length + 1][arr.length + 1];
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(i == j) {
					dp[i][j] = arr[i - 1];
				}else if(i < j) {
					dp[i][j] = dp[i][j - 1] * arr[j - 1];
				}
			}
		}
		int count = 0;
		for(int i = 0; i < dp.length; i++) {
			//System.out.println();
			for(int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
				if(dp[i][j] % 2 == 0 && dp[i][j] != 0) {
					count++;
				}
			}
		}
		
		System.out.println(count);

	}

}
