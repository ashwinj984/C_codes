class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;
        if(len <= 1) {
        	return 0;
        }
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
        	if(map.containsKey(arr[i])) {
        		map.get(arr[i]).add(i);
        	}else {
        		map.put(arr[i], new ArrayList<>());
        		map.get(arr[i]).add(i);
        	}
        }
        int jump = 0;
        int[] visited = new int[len];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = 1;
        while(!q.isEmpty()) {
        	
        	int n = q.size();
        	for(int i = 0; i < n; i++) {
        		
        		int index = q.poll();
        		
        		if(index == arr.length - 1) {
        			return jump;
        		}
        		
        		if(index - 1 >= 0 && index - 1 < arr.length && visited[index - 1] == 0) {
        			q.add(index - 1);
        			visited[index - 1] = 1;
        		}
        		
        		if(index + 1 >= 0 && index + 1 < arr.length && visited[index + 1] == 0) {
        			q.add(index + 1);
        			visited[index + 1] = 1;
        		}
        		
        		
        		if(map.containsKey(arr[index])) {
        			for(int num : map.get(arr[index])) {
        				q.add(num);
        				visited[num] = 1;
        			}
        			map.remove(arr[index]);
        		}
        	}
        	jump++;
    
        }
        return jump;
    }
}
