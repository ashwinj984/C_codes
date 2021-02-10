// Recursive Order

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    
    public void helper(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }
        
        helper(node.left,ans);
        
        ans.add(node.val);
        
        helper(node.right,ans);
    }
}

// Iterative order

