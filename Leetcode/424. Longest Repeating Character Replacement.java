class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int[] arr = new int[26];
        int start = 0;
        int end = 1;
        
        int max = 0;
        int maxTillNow = 1;
        arr[s.charAt(0) -'A']++;
        for(; end < s.length(); end++){
            
            arr[s.charAt(end)-'A']++;
            maxTillNow = Math.max(maxTillNow,arr[s.charAt(end)-'A']);
            if(maxTillNow + k < end - start + 1){
                // sliding window technique
                arr[s.charAt(start) - 'A']--;
                start++;
            }else{
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}
