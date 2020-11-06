class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        
        int ans = 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[nums.length -1];i++){
            int result = 0;
            for(int j = 0; j < nums.length;j++){
                double result1 = nums[j] * (1.0) / i;
                if(Math.ceil(result1) == result1)
                 result1 = result1;
                else
                     result1 = Math.floor(result1) + 1;
                result += result1;
                
            }
            if(min >= result && result <= threshold){
                min = result;
                ans = i;
                break;
                
            }
        }
        return ans;
    }
}

// Time limit exceded 
// By the way code is correct
