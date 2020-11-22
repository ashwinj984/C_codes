//https://leetcode.com/contest/weekly-contest-216/problems/smallest-string-with-a-given-numeric-value/


class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
            Arrays.fill(arr,'a');
        for(int i = n - 1; i >=0;i--){
            k = k - i;
            if(k >= 0){
                if(k >= 26){
                    arr[i] = 'z';
                    k = k - 26;
                }else{
                    arr[i] = (char)(k + 97 - 1);
                    k = k - arr[i] - 97 + 1;
                }
            }else{
                break;
            }
            k = k + i;
            
        }
        return new String(arr);
    }
}
