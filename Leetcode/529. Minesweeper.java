// DFS Approach
class Solution {
    int m,n;
    int[][] directions = {
        {-1,-1},
        {-1,0},
        {-1,1},
        {0,-1},
        {0,1},
        {1,-1},
        {1,0},
        {1,1}
    };
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }
    
    public void dfs(char[][] board, int r, int c){
        if(outOfBound(r,c)){
            return;
        }
        if(board[r][c] == 'M'){
            board[r][c] = 'X';
            return;
        }
        if(board[r][c] == 'E'){
            int count = checkAdjacentMines(board,r,c);
        if(count > 0){
            board[r][c] = (char)('0' + count);
            return ;
        }
        
        board[r][c] = 'B';
        for(int[] d : directions){
            dfs(board, r + d[0], c + d[1]);
        }
        }
        
    }
    
    public boolean outOfBound(int r, int c){
        return r < 0 || r >= m ||  c < 0 ||  c >= n;
    }
    
    
    public int checkAdjacentMines(char[][] board, int r, int c){
        int count = 0;
        for(int[] d : directions){
            if(!outOfBound(r + d[0], c + d[1]) && board[r + d[0]][c + d[1]] == 'M'){
                count++;
            }
        }
        return count;
    }
}
// BFS Appraoch....
