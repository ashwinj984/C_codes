// Djikstra Algorithm 
// Time Limit Exceeded

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,List<int[]>> map=new HashMap<>();
    
    for(int[] f:flights)
    {
        map.putIfAbsent(f[0],new ArrayList<>());
        map.get(f[0]).add(new int[]{f[1],f[2]});
    }
    
    PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
    q.offer(new int[]{src,0 ,K});
    
    while(!q.isEmpty())
    {
        int[] c=q.poll();
        int curr=c[0];
        int cost=c[1];
        int stop=c[2];
        if(curr==dst)
            return cost;
        if(stop>=0)
        {   
            if(!map.containsKey(curr))
                continue;
            for(int[] next:map.get(curr))
            {
                q.add(new int[]{next[0], cost+next[1], stop-1});
            }
        }
    }
    return -1;
}
    
}
// Bellman Ford
class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       int[][] distances = new int[2][n];
        for (int[] distance: distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        distances[0][src] = distances[1][src] = 0;
        int i;
        boolean hasChanged = false;
        for (i = 0; i <= k; i++) {
            hasChanged = false;
            for (int[] flight: flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                if (distances[(i + 1) % 2][from] == Integer.MAX_VALUE) continue;
                if (distances[(i + 1) % 2][from] + cost < distances[i % 2][to]) {
                    distances[i % 2][to] = distances[(i + 1) % 2][from] + cost;
                    hasChanged = true;
                }
            }
            if (!hasChanged) break;
        }
        i = hasChanged ? i - 1 : i;
        return distances[i % 2][dst] == Integer.MAX_VALUE ? -1 : distances[i % 2][dst];
    }
}
