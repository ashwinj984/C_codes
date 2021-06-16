// Recursive Approach
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res  = new ArrayList<>();
        generateParentheses(n, 0, "", res);
        return res;
    }
    
    void generateParentheses(int nLeft, int open, String str, List<String> res){
        if(nLeft== 0 && open == 0){
            res.add(str);
            return;
        }
        
        
        if(open > 0){
            generateParentheses(nLeft ,open - 1, str + ")", res);
        }
        
        if(nLeft > 0){
            generateParentheses(nLeft - 1, open + 1, str + "(", res);
        }
        
    }
}
// BackTrack Approach
// 100% faster
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, n, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder sb, int n, int open, int close){
        if(sb.length() == n * 2 && open == n && close == n){
            res.add(sb.toString());
            return;
        }
        
        if(open < n){
            helper(res, sb.append("("), n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(close < open){
            helper(res, sb.append(")"), n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
