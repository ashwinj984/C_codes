class Solution {
     public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
    
}

// Sliding window approach
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int start = 0;
        int end = 0;
        int windowCount = 0;
        while(end < nums.length){
            if(nums[end] >= left && nums[end] <= right){
                windowCount = end - start + 1;
            }else if(nums[end] > right){
                windowCount = 0;
                start = end + 1;
            }else if(nums[end] < left){
                windowCount = windowCount;
            }
            res += windowCount;
            end++;
        }
        return res;
    }
}
