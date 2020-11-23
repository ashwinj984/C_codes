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
