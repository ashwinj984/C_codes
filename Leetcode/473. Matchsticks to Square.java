class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4){
            return false;
        }
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        Arrays.sort(nums);
        
        if(sum % 4 != 0){
            return false;
        }
        int target = sum / 4;
        boolean[] visited = new boolean[nums.length];
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(visited[i] == true){
                continue;
            }
            
            if(dfs(nums, visited, 0, i, target) == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int[] nums, boolean[] visited, int curr, int end, int target){
        curr += nums[end];
        
        if(curr > target){
            return false;
        }
        
        if(curr == target){
            visited[end] = true;
            return true;
        }else{
            for(int i = end - 1; i >= 0; i--){
                if(visited[i]){
                    continue;
                }
                
                if(dfs(nums, visited, curr, i, target)){
                    visited[end] = true;
                    return true;
                }
            }
            return false;
        }
    }
}
