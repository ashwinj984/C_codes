class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> cq = new ArrayDeque<>();
        mq.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(mq.size() != 0){
            TreeNode rem = mq.remove();
            if(rem.left != null){
                cq.add(rem.left);
            }
            if(rem.right != null){
                cq.add(rem.right);
            }
            list.add(rem.val);
            if(mq.size() == 0){
                ans.add(average(list));
                list = new ArrayList<>();
                mq = cq;
                cq = new ArrayDeque<>();
            }
        }
        return ans;
    }
    
    public double average(ArrayList<Integer> list){
        double avg = 0;
        long sum = 0;
        for(int i : list){
            sum += i;
        }
        
        return sum / (list.size() * (1.0));
    }
}

// Although it takes 3ms But I am cool with my code
