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

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root;
        while(curr != null || st.size() > 0){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                curr = st.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        
        return ans;
        
    }
}
