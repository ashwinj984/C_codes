
import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int t = 1;
		// t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			solve();
		}
	}
	public static class pair implements Comparable<pair>{
		long first;
		long second;
		public pair(long b, long a) {
			this.first = b;
			this.second = a;
		}
		@Override
		public int compareTo(pair o) {
			return Long.compare(this.first, o.first);
		}
		
	}
	public static void solve() throws Exception {
		int n = Integer.parseInt(br.readLine());
		ArrayList<pair> l = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			long a = Long.parseLong(parts[0]);
			long b = Long.parseLong(parts[1]);
			l.add(new pair(b, a));
		}
		Collections.sort(l);
		long ans = 0;
		long bought = 0;
		int s = 0;
		int end = n - 1;
		while(s <= end) {
			if(l.get(s).first <= bought) {
				bought += l.get(s).second;
				ans += l.get(s).second;
				s++;
			}else {
				long req = Math.min(l.get(s).first - bought, l.get(end).second);
				bought += req;
				l.get(end).second -= req;
				ans += 2 * req;
				if(l.get(end).second == 0) {
					end--;
				}
			}
		}
		System.out.println(ans);
		
		
	}
}
