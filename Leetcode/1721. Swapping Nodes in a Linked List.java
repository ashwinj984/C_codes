class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode last = null;
        ListNode node = head;
        int len = length(node);
        
        int n1 = Math.min(k, len - k + 1);
        int n2 = Math.max(k, len - k + 1);
        
        if(n1 == n2){
            return head;
        }
        node = head;
        for(int i = 1; i <= n2; i++, node = node.next){
            if(i == n1){
                first = node;
            }else if(i == n2){
                last = node;
            }
            
            //node = node.next;
        }
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        
        return head;
    }
    
    public int length(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
