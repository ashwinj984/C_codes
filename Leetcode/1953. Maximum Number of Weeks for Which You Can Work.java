// BY SORTING
class Solution {
    public long numberOfWeeks(int[] arr) {
        long ans = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++){
            ans += arr[i];
        }
        
        ans += Math.min(ans + 1, arr[n - 1]);
        return ans;
    }
}

// Without Sorting

class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for(int i = 0; i < milestones.length; i++){
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        
        return Math.min(sum, 2 * (sum - max) + 1);
    }
}
