class Solution {
    public void solve(char[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || i == m || j == 0 || j == n){
                    if(board[i][j] == 'O'){
                        dfs(board, i, j);
                    }
                }
            }
        }
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j] == 'F'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'F' || board[i][j] == 'X'){
            return;
        }
        
        board[i][j] = 'F';
        
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
