// BFS Appraoach
class Solution {
    int[][] directions = {
        {0,-1},
        {0,1},
        {-1,0},
        {1,0}
   };
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int level = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    ans[i][j] = level;
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                int[] rem = q.poll();
                for(int[] d : directions){
                    int x = rem[0] + d[0];
                    int y = rem[1] + d[1];
                    if(!outOfBound(mat, x, y) && !visited[x][y]){
                        mat[x][y] = 0;
                        visited[x][y] = true;
                        ans[x][y] = level;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return ans;
    
    }
    public boolean outOfBound(int[][] mat, int r, int c){
        return r < 0 ||  r >= mat.length || c < 0 || c >= mat[0].length;
    }
}
// DP Approach
// Two pass approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        for (int i=0; i<m; i++)
            Arrays.fill(dist[i], m*n + 1);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                }else{
                    if(i > 0){
                        dist[i][j] = Math.min(dist[i][j],1 +  dist[i - 1][j]);
                    }
                    
                    if(j > 0){
                        dist[i][j] = Math.min(dist[i][j],1 +  dist[i][j - 1]);
                    }
                }
            }
        }
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                }else{
                    if(i < m - 1){
                        dist[i][j] = Math.min(dist[i][j], 1 + dist[i + 1][j]);
                    }
                    
                    if(j < n - 1){
                        dist[i][j] = Math.min(dist[i][j], 1 + dist[i][j + 1]);
                    }
                }
            }
        }
        return dist;
    }
}
// Why two pass because 
// 1st pass top to bottom so that we get a minimum value according to above present zeros
// 2nd pass bottom to top approach so that we get again a minimum values according to below present zeros.

// So min of both will be the ans
