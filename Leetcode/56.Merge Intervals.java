//Best Solution

class Solution {
    public int[][] merge(int[][] intervals) {
        
    int len = intervals.length, count = len, idx = 0;
    for (int i = 0; i < len - 1; i++) {
      int[] s1 = intervals[i];
      for (int j = i + 1; j < len; j++) {
        int[] s2 = intervals[j];
            if (s1[0] <= s2[1] && s2[0] <= s1[1]) {
                  s2[0] = Math.min(s1[0], s2[0]);
                  s2[1] = Math.max(s1[1], s2[1]);
                  s1[0] = 1;
                  s1[1] = 0;
                  count--;
                  break;
            }
        }
    }
    int[][] res = new int[count][];
    for (int i = 0; i < len; i++) {
      if (intervals[i][1] < intervals[i][0]) {
        continue;
      }
      res[idx++] = intervals[i];
    }
    return res;
    }
}

// My solution :( :(

class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1){
            return intervals;
        }
//         Arrays.sort(intervals, new Comparator<int[]>() {
//     @Override
//     public int compare(int[] o1, int[] o2) {
//         return Integer.compare(o2[0], o1[0]);
//     }
// });
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]));
        
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        for(int i = 1 ; i < intervals.length;++i){
            int[] temp = st.pop();
            if(temp[1] < intervals[i][0]){
                st.push(temp);
                st.push(intervals[i]);
            }else if(temp[1] >= intervals[i][0] && temp[1] < intervals[i][1]){
                temp[1] = intervals[i][1];
                st.push(temp);
            }else if(temp[1] >= intervals[i][0] && temp[1]  >= intervals[i][1]){
                st.push(temp);
            }   
        }
        int[][] arr = new int[st.size()][2];
        for(int i = arr.length - 1; i>= 0; i--){
            int[] temp = st.pop();
            arr[i][0] = temp[0];
            arr[i][1] = temp[1];
        }
        
        return arr;
    }
}
