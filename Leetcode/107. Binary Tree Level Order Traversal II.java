/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> cq = new ArrayDeque<>();
        List<Integer> k = new ArrayList<>();
        mq.add(root);
        while(mq.size() > 0){
            TreeNode node = mq.remove();
            k.add(node.val);
            if(node.left != null){
                cq.add(node.left);
            }
            if(node.right != null){
                cq.add(node.right);
            }
            
            if(mq.size() == 0){
                ans.add(k);
                k = new ArrayList<>();
                mq = cq;
                cq = new ArrayDeque<>();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = ans.size() - 1; i >= 0; i--){
            List<Integer> km = ans.get(i);
            res.add(km);
        }
        return res;
    }
}
