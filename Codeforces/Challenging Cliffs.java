import java.util.*;
import java.io.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] parts = br.readLine().split(" ");
			int[] arr = new int[n];
			// [] check = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(parts[i]);
				// check[i] = Integer.parseInt(parts[i]);
			}
			Arrays.sort(arr);
			int minDiff = Integer.MAX_VALUE;
			int x = -1;
			int y = -1;
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] - arr[i - 1] < minDiff) {
					minDiff = arr[i] - arr[i - 1];
					x = i - 1;
					y = i;
				}
			}
			int[] ans = new int[n];
			ans[0] = arr[x];
			ans[n - 1] = arr[y];
			int j = 1;
			for(int i = y + 1; i < n; i++) {
				ans[j] = arr[i];
				j++;
			}
			for(int i = 0; i < x; i++) {
				ans[j] = arr[i];
				j++;
			}
			for(int i = 0; i < n; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}
}
