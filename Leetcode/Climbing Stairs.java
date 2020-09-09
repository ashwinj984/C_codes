import java.io.*;
import java.util.*;

public class Main {
    //private static int count = 0;
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int k = countpaths(t);
        System.out.println(k);
    }
    public static int countpaths(int n){
        if(n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        int k = countpaths(n-1);
        int l = countpaths(n-2);
        int m = countpaths(n-3);
        int res = k + l + m;
        
        
        return res;
    }

}
