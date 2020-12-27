// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        int i = 1;
        int count = 1;
        while(n > count){
            i++;
            if(primeFactors(i) == 1)
                count++;
        }
        return i;
    }
    
    int primeFactors(int n){
        n = check(n,2);
        n = check(n,3);
        n = check(n,5);
        return n == 1 ? 1 : 0;
    }
    int check(int a,int b) {
		while(a % b == 0) {
			a = a / b;
		}
		return a;
    }
}
// Brute Force Approach TLE

//https://www.geeksforgeeks.org/ugly-numbers/
