// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
   static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> findPath(int[][] m, int n) {
        list.clear();
        
        if(m[n - 1][n -1] == 0){
            return list;
        }
       
        solve(m,n,0,0,"");
        Collections.sort(list);
        return list;
    }
    
    public static void solve(int[][] arr, int n, int i, int j, String sb){
        if(i < 0 || i >= n || j < 0 || j >= n){
            return;
        }
        
        if(arr[i][j] == 0){
            return;
        }
        
        if(i == n - 1 && j == n - 1){
            list.add(sb);
            return;
        }
        
        arr[i][j] = 0;
        
        solve(arr, n, i + 1, j, sb + "D");
        solve(arr, n,i, j - 1, sb + "L");
        solve(arr, n,i, j + 1, sb + "R");
        solve(arr, n,i - 1, j, sb + "U"));
        
        arr[i][j] = 1;
        
    }
}
