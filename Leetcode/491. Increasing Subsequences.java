class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> path= new ArrayList<>();
        if(nums == null || nums.length < 1){
            return new ArrayList<>();
        }
        dfs(set, path,  0, Integer.MIN_VALUE, nums);
        return new ArrayList<>(set);
    }
    
    public void dfs(Set<List<Integer>> set, List<Integer> path, int start, int curr, int[] nums){
        if(start >= nums.length){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(nums[i] >= curr){
                path.add(nums[i]);
                if(path.size() >= 2){
                    set.add(new ArrayList<>(path));
                }
                dfs(set, path, i + 1, nums[i], nums);
            }else if(nums[i] < curr){
                continue;
            }
            if(path.size() >= 1)
               path.remove(path.size() - 1);
        }
    }
}
