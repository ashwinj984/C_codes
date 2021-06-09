class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                } else if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}


class Solution {
    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        int w  = matrix[0].length;
        int max = 0;
        int[][] t = new int[h][w];
        for(int r = 0; r < h; r++){
            for(int c = 0; c < w; c++){
                if(matrix[r][c] == '1'){
                    t[r][c] = 1;
                    if(r > 0 && c > 0){
                        t[r][c] += Math.min(Math.min(t[r - 1][c], t[r][c - 1]), t[r-1][c-1]);
                    }
                    max = Math.max(max, t[r][c]);
                }
            }
        }
        return max*max;
    }
}
