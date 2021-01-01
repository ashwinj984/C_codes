class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int l = 1;
        int r = 1;
        int res = nums[0];
        int n = nums.length;
        for(int i = 0; i < nums.length ; i++){
            if(l == 0){
                l = 1 * nums[i];
            }else {
                l = l * nums[i];
            }
            
            if(r == 0){
                r  = 1 * nums[n - 1 - i];
            }else{
                r = r * nums[n - i - 1];
            }
            
            res = Math.max(Math.max(r,l),res);
        }
        return res;
        
    }
}

//2nd approach

class Solution {
     int max = Integer.MIN_VALUE;
     protected void dfs(int[] nums, int res, int index){
         if (index > nums.length-1)
             return;
         res = res * nums[index];
         max  = Math.max(max, res);
         dfs(nums, res, index+1);    
     }
     public int maxProduct(int[] nums) {
         if (nums.length == 0)
             return 0;
        
         for (int i=0;i<nums.length;i++){
             int res = 1;
             dfs(nums,res, i);
         }
         return max;
     }
