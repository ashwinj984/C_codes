class Solution {
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }
    
    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int a1[] = helper(root.left);
        int a2[] = helper(root.right);
        int ans[] = new int[2];
        ans[0] = Math.max(a1[0], a1[1]) + Math.max(a2[0], a2[1]);
        ans[1] = a1[0]+a2[0]+root.val;
        return ans;
    }
}

// bad version but easy approach

class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int leftleftGrandChild = 0;
        int leftrightGrandChild = 0;
        
        int rightleftGrandChild = 0;
        int rightrightGrandChild = 0;
        
        if(root.left != null){
         leftleftGrandChild = rob(root.left.left);
         leftrightGrandChild = rob(root.left.right);
        }
        if(root.right != null){
         rightleftGrandChild = rob(root.right.left);
         rightrightGrandChild = rob(root.right.right);
        }
        int includingroot = root.val + leftleftGrandChild + leftrightGrandChild + rightleftGrandChild + rightrightGrandChild;
        
        int leftChild = rob(root.left);
        int rightChild = rob(root.right);
    
        int excludingright = leftChild + rightChild;
    
        return Math.max(includingroot,excludingright);
    }
}
