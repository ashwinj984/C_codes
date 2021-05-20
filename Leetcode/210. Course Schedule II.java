// My Approach
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(i, new ArrayList<>());
        }
        Stack<Integer> st = new Stack<>();
        for(int[] val : prerequisites){
            int u = val[0];
            int v = val[1];
            graph.get(v).add(u);
        }
        System.out.println(graph);
        int[] checkCycle = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
        	if(isCycle(i,graph,checkCycle)) {
        		return new int[0];
        	}
        }
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == false){
                dfs(i, graph, visited, st);    
            }
            
        }
        for(int i = 0; i < numCourses; i++){
            ans[i] = st.pop();
        }
        return ans;
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st){
     
        visited[i] = true;
        for(int val : graph.get(i)){
            if(visited[val] == false){
                dfs(val, graph, visited, st);
            }
        }
        st.push(i);
    }
    
    public static boolean isCycle(int i, ArrayList<ArrayList<Integer>> graph, int[] checkCycle) {
    	if(checkCycle[i] == 2) {
    		return false;
    	}
    	
    	checkCycle[i] = 1;
    	for(var val : graph.get(i)) {
    		if(checkCycle[val] == 1) {
    			return true;
    		}else if(checkCycle[val] == 0) {
    			if(isCycle(val,graph,checkCycle)) {
    				return true;
    			}
    		}
    	}
    	checkCycle[i] = 2;
    	return false;
    }
}
// better approach 
import java.util.*;
class Solution {
    int result[];
    Stack<Integer>stack=new Stack<>();
    public boolean dfs(ArrayList<ArrayList<Integer>> graph,int v,int visited[]){
        if(visited[v]==2) return false;
        visited[v]=1;
        Iterator<Integer> itr=graph.get(v).iterator();
        while(itr.hasNext())
        {
            int u=itr.next();
            if(visited[u]==1)
                return true;
            if(visited[u]==0)
            {
                if(dfs(graph,u,visited))
                    return true;
            }
        }
        visited[v]=2;
        stack.push(v);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int prerequisite[]:prerequisites)
        {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        result=new int[numCourses];
        int visited[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            boolean isCyclic=dfs(graph,i,visited);
            if(isCyclic) return new int[0];
        }
        for(int i=0;i<numCourses;i++)
            result[i]=stack.pop();
        return result;
    }
}
