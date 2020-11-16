//Bestest Approach

class Solution {
    public int longestMountain(int[] a) {
       if(a.length == 0){
           return 0;
       }
        int max = 0;
        int l = 0;
        int hi = 0;
        for(int i = 1; i < a.length - 1; i++){
            if(a[i-1] < a[i] && a[i] > a[i + 1]){
                l = i-1;
                hi = i + 1;
                while(l > 0 && a[l] > a[l-1]){
                    l--;
                }
                while(hi < a.length - 1 && a[hi] > a[hi + 1]){
                    hi++;
                }
                max = Math.max(max,hi-l+1);
            }
        }
        
        return max;
    }
}

//different approaches

class Solution {
    public int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }
}


// one more

class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int n = A.length;
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i-1]) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }
        int ans = 0;
        int r = 1;
        for (int i = n - 2; i > 0; i--) {
            if (A[i] > A[i + 1]) {
                r = r + 1;
                if (r + inc[i] - 1 >= 3 && inc[i] >= 2) {
                    ans = Math.max(ans, r + inc[i] - 1);
                }
            } else r = 1;
        }
        return ans;
    }
}
