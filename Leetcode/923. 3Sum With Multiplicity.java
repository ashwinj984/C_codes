// Sorting Approach

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000000 + 7;
        long ans = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; ++i){
            int t = target - arr[i];
            
            int j = i + 1;
            int k = arr.length - 1;
            
            while(j < k){
                if(arr[j] + arr[k] > t){
                    k--;
                }else if(arr[j] + arr[k] < t){
                    j++;
                }else if(arr[j] != arr[k]){
                    int left = 1;
                    int right = 1;
                    while(j + 1 < k && arr[j] == arr[j + 1]){
                        left++;
                        j++;
                    }
                    
                    while(k - 1 > j && arr[k] == arr[k - 1]){
                        right++;
                        k--;
                    }
                    
                    ans += left * right;
                    ans %= mod;
                    j++;
                    k--;
                }else{
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= mod;
                    break;
                }
            }
        }
        return (int) ans;
    }
}
