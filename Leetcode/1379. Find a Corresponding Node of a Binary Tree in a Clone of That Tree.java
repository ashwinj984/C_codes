class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null){
            return null;
        }
        
        if(original == target){
            return cloned;
        }
        
        TreeNode Node = getTargetCopy(original.left,cloned.left,target);
        
        if(Node == null){
            return getTargetCopy(original.right,cloned.right,target);
        }else
            return Node;
    }
}
