// Takes 25ms
// But atleast I solved it

class Solution {
    public class Pair{
        int i;
        int j;
        int d;
        Pair(int i,int j,int d){
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1){
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,1));
        
        while(q.size() > 0){
            Pair rem = q.removeFirst();
            int i = rem.i;
            int j = rem.j;
            if(i == grid.length - 1 && j == grid[0].length - 1){
            
            	return rem.d;
                
            }
            if(visited[rem.i][rem.j]){
                continue;
            }
            
            visited[i][j] = true;
            
            boolean one = isZero(i - 1, j - 1, visited, grid);
            if(one){
                q.add(new Pair(i - 1, j - 1, rem.d + 1));
            }
            boolean two = isZero(i    , j - 1, visited, grid);
            if(two){
                q.add(new Pair(i, j - 1, rem.d + 1));
            }
            boolean three = isZero(i + 1, j - 1, visited, grid);
            if(three){
                q.add(new Pair(i + 1, j - 1, rem.d + 1));
            }
            boolean four = isZero(i - 1, j,     visited, grid);
            if(four){
                q.add(new Pair(i - 1, j, rem.d + 1));
            }
            boolean five = isZero(i + 1, j,     visited, grid);
            if(five){
                q.add(new Pair(i + 1, j, rem.d + 1));
            }
            boolean six = isZero(i + 1, j + 1, visited, grid);
            if(six){
                q.add(new Pair(i + 1, j + 1, rem.d + 1));
            }
            boolean seven = isZero(i    , j + 1,     visited, grid);
            if(seven){
                q.add(new Pair(i, j + 1, rem.d + 1));
            }
            boolean eight = isZero(i - 1, j + 1, visited, grid);
            if(eight){
                q.add(new Pair(i - 1, j + 1, rem.d + 1));
            }
            
            
        }
        return -1;
    }
    public boolean isZero(int i,int j,boolean[][] visited, int[][] grid){
	        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || 
	                           visited[i][j] == true || grid[i][j] != 0){
	            return false;
	        }
	        
	        return true;
	    }
}
