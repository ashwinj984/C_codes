// https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1#

class Tree
{
    public int count = 0;
    int countSubtreesWithSumX(Node root, int X)
    {
	    int sum = 0;
	    int ans = helper(root, sum, X);
	    return count;
    }
    
    public int helper(Node node, int sum, int x){
        if(node == null){
            return 0;
        }
        
        sum = helper(node.left, sum, x) + helper(node.right, sum, x) + node.data;
        if(sum == x){
            count++;
        }
        return sum;
    }
    
    
}

