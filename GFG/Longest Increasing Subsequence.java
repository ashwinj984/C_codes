//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends


class Solution { 
    // return length of longest strictly increasing subsequence
    static int longestSubsequence(int size, int arr[]){
        int n = size;
        int[] dp = new int[n];
		//dp[0] = 1;
		int omax = 0;
		for(int i = 0; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					if(dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			
			if(omax < dp[i]) {
				omax = dp[i];
			}
		}
		return omax;
		
    }
}

//Time Complexity O(n * n)


