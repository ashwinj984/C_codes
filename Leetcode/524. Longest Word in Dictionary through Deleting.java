// My Approach

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        
        for(String str : d){
            int i = 0;
            int j = 0;
            
            while(i < str.length() && j < s.length()){
                if(s.charAt(j) == str.charAt(i)){
                    i++;
                }
                
                j++;
            }
            if(i == str.length() && (str.length() > ans.length() || (str.length() == ans.length() && ans.compareTo(str) > 0))){
                ans = str;
            }
        }
        
        return ans;
    }
}


//Better Approach

class Solution {
    public String findLongestWord(String s, List<String> d) {

        String res="";
        for (String c: d)
            if ((c.length() > res.length() || c.length()==res.length() && c.compareTo(res)<0) && isSubseq(c, s)) res=c;
        return res;
    }
    public boolean isSubseq(String a, String b){
        int j = -1;
        for(int i = 0; i < a.length(); i++){
            j = b.indexOf(a.charAt(i), j + 1);
            if(j == -1) {
                return false;
            }
        }
        return true;
    }
}
