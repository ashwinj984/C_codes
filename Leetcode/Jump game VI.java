// TLE 
// Kya faaltu approach ka DP se socha maine
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= k; j++){
                if(i + j < nums.length){
                    max = Math.max(max, dp[i + j]);
                }
            }
            dp[i] = max + nums[i];
        }
        return dp[0];
    }
}

// better appraoch
// abhi soch raha hoon.............
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.
        dq.offer(0);
        for (int i = 1; i < n; ++i) {
            // nums[i] = max(nums[i-k], nums[i-k+1], .., nums[i-1]) + nums[i] = nums[dq.front()] + nums[i]
            nums[i] = nums[dq.peekFirst()] + nums[i];

            // Add nums[i] to our deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast(); // Eliminate elements less or equal to nums[i], which will never be chosen in the future
            dq.offerLast(i);

            // Remove if the last element is out of window size k
            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return nums[n - 1];
    }
}
