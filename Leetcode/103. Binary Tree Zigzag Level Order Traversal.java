
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < ans.size(); i++){
            List<Integer> km = ans.get(i);
            if(i % 2 == 1){
                Collections.reverse(km);
            }
            list.add(km);
        }
        return list;
    }
}
