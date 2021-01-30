class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,Map<Integer,List<Integer>>> report = new TreeMap<>();
        dfs(root,report,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int row : report.keySet()){
            List<Integer> list = new ArrayList<>();
            Map<Integer,List<Integer>> map = report.get(row);
            for(int col : map.keySet()){
                List<Integer> li = map.get(col);
                Collections.sort(li);
                list.addAll(li);
            }
            res.add(list);
        }
        return res;
    }
    
    public void dfs(TreeNode node,TreeMap<Integer,Map<Integer,List<Integer>>> report,int row,int col){
        if(node == null){
            return;
        }
        
        if(report.containsKey(row)){
            Map<Integer,List<Integer>> map = report.get(row);
            if(map.containsKey(col)){
                List<Integer> list = map.get(col);
                list.add(node.val);
                map.put(col,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(col,list);
            }
            report.put(row,map);
        }else{
            Map<Integer,List<Integer>> map = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(col,list);
            report.put(row,map);
        }
        
        dfs(node.left,report,row - 1,col + 1);
        dfs(node.right,report,row + 1,col + 1);
    }
}
