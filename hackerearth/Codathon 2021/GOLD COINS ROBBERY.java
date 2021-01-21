//Right Answer but TLE
import java.util.*;
class TestClass {
     public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i  = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int sgold = 0;
        int tgold = 0;
        int count = 0;
        int j = -1;
        for(int i = 0; i < arr.length; i++){
            int m = 0;
            if((j + 1 < arr.length && arr[j + 1] != 0) || (j - 1  >= 0 && arr[j - 1] != 0)){
                if(j + 1 < arr.length && arr[j + 1] != 0 && m < arr[j + 1]){
                        m = arr[j + 1];
                }

                if(j - 1  >= 0 && arr[j - 1] != 0 && m < arr[j - 1]){
                        m = arr[j - 1];
                }
            }else{
                 m = max(arr);
            }
            j = findIndex(arr,m);
            arr[j] = 0;
            if(count % 2 == 0){
                sgold += m;
            }else{
                tgold += m;
            }
            count++;
        }
        System.out.print(sgold + " " + tgold);
    }

    public static int findIndex(int[] arr,int m){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == m){
                return i;
            }
        }
        return 0;
    }
    
    public static int max(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;

    }

}
//
