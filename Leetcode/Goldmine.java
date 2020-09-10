import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        
        // just think why i used loop in reverse form
        for(int j = dp[0].length - 1; j >= 0; j--) {
    	 for(int i = dp.length - 1; i >= 0; i--) {
    		 if(j == arr[0].length - 1) {
    			 dp[i][j] = arr[i][j];
    		 }
    		 else if(i == 0) {
    			 dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
    		 }
    		 else if(i == dp.length - 1) {
    			 dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
    		 }
    		 else {
    			 dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
    		 }
    	 }
     }
     int max = Integer.MIN_VALUE;
     for(int i = 0; i < dp.length; i++) {
    	 if(max<dp[i][0]) {
    		 max = dp[i][0];
    	 }
     }
     System.out.println(max);
    }

}
