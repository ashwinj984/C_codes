import java.util.*;
import java.io.*;
public class Solution{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0){
                int n = Integer.parseInt(br.readLine());
                int[] arr = new int[n];
                String[] parts = br.readLine().split(" ");
                boolean flag = false;
                for(int i = 0; i < n; i++){
                    arr[i] = Integer.parseInt(parts[i]);
                    if(arr[i] < 0){
                        flag = true;
                    }
                }
                int count = 0;
                boolean flag1 = checkifMeanIs1(arr);
                if(flag1){
                    System.out.println("0");
                    continue;
                }else{
//                    for(int i = 0; i < n; i++){
//                        if(arr[i] < 0){
//                            count++;
//                        }else if(arr[i] > 0){
//                            count+=arr[i] - 1;
//                        }
//                    }
                	
                	int sum = 0;
                	//flag = false;
                	for(int i = 0; i < n; i++) {
                		sum += arr[i];
                	}
                	if(sum < n) {
                		System.out.println("1");
                	}else if(sum == n) {
                		System.out.println("0");
                	}else {
                		System.out.println(sum - n);
                	}
                   
                }
                
            }
		}
	
	public static boolean checkifMeanIs1(int[] arr){
	    int sum = 0;
	    for(int i = 0; i < arr.length; i++){
	        sum += arr[i];
	    }
	    return sum * (1.0)/ arr.length == 1.0;
	}
}
