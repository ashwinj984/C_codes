// TLE
class Solution {
    public int minFlips(String s) {
        int n = s.length();
      // for sliding window
        s += s;
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < s.length(); i++){
            s1 += i % 2 == 0 ? '0' : '1';
            s2 += i % 2 == 0 ? '1' : '0';
        }
        
        int ans1 = 0;
        int ans2 = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s1.charAt(i)){
                ans1++;
            }
            if(s.charAt(i) != s2.charAt(i)){
                ans2++;
            }
            if(i >= n){
              // nullyfying the effect when sliding window crosses n if we have flipped before
                if(s.charAt(i - n) != s1.charAt(i - n)){
                ans1--;
            }
            if(s.charAt(i - n) != s2.charAt(i - n)){
                ans2--;
            }
            }
            if(i >= n - 1){
                ans = Math.min(ans1, Math.min(ans2, ans));
            }
            
        }
        return ans;
    }
}

