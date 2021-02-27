// Best Appraoch

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Pointer to point at the top
        int i = 0;
        int j = 0;
        
        for (int k = 0 ; k < pushed.length ; k++) {
            int top = pushed[k];
            // point the latest element to the top
            pushed[i] = top;
            while(i >= 0 && pushed[i] == popped[j]) {
                i--;
                j++;
            }
            i++;
        }
                
        return i == 0;
    }
}

//My Approach

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        if(pushed.length != popped.length) return false;

        Stack<Integer> st = new Stack<>();
        int i=0;
        int j=0;
        

        
        while(i<pushed.length && j<popped.length){
            
            st.push(pushed[i++]);
            
            while(!st.isEmpty() && st.peek() == popped[j]){
                
                st.pop();
                j++;
            }
            
            
        }
        
        return i==j;
    }
}
