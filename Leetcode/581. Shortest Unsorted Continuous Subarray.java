// My Stack Approach

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int left = nums.length - 1;
        for(int i = 0; i < nums.length;){
            if(st.size() == 0){
                st.push(i);
                i++;
            }else{
                if(nums[st.peek()] > nums[i]){
                    left = Math.min(left, st.peek());
                    st.pop();
                }else{
                    st.push(i);
                    i++;
                }
            }
        }
        st.clear();
        int right = 0;
        for(int i = nums.length - 1; i >= 0;){
            if(st.size() == 0){
                st.push(i);
                i--;
            }else{
                if(nums[st.peek()] < nums[i]){
                    right = Math.max(right, st.peek());
                    st.pop();
                }else{
                    st.push(i);
                    i--;
                }
            }
        }
        if(left >= right){
            return 0;
        }else{
            return right - left + 1;
        }
    }
}

// Best Approach 

// AND I AM AMAZED WHY I WAS NOT ABLE TO FIGURE OUT THIS APPROACH BY MYSELF

class Solution{
  public int findUnsortedSubarray(int[] nums) {
        int end = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= num) {
                num = nums[i];
            } else {
                end = i;
            }
        }
        int start = nums.length;
        num = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] <= num) {
                num = nums[j];
            } else {
                start = j;
            }
        }
        if (start == nums.length) {
            return 0;
        }
        return end - start + 1;
    }
}
