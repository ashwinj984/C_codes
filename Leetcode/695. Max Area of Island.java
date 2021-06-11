class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        helper(grid);
        return max;
    }
    
    public void helper(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                   int val =  dfs(grid, i, j, visited);
                }
            }
        }
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        
        visited[i][j] = true;
        
        int count = 1;
        count+= dfs(grid, i + 1, j, visited);
        count+= dfs(grid, i - 1, j, visited);
        count+= dfs(grid, i,j - 1, visited);
        count+= dfs(grid, i,j + 1, visited);
        
        if(count > max){
            max = count;
        }
        return count;
        
    }
}
