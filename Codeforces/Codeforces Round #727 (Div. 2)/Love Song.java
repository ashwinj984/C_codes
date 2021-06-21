// prefix sum
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Solution {
	///static int[] arr = new int[26];
	public static void main(String[] args) throws Exception {
//		for(int i = 0; i < 26; i++) {
//			/arr[i] = i + 1;
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		int n =Integer.parseInt(parts[0]);
		int q = Integer.parseInt(parts[1]);
		String s = br.readLine();
		int[] arr = new int[s.length()];
		arr[0] = (int)(s.charAt(0) - 'a' + 1);
		for(int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + (int)(s.charAt(i) - 'a' + 1);
			//System.out.println(arr[i]);
		}
		for(int i = 0; i < q; i++) {
			//int count = 0;
			String[] part = br.readLine().split(" ");
			int o = Integer.parseInt(part[0]);
			int y = Integer.parseInt(part[1]);
			if(o - 1 != 0) {
				System.out.println(arr[y - 1] - arr[o - 2]);
			}else {
				System.out.println(arr[y - 1]);
			}
			//System.out.println(count);
		}
	}
}
