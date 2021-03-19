class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        
        dfs(rooms, visited, 0);
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                return false;
            }
        }
        
        return true;
    }
    
    public void dfs(List<List<Integer>> list, boolean[] visited, int i){
        visited[i] = true;
        
        List<Integer> currentList = list.get(i);
        
        for(int val : currentList){
            
            if(visited[val] == false){
                dfs(list, visited, val);
            }
        }
    }
}
