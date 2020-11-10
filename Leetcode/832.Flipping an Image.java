class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] b = new int[A.length][A[0].length];
        int n = A[0].length - 1;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                b[i][j] = A[i][n - j];
            }
        }
        
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[0].length;j++){
                if(b[i][j] == 0){
                    b[i][j] = 1;
                }else{
                    b[i][j] = 0;
                }
            }
        }
        return b;
    }
}


//100% faster
        |
        |
        |
            
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int n = A[0].length - 1;
        for(int i  = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length;j++){
                int temp = A[i][j];
                 A[i][j] = A[i][n - j];
                A[i][n - j] = temp;
                if(j >= n/2){
                    break;
                }
            }
        }
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j <= n; j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
    
