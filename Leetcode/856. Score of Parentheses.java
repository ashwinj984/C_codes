class Solution {
    public int scoreOfParentheses(String S) {
        int open = 0, score = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c == '(') open++;
            else {
                open--;
                if (S.charAt(i-1) == '(')
                    score += Math.pow(2, open);
            }
        }
        return score;
    }
}


// 2nd Approach

class Solution {
    public int scoreOfParentheses(String S) {
        
        Stack<Integer> results = new Stack<>();
        int out = 0;
        
        for (char c : S.toCharArray()){
            if (c == '('){
                results.push(out);
                out = 0;
            }
            else{
                out = results.pop() + Math.max(out * 2, 1);
            }
        }
        return out;
    }
}
