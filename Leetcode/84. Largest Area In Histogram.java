//Brute Force

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        
        for(int i = 0; i < heights.length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < heights.length; j++){
                int distance = j - i + 1;
                    minHeight = Math.min(minHeight,heights[j]);
                int area = distance * minHeight;
                max = Math.max(max,area);
                
            }
        }
        return max;
    }
}
//Time complexity O(n^2)

//Second Method O(nlogn)
 //2. divide and conquer, O(nLogn)
    //The idea is to find the minimum value in the given array. Once we have index of the minimum value, 
    //the max area is maximum of following three values.
    //a) Maximum area in left side of minimum value (Not including the min value)
    //b) Maximum area in right side of minimum value (Not including the min value)
    //c) Number of bars multiplied by minimum value.
    //recusively find the max area for each part
    
   class Solution {
    public int largestRectangleArea(int[] heights) {
        return largetArea(heights,0,heights.length - 1);
    }
    
    private int largetArea(int[] heights,int low,int high){
        if(low > high){
            return 0;
        }
        if(low == high){
            return heights[low];
        }
        
        int minIndex = findMin(heights,low,high);
        int minArea = (high - low + 1) * heights[minIndex];
        int leftArea = largetArea(heights,low,minIndex - 1);
        int rightArea = largetArea(heights,minIndex +1 , high);
        
        return Math.max(minArea,Math.max(leftArea,rightArea));
    }
     
    private int findMin(int[] heights,int low,int high){
        int minIndex = low;
        for(int i = low; i <= high; i++){
            if(heights[minIndex] > heights[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}

//3rd Method
//Time Complexity O(n)
class Solution {
    public int largestRectangleArea(int[] arr) {
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

//Most optimized 
//Without using Stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int[] lefts = new int[heights.length];
        int[] rights = new int[heights.length];
        
        lefts[0] = -1;
        rights[rights.length - 1] = rights.length;
          
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = lefts[l];
            }
            
            lefts[i] = l;
        }
        
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < heights.length && heights[r] >= heights[i]) {
                r = rights[r];
            }
            
            rights[i] = r;
        }
        
        int max = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int area = (heights[i] * (rights[i] - lefts[i] - 1));
            if (area > max) {
                max = area;
            }
        }
        
        return max;
    }
}
