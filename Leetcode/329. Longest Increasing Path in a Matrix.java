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
