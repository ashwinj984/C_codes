class Solution{
    
    // modify the BST and return its root
    public Node modify(Node root)
    {
        helper(root);
        return root;
    }
    int sum = 0;
    public void helper(Node root){
        if(root == null){
            return;
        }
        
        helper(root.right);
        sum += root.data;
        root.data = sum;
        helper(root.left);
        
    }
    
}
