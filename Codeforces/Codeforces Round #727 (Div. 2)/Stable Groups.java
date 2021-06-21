import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		String[] parts = br.readLine().split(" ");
		int n = (int) Long.parseLong(parts[0]);
		long k =  Long.parseLong(parts[1]);
		long x =  Long.parseLong(parts[2]);
		String[] part = br.readLine().split(" ");
		Long[] arr = new Long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(part[i]);
		}
		Arrays.sort(arr);
		ArrayList<Long> l = new ArrayList<>();
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - arr[i - 1] > x) {
				l.add((arr[i] - arr[i - 1] - 1)/x);
			}
		}
		Collections.sort(l);
		Collections.reverse(l);
		while(l.size() > 0) {
			if(l.get(l.size() - 1) <= k) {
				k -= l.get(l.size() - 1);
				l.remove(l.size() - 1);
			}else {
				break;
			}
		}
		System.out.println(l.size() + 1);
	}
}
