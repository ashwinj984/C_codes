//https://www.hackerearth.com/challenges/college/codathon2021-NITB/algorithm/question-1-241/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class TestClass {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());//t --> number of test cases
        while(t--> 0){
            int n = Integer.parseInt(br.readLine());//n --> number of hints
            if(n == 0) {
            	System.out.println(-1);
                return;
            }
            if(n == 1){
                
                 
                    System.out.println(-1);
                    return;
                
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
            	String hint = br.readLine();
            	String[] parts = hint.split(" ");
            	if(parts[0].equals("L")) {
            		if(Integer.valueOf(parts[1]) < min) {
            			min = Integer.valueOf(parts[1]);
            		}
            	}else if(parts[0].equals("R")) {
            		if(Integer.valueOf(parts[1]) > max) {
            			max = Integer.valueOf(parts[1]);
            		}
            	}
            }
            if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            	System.out.println(-1);
            	continue;
            }
            else if(min < max) {
            	System.out.println(-1);
            	continue;
            }
            else if(Math.abs(min - max) == 1) {
            	System.out.println(-1);
            	continue;
            }else if(min > max){
                System.out.println(min - max - 1);
                continue;
            }

            //System.out.println(-1);
        }
		

	}

}
