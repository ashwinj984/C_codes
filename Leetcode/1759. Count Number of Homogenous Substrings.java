class Solution {
    public int countHomogenous(String s) {
        int ans = 0;
        int mod = 1000000007;
        
        int p = 0;
        while(p < s.length()){
            int curr = 1;
            int i = 1;
            while(p + 1 < s.length() && s.charAt(p) == s.charAt(p + 1)){
                p++;
                i++;
                curr = (curr + i) % mod;
             }
            
            ans += curr % mod;
            p++;
        }
        return ans;
    }
    
}
