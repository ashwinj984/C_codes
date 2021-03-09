class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        
        helper(root.left);
        helper(root.right);
    }
}
