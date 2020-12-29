class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return check(root,null,null);
    }
    
    public boolean check(TreeNode root,Integer min,Integer max){
        if(root == null){
            return true;
        }
        
        if((min != null && min >= root.val) || (max != null && root.val >= max)){
            return false;
        }
        boolean checkl = check(root.left,min, root.val);
        boolean check2 = check(root.right,root.val,max);
        
        if(checkl == true && check2 == true){
            return true;
        }
        
        return false;
    }
}
