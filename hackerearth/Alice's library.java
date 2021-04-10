//https://www.hackerearth.com/problem/algorithm/katrina-and-library-c2ed51f3/?source=list_view


import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scn = new Scanner(System.in);

        String s1 = scn.next();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == '/'){
                st.push(i);
            }else if(s1.charAt(i) == 92){
                int val = st.pop();
                s1 = reverse(s1, val + 1, i - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) >= 97 && s1.charAt(i) <= 122){
                sb.append(s1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static String reverse(String s1, int start, int end){
        char[] ch = s1.toCharArray();
        while(start <= end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ch.length; i++){
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
