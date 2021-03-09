// Takes 9 ms

class Solution {
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return sum;
    }
    
    public void helper(TreeNode root, String res){
        res += root.val;
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(res);
            return;
        }
        
        if(root.left != null){
            helper(root.left, res);
        }
        
        if(root.right != null){
            helper(root.right, res);
        }
    }
}
