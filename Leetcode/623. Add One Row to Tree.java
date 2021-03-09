class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            return new TreeNode(v,root,null);
            
        }
        
            TreeNode curr = root;
            dfs(curr, v, d, 1);
            return root;
    }
    public void dfs(TreeNode curr, int v, int d, int level){
        if(curr != null){
            if(level == d - 1){
                curr.left = new TreeNode(v, curr.left, null);
                curr.right = new TreeNode(v, null, curr.right);
            }else{
                dfs(curr.left, v, d, level + 1);
                dfs(curr.right, v, d, level + 1);
            }
        }
    }
}
