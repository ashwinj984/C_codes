class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0){
            return 0;
        }
        vector<int> ans(nums.size());
        
        ans[0] = nums[0];
        int n = nums.size();
        if(nums.size() > 1){
            ans[1] = max(nums[0],nums[1]);
        }
        for(int i = 2; i < nums.size(); i++){
            ans[i] = max(ans[i-1],ans[i-2]+nums[i]);
        }
        return ans[n-1];
        
    }
};


//https://leetcode.com/problems/house-robber/
