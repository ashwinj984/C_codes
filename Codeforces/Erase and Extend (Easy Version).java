import java.util.*;
import java.io.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split(" ");
			int n = Integer.parseInt(parts[0]);
			int k = Integer.parseInt(parts[1]);
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			StringBuilder best = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(s.charAt(i));
				StringBuilder have = new StringBuilder();
				while(have.length() < k) {
					have.append(sb);
				}
				while(have.length() > k) {
					have.deleteCharAt(have.length() - 1);
				}
				if(i == 0 || have.toString().compareTo(best.toString()) < 0) {
					best = have;
				}
			}
			System.out.println(best.toString());
		}
	}
}
