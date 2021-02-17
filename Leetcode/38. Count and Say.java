class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "11";
        }else{
            String str = countAndSay(n - 1);
            return buildStr(str);
        }
    }
    
    public String buildStr(String s){
        int i = 0;
        int j = 1;
        StringBuilder sb = new StringBuilder();
        while(i < j && j <= s.length()){
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            
            sb.append(j - i + "");
            sb.append(s.charAt(i));
            
            i = j;
            j++;
        }
        return sb.toString();
    }
}
