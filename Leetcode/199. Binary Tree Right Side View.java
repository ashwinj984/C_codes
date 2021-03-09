
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //list.add(root.val);
        q.offer(root);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(i == size - 1){
                    list.add(current.val);
                }
                
                if(current.left != null){
                    q.offer(current.left);
                }
                
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
        return list;
    }
}
