public class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
                
        int num = s.length();
        int ans = 0;
        int i = 0;
        int j = 0;
        
        while (i < num && j < num) {
            
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
                if(ans < j - i){
                    ans = j-i;    
                }
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
