class Solution {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return list;
        }
        helper(root, "");
        return list;
    }
    
    public void helper(TreeNode root, String res){
        res += root.val;
        if(root.left == null && root.right == null){
            list.add(res);
            return;
        }
        if(root.left != null){
            helper(root.left, res + "->");
        }
    
        if(root.right != null){
            helper(root.right, res + "->");
        }
    }
}
