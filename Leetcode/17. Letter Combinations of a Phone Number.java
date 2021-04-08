// 1st method
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            List<String> res = new ArrayList<>();
            return res;
        }
        
        List<String> ans = letterCombination(digits);
        return ans;
        
        
    }
    
     public List<String> letterCombination(String digits) {
        if(digits.length() == 0){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        char ch = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> res = new ArrayList<>();
        List<String> rr = letterCombination(ros);
        String seq = getChoice(ch);
        
        for(String str : rr){
            for(int i = 0; i < seq.length(); i++){
                String k = seq.charAt(i) + str;
                res.add(k);
            }
        }
        return res;
    }
    
    
    // 2nd Mehod
    class Solution {
    String [] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
             List<String> result = new ArrayList<>();
                return result;
        }
        
        List<String> ans = new LinkedList<>();
        dfs(0, new StringBuilder(), digits, ans);
        return ans;
    }
    
    public void dfs(int idx, StringBuilder current, String digits, List<String> ans){
        if(idx == digits.length()){
            ans.add(current.toString());
            return;
        }
        
        char currentChar = digits.charAt(idx);
        
        for(var neighbor : map[currentChar - '0'].toCharArray()){
            current.append(neighbor);
            dfs(idx + 1, current, digits, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
    
    public String getChoice(char ch){
        if(ch == '2'){
            return "abc";
        }else if(ch == '3'){
            return "def";
        }else if(ch == '4'){
            return "ghi";
        }else if(ch == '5'){
            return "jkl";
        }else if(ch == '6'){
            return "mno";
        }else if(ch == '7'){
            return "pqrs";
        }else if(ch == '8'){
            return "tuv";
        }else if(ch == '9'){
            return "wxyz";
        }else{
            return "";
        }
    }
}
