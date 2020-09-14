class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        vector<int> v;
        recursion(k,n,ans,v,0,0);
        return ans;
    }
    void recursion(int k,int n,vector<vector<int>> &ans,vector<int> &v,int currSum,int lastnumberused){
        if(v.size() > k || currSum > n){
            return;
        }
        if(v.size() == k && currSum == n){
            ans.push_back(v);
            return;
        }
        for(int i = lastnumberused + 1; i<= 9; i++){
            v.push_back(i);
            recursion(k,n,ans,v,currSum + i, i);
            v.pop_back();
        }
    }
};
