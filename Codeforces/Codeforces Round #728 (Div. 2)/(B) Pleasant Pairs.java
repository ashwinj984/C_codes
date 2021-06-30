import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] a = new long[n + 1];
			String[] parts = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(parts[i - 1]);
			}
			int ans = 0;
	        for (int i = 1; i <= n; i++)
	        {
	            for (int j = (int) (a[i] - i); j <= n; j += a[i])
	            {
	                if (j >= 0)
	                    if (a[i] * a[j] == i + j && i < j)
	                        ans++;
	            }
	        }
			System.out.println(ans);
		}
	}

}
