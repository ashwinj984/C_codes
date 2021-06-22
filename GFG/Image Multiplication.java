// https://practice.geeksforgeeks.org/problems/image-multiplication0627/1#
class Solution {
     long ans = 0;
     long mod = (int) 1e9 + 7;
    public long imgMultiply(Node root)
    {
        if(root == null){
            return 0L;
        }
        
        helper(root.left, root.right);
        long res = root.data * root.data;
        return (res + ans) % mod;
    }
    
    public void helper(Node rootL, Node rootR){
        if(rootL == null | rootR == null){
            return;
        }
        if(rootL!=null && rootR != null){
            ans += rootL.data * rootR.data;
        }
        
        helper(rootL.left, rootR.right);
        helper(rootL.right, rootR.left);
    }
}
