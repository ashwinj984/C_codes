class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return sum;
        }
        if(root != null &&(root.left == null && root.right == null)){
            return sum;
        }
        helper(root);
        return sum;
    }
    
    public void helper(TreeNode root){
        if(root.left == null && root.right == null){
            sum += root.val;
            return;
        }
        
        if(root.left != null){
            helper(root.left);
        }
        if(root.right != null && !(root.right.left == null && root.right.right == null)){
            helper(root.right);
        }
    }
}
