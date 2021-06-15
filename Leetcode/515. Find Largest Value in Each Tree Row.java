// BFS Appraoch
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(q.size() > 0){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size-->0){
                TreeNode rem = q.removeFirst();
                max = Math.max(rem.val, max);
                if(rem.left != null){
                    q.addLast(rem.left);
                }
                if(rem.right != null){
                    q.addLast(rem.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
// DFS Approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList();
        helper(root, list, 0);
        return list;
    }
    
    public void helper(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        
        if (list.size() <= level) {    
            list.add(root.val);
        } else if (list.get(level) < root.val) list.set(level, root.val);
            
        
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }
}
