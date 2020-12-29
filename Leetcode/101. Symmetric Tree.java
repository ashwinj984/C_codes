class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
         boolean ans = isMirror(root.left,root.right);
        return ans;
    }
    
    public boolean isMirror(TreeNode tree1,TreeNode tree2){
        if(tree1 == null &&  tree2 == null){
            return true;
        }else if(tree1 == null &&  tree2 != null){
            return false;
        }else if(tree1 != null &&  tree2 == null){
            return false;
        }
        
        if(tree1.val != tree2.val){
            return false;
        }
        
        return isMirror(tree1.left,tree2.right) && isMirror(tree1.right,tree2.left);
    }
}
