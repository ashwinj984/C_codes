class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0||n == 1){
            return n;
        }
        
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 2; i < n + 1; i++){
            int q = i / 2;
            if(i % 2 == 0){
                
                nums[i] = nums[q];
            }else{
                
                nums[i] = nums[q] + nums[q + 1];
            }
            int maxu = nums[i];
            if(maxu > max){
                max = maxu;
            }
        }
        return max;
    }
}
