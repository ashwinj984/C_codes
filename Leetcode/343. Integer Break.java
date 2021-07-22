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
