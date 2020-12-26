import java.util.*;
public class DecodeWays {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String  s =  scn.next();
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;//Empty String there is one way to solve it that is Empty Way
		dp[1] = 1;//One character one way to solve the problem
		
		for(int i = 2; i <= s.length(); i++) {
			int fistCut = Integer.valueOf(s.substring(i-1,i));
			int secondCut = Integer.valueOf(s.substring(i-2,i));
			
			if(fistCut > 0) {
				dp[i] = dp[i-1];
			}
			
			if(secondCut >= 10 && secondCut <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
		}
		
		System.out.println(dp[s.length()]);
		
		/* Hindi mai iss logic ko kahu tu ye logic bata raha hai ki nth term
		 * 	is asking me that "tell me how much was the result for n-1 th term
		 * and if I am >0 then update me with the same result as n-1 
		 * 
		 * Now take second cut and check if I am >= 10 and <= 26 . if it is true
		 * then update my dp by adding it's own result with dp[i-1]
		 * 
		 *!!!Done
		 */
	}

}
