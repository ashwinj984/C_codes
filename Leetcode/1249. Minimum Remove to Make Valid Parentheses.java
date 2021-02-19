class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else if(s.charAt(i) == ')'){
                if(st.size() > 0){
                    st.pop();
                }else
                    set.add(i);
            }
        }
        
        while(st.size() > 0){
            set.add(st.pop());
        }
        
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            if(set.contains(i)){
                continue;
            }
            
            ans = ans + s.charAt(i);
        }
        return ans;
    }
}
