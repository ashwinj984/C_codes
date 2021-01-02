class Solution {
    public boolean isSubsequence(String s, String t) {
        //ArrayList<String> s1 = FindSubsequence(s,0);
        ArrayList<String> s2 = FindSubsequence(t,0);
        for(int i = 0; i < s2.size(); i++){
            if(s2.get(i).equals(s)){
                return true;
            }   
        }
        return false;
    }
    
    public ArrayList<String> FindSubsequence(String s,int index){
        if(index == s.length()){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }        
        ArrayList<String> res = FindSubsequence(s,index + 1);
        int len = res.size();
        for(int i = 0; i < len; i++){
            String k = s.charAt(index) + res.get(i);
            res.add(k);
        }
        return res;
    }
}

//Memory Limit Exceeded

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        for(int i = 0;i < s.length(); i++){
            int indx = t.indexOf(s.charAt(i));
            
            if(indx == -1){
                return false;
            }else{
                t = t.substring(indx + 1);
            }
        }
        return true;
    }
}
// 100 % faster
