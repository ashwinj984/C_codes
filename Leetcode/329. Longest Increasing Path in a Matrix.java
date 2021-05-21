class Solution {
    static int[][] dir = {{1,0},{-1, 0}, {0,1},{0,-1}};
    int rows;
    int cols;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        if(rows <= 0){
            return 0;
        }
        
        int max = 0;
        
        cols = matrix[0].length;
        dp = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                max = Math.max(max, dfs(matrix,i,j));   
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int row, int col){
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        int max = 1;
        for(int[] direction : dir){
            int adjRow = row + direction[0];
            int adjCol = col + direction[1];
            
            if(adjRow < 0 || adjRow >= rows || adjCol < 0 || adjCol >= cols){
                continue;
            }
            
            if(matrix[adjRow][adjCol] <= matrix[row][col]){
                continue;
            }
            
            max = Math.max(max, dfs(matrix,adjRow,adjCol) + 1);
            
        }
        dp[row][col] = max;
        return dp[row][col];
    }
}
// Faster Approach
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int col  = matrix[0].length;
        
        int maxlen = 0;
        int[][] dp = new int[rows][col];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                maxlen = Math.max(maxlen, dfs(i,j,dp,matrix));
            }
        }
        return maxlen;
    }
    
    public int dfs(int i, int j, int[][] dp, int[][] matrix){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int max = 1;
        int currValue = matrix[i][j];
        if(i>0 && matrix[i - 1][j] > currValue){
            max = Math.max(max, 1 + dfs(i - 1, j, dp, matrix));
        }
        
        if(i<dp.length-1 && matrix[i + 1][j] > currValue){
            max = Math.max(max, 1 + dfs(i + 1, j, dp, matrix));
        }
        
        if(j > 0 && matrix[i][j - 1] > currValue){
            max = Math.max(max, 1 + dfs(i, j - 1, dp, matrix));
        }
        
        if(j  < dp[i].length - 1 && matrix[i][j + 1] > currValue){
            max = Math.max(max, 1 + dfs(i, j + 1, dp, matrix));
        }
        dp[i][j] = max;
        return dp[i][j];
    }
}
