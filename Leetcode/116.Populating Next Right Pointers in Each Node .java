// First Try

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        Queue<Node> cq = new ArrayDeque<>();
        while(mq.size() > 0){
            Node k = mq.remove();
            if(k.left != null){
                cq.add(k.left);
            }
            
            if(k.right != null){
                cq.add(k.right);
            }
            
            if(mq.size() == 0){
                k.next = null;
                mq = cq;
                cq = new ArrayDeque<>();
            }else{
                k.next = mq.peek();
                
                if(k.left != null){
                cq.add(k.left);
                }
            
                if(k.right != null){
                cq.add(k.right);
                }
            }
            
            
        }
        return root;
        
    }
}

//Runtime: 162 ms, faster than 5.28% of Java online submissions for Populating Next Right Pointers in Each Node.
//Memory Usage: 68.4 MB, less than 5.51% of Java online submissions for Populating Next Right Pointers in Each Node.


// Better version
        |
        |
        |
        
        
        
class Solution {
    public Node connect(Node node) {
        if(node == null){
            return node;
        }
        connecter(node);
        return node;
    }
    
    public void connecter(Node node){
        if(node == null){
            return;
        }
        connecter(node.left);
        connecter(node.right);
        connecthelper(node.left,node.right);
    }
    
    public void connecthelper(Node left,Node right){
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}




//Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
//Memory Usage: 39.1 MB, less than 82.73% of Java online submissions for Populating Next Right Pointers in Each Node.







