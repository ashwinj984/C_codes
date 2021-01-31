//https://leetcode.com/contest/weekly-contest-226/problems/restore-the-array-from-adjacent-pairs/
class Solution {
    public void dfs(HashMap<Integer,ArrayList<Integer>> map,HashSet<Integer> set, int head, ArrayList<Integer> ans){
            if(set.contains(head)){
            return;
        }
        
        ans.add(head);
        set.add(head);
       
            ArrayList<Integer> arr = map.get(head);
            for(int y : arr) {
            	dfs(map,set,y,ans);
            }
        
    }

    public int[] restoreArray(int[][] a) {
        
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < a.length; i++){
        	 if(map.containsKey(a[i][0])){
                 ArrayList<Integer> in = map.get(a[i][0]);
                 in.add(a[i][1]);
                 map.put(a[i][0],in);
             }else if(!map.containsKey(a[i][0])){
                 ArrayList<Integer> in = new ArrayList<>();
                 in.add(a[i][1]);
                 map.put(a[i][0],in);
             }
             if(map.containsKey(a[i][1])){
                 ArrayList<Integer> in = map.get(a[i][1]);
                 in.add(a[i][0]);
                 map.put(a[i][1],in);
             }else if(!map.containsKey(a[i][1])){
                ArrayList<Integer> in = new ArrayList<>();
                in.add(a[i][0]);
                map.put(a[i][1],in);
            }
           
        }
        //System.out.println(map);
        
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int head = 0;
        for(int x : map.keySet()){
            if(map.get(x).size() == 1){
                head = x;
                break;
            }
        }
        //ans.add(head);
        dfs(map,set,head,ans);
        //ans.remove(0);
        int[] ansa = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            ansa[i] = ans.get(i);
        }
        return ansa;

    }
}
