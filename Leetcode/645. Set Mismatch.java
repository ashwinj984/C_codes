class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] count = new int[10000 + 1];
        int max = 0;
        for(int num : nums){
            count[num]++;
            max = Math.max(num,max);
        }
        
        for(int i = 1; i <= max; i++){
            if(count[i] == 2){
                result[0] = i;
            }else if(count[i] == 0){
                result[1] = i;
            }
        }
        if(result[1] == 0){
            result[1] = max + 1;
        }
        
        return result;
    }
}
