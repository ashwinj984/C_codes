//https://www.hackerearth.com/problem/algorithm/string-equalizer-d4a539ba/?source=list_view


import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scn = new Scanner(System.in);

        int len = scn.nextInt();
        String s1 = scn.next();
        String s2 = scn.next();
        int count = 0;
        int i = 0;
        for(i = 0; i < len; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i + 1) != s1.charAt(i) && s2.charAt(i + 1) != s1.charAt(i + 1)){
                    count++;
                    i++;
                }else{
                    count++;
                }
            }
        }
        
        System.out.println(count);

    }
}
