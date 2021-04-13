class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        
        int lo = 1;
        int hi = k + 1;
        for(int i = 0; i < k + 1; i++){
            if(i % 2 == 0){
                ans[i] = lo;
                lo++;
            }else{
                ans[i] = hi;
                hi--;
            }
        }
        
        
        for(int i = k + 1; i < n; i++){
            ans[i] = i + 1;
        }
        return ans;
    }
}
