//Iterative Approach

class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    
    Stack<TreeNode> st = new Stack<>();
    
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        pushAllRight(node);
        
        int sum = 0;
        while(st.size() > 0){
            TreeNode curr = st.pop();
            
            sum += curr.val;
            curr.val = sum;
            
            if(curr.left != null){
                pushAllRight(curr.left);
            }
        }
    }
    
    public void pushAllRight(TreeNode node){
        TreeNode curNode = node;
        while(curNode != null){
            st.push(curNode);
            curNode = curNode.right;
        }
    }
}

//Recursive Approch


class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root,0);
        return root;
    }
    
    public int helper(TreeNode node,int sum) {
        if(node == null)
            return sum;

        int rightSum = helper(node.right, sum);
        
        int currSum = node.val + rightSum;
        node.val = currSum;
        
        int leftSum = helper(node.left, currSum);
        
        return leftSum;
    }
}
