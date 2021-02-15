// https://leetcode.com/contest/weekly-contest-228/problems/minimum-limit-of-balls-in-a-bag/

class Solution {
    public int minimumSize(int[] nums, int maxOperation) {
        int lo = 1;
		int hi = Integer.MAX_VALUE;
		
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			
			if(canDivide(mid, nums, maxOperation)) {
				hi = mid;
			}else {
				lo = mid + 1;
			}
		}
		return hi;
    }
    
    public boolean canDivide(int mid, int[] nums, int maxOperation) {
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > mid) {
				if(nums[i] % mid == 0) {
					count += nums[i] / mid - 1;
				}else {
					count += nums[i] / mid;
				}
				
				if(count > maxOperation) {
					return false;
				}
			}
		}
		return true;
	}
    
}
