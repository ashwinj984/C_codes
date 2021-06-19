import java.util.*;
import java.io.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			int i = Integer.parseInt(parts[2]);
			int j = Integer.parseInt(parts[3]);
			// at present i,j
			if (n == 1 && m == 1) {
				System.out.println("1 1 1 1");
			} else if (n == 1) {
				System.out.println("1 1 1 " + m);
			} else if (m == 1) {
				System.out.println("1 1 "+n+" 1");
			} else if (i == n && j == n) {
				System.out.println(n + " 1 1 " + m);
			} else if (i == n && j == 1) {
				System.out.println(n + " " + m + " 1 1");
			} else if (i == 1 && j == 1) {
				System.out.println(n + " 1 1 " + m);
			} else {
				System.out.println(n + " 1 1 " + m);
			}
 
		}
	}
 
}
