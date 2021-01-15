class Solution {
     boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }   
       
        int height = height(root);
        return isBalanced;
    }
    
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        if(Math.abs(lh - rh) > 1){
            isBalanced = false;
        }
        
        return Math.max(lh,rh) + 1;
    }
}
