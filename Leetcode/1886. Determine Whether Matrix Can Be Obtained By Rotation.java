class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i < 4; i++){
            transpose(mat);
            reverse(mat);
            if(check(mat, target)){
                return true;
            }
        }
        return false;
    }
    
    public boolean check(int[][] a, int[][] b){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat[0].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    
    public void reverse(int[][] mat){
        for(int i = 0; i < mat[0].length / 2; i++){
            for(int j = 0; j < mat.length; j++){
                int temp = mat[j][i];
                mat[j][i] = mat[j][mat.length - i - 1];
                mat[j][mat.length - i - 1] = temp;
            }
        }
    }
}
