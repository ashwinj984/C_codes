// TLE

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                ArrayList<Integer> list = new ArrayList<>();
                for(int k = i; k <= j;k++){
                    list.add(A[k]);
                }
                if(list.size() >= 3){
                    arr.add(list);
                }
            }
        }
        System.out.println(arr);
        int ans = arr.size();
        for(var a : arr){
            int cd = a.get(1) - a.get(0);
            for(int i = 1; i < a.size() - 1; i++){
                if(a.get(i + 1) - a.get(i) != cd){
                    ans--;
                    break;
                }
            }
            
        }
        return ans;
    }
}

// Better Approach

class Solution {
   int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        
        int cur=0; int sum=0;
        
        for(int i=2; i < A.length ; i++){
            
            if(A[i]-A[i-1] == A[i-1]- A[i-2] ){
                cur++;
                System.out.println(cur);
                sum+=cur;
            }
            else
                cur =0;
        }
        return sum;
    }
}

// Best Appraoch

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        int[] dp = new int[A.length];
        
        for(int i = 2; i < dp.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
