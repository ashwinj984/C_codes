import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int d = scn.nextInt();
		System.out.println(findMinSteps(n, m, d));
		
	}

	public static int findMinSteps(int n, int m, int d) {
		if (m > n) {
			int t = m;
			m = n;
			n = t;
		}

		if (d > n) {
			return -1;
		}

		if (d % gcd(m, n) != 0) {
			return -1;
		}

		return Math.min(pour(n, m, d), pour(m, n, d));

	}
	
	public static int pour(int n, int m, int d) {
		int from = n;
		int to = 0;
		int step = 1;
		while(from != d && to != d) {
			int toPour = Math.min(from, m - to);
			
			to += toPour;
			from -= toPour;
			step++;
			if(from == d || to == d) {
				break;
			}
				
			if(from == 0) {
				from = n;
				step++;
			}
			if(to == m) {
				to = 0;
				step++;
			}
			
		}
		return step;
	}

	public static int gcd(int m, int n) {

		while (m % n != 0) {
			int rem = m % n;
			m = n;
			n = rem;
		}
		return n;
	}

}
