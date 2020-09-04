import java.util.*;
public class Largest_time {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		String b = check(nums);
		System.out.println(b);
	}
	public static String check(int[] nums) {
		String ans = "";
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				for(int k = 0; k < nums.length;k++) {
					if(i == j || j == k|| k == i) {
						continue;
					}
					int l = 6 - i - j - k;
					String h = ""+nums[i] + nums[j];
					String m = ""+nums[k] + nums[l];
					String t = h +":"+ m;
					if(h.compareTo("24")<0 && m.compareTo("60")<0&& t.compareTo(ans)>0) {
						ans = t;
					}
				}
			}
		}
		return ans;
	}
}
