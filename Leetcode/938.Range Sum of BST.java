class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        int some = helper(root,low,high);
        if(root.val >= low && root.val <= high){
            return sum + root.val;
        }
        return sum;
        
    }
    
    int sum = 0;
    
    public int helper(TreeNode node,int low,int high){
        if(node == null){
            return 0;
        }
        
        int l = helper(node.left,low,high);
        if(l >= low &&  l <= high){
            sum += l;
        }
        int r = helper(node.right,low,high);
         if(r >= low &&  r <= high){
            sum += r;
        }
        
        return node.val;
        
    }
}


//Optimised version
//Best in terms of Speed

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    
    }
}
