//Binary Search
//it can also be make better by applying bit operator but I don't know that now
// This in my case is the best
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int hi = nums[nums.length - 1];
        int ans = 0;
        while(low<=hi){
            int mid = (low + hi)/2;
            long sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % mid == 0){
                    sum += nums[i] / mid;
                }else{
                    sum += nums[i] / mid  + 1;
                }
            }
            if(sum > threshold){
                low = mid + 1;
            }else{
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }
}
