import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			String[] parts = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(parts[i]);
			}

			Arrays.sort(arr);
			long sum = arr[n - 1];
			long[] neg = new long[n];
			neg[0] = 0;
			for(int i = 1; i < n ; i++) {
				neg[i] = neg[i - 1]  + i * (arr[i] - arr[i - 1]);
				sum -= neg[i];
			}
			System.out.println(sum);
		}
	}

}
