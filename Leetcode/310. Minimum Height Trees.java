// Approach 1
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<Integer>());
        }
        
        for (int[] pair : edges) {
            indegree[pair[0]]++;
            indegree[pair[1]]++;
            
            List<Integer> l0 = map.get(pair[0]);
            l0.add(pair[1]);
            
            List<Integer> l1 = map.get(pair[1]);
            l1.add(pair[0]);
        }
        
        List<Integer> queue = new ArrayList<Integer>();
        
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 1)
                queue.add(i);
        }
        
        while (queue.size() > 0) {
            
            res.clear();
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                
                int point = queue.remove(0);
                
                res.add(point);
                
                List<Integer> list = map.get(point);
                
                for (int p : list) {
                
                    if (indegree[p] > 1) {
                        indegree[p]--;

                        if (indegree[p] == 1)
                            queue.add(p);
                    }
                }
            }
        }
        return res;
    }
}
// Approach 2
// better
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=2){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            if(n == 2){
                list.add(1);
            }
            return list;
        }
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        int[] degree = new int[n];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                q.add(i);
            }
        }
        
        while(n > 2){
            int size = q.size();
            n-=size;
            while(size > 0){
                int val = q.remove();
                for(int j : graph[val]){
                    if(degree[j] > 1){
                        degree[j]--;
                        if(degree[j] == 1){
                            q.add(j);
                        }
                    }
                }
                size--; 
            }
        }
        return new ArrayList<Integer>(q);
        
    }
}
