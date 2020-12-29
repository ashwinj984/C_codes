class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(q == null && p != null){
            return false;
        }else if(q != null && p == null){
            return false;
        }else if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }

}
