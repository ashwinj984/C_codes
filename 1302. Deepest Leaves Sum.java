// Depth First Search
class Solution {
    int max = 0;
    int s = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return s;
    }
    
    public void helper(TreeNode root, int depth){
        if(root != null){
            if(depth > max){
                s = root.val;
                max = depth;
            }else if(depth == max){
                s += root.val;
            }
            
            helper(root.left, depth + 1);
            helper(root.right, depth + 1);
        }
    }
}

// Breadth First Search

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int sum = 0;
        while(q.size() > 0){
            sum = 0;
            int size = q.size();
            while(size -- > 0){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return sum;
    }
}
