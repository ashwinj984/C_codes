class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        // if(i == -1){
        //     Arrays.sort(nums);
        //     return;
        // }
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(int[] nums,int start){
        int end = nums.length - 1;
        while(end > start){
            swap(nums,start,end);
            end--;
            start++;
        }
    }
}
