class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        
        int max = 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j] += 1;
                }
            }
            
            max = Math.max(max,findArea(height));
        }
        return max;
    }
    
    public int findArea(int[] arr){
        if(arr.length == 0 || arr == null){
            return 0;
        }
        int[] lb = new int[arr.length];
        int[] rb = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }
        
        st = new Stack<>();
        
        rb[arr.length - 1] = arr.length;
        st.push(arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }
        
        int maxArea = 0;
        for(int i = 0; i < arr.length ; i++){
            int area = (rb[i] - lb[i] - 1) * arr[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
