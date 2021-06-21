class Solution {
    int m;
    int n;
    int count = 0;
    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && board[i][j] == 'X'){
                    count++;
                    helper(i, j, board, visited);
                }
            }
        }
        return count;
    }
    public void helper(int i, int j, char[][] board, boolean[][] visited){
        if(outOfBound(i, j, board) || visited[i][j] == true || board[i][j] == '.'){
            return;
        }
        visited[i][j] = true;
        helper(i + 1, j, board, visited);
        helper(i - 1, j, board, visited);
        helper(i, j + 1, board, visited);
        helper(i, j - 1, board, visited);
        
    }
    
    public boolean outOfBound(int i, int j, char[][] arr){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return true;
        }
        return false;
    }
}
