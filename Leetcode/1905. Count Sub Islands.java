class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && isSubIsland(grid1, grid2, i , j)){
                    result++;
                }
            }
        }
        return result;
    }
    
    public boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j){
        if(!outOfBound(i, j, grid2) && grid2[i][j] == 1){
            if(grid1[i][j] != grid2[i][j]){
                return false;
            }
            grid2[i][j] = -1;
            boolean top = isSubIsland(grid1, grid2, i - 1, j);
            boolean bottom = isSubIsland(grid1, grid2, i + 1, j);
            boolean left = isSubIsland(grid1, grid2, i, j - 1);
            boolean right = isSubIsland(grid1, grid2, i, j + 1);
            if(!top || !bottom || !left | !right){
                return false;
            }
        }
        return true;
    }
    public boolean outOfBound(int i, int j, int[][] arr){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return true;
        }
        return false;
    }
}
