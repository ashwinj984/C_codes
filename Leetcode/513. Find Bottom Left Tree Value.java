// BFS Approach
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        Integer ans = null;
        q.addLast(root);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode rem = q.removeFirst();
                if(i == 0){
                    ans = rem.val;
                }
                
                if(rem.left != null) q.addLast(rem.left);
                if(rem.right != null) q.addLast(rem.right);
            }
        }

        return ans;
    }
}
// DFS Approach
class Solution {
    private int deepMax = 0;
    private int leftmostValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return leftmostValue;
    }
    
    public void dfs(TreeNode node, int deep) {
        if(node.left != null) {
            dfs(node.left, deep + 1);
        }
        if(node.right != null) {
            dfs(node.right, deep + 1);
        }
        if(node.left == null && node.right == null) {
            if(deep > deepMax) {
                deepMax = deep;
                leftmostValue = node.val;
            }
        }
    }
}
