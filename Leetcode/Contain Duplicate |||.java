class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       TreeSet<Long> tset = new TreeSet<>();
		for(int i = 0; i < nums.length;i++) {
			Long m1 = tset.floor((long)nums[i]);
			Long m = tset.ceiling((long)nums[i]);
			if(m1 != null&&nums[i] - m1 <= t) {
				return true;
			}
			if(m!=null && m-nums[i] <= t) {
				return true;
			}
			
			tset.add((long)nums[i]);
			if(tset.size()>k) {
				tset.remove((long)nums[i-k]);
			}
		}
		return false;
    }
}
