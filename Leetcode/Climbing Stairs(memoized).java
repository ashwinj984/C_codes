import java.io.*;
import java.util.*;

public class Main {
    //private static int count = 0;
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int k = countpaths(t,new int[t+1]);
        System.out.println(k);
    }
    public static int countpaths(int n,int[] qb){
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if(qb[n] >0){
            return qb[n];
        }
        int k = countpaths(n-1,qb);
        int l = countpaths(n-2,qb);
        int m = countpaths(n-3,qb);
        int res = k + l + m;
        
        qb[n] = res;
        
        return res;
    }

}
