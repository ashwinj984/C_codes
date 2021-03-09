
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        helper(root);
    }
    TreeNode prev = null;
    public void helper(TreeNode root){
        
        if(root == null){
            return; 
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(prev != null){
            prev.right = root;
        }
        
        prev = root;
        
        root.left = null;
        root.right = null;
        
        helper(left);
        helper(right);
    }
    
}
