import java.util.*;
import java.io.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if((n&1) == 1) {
				System.out.println("Bob");
			}else if((n&(n-1)) == 0) {
				int c = 0;
				while(n > 0) {
					n = n / 2;
					c++;
				}
				if((c&1) == 1) {
					System.out.println("Alice");
				}else {
					System.out.println("Bob");
				}
			}else {
				System.out.println("Alice");
			}
		}
	}
}
