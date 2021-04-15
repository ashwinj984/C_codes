class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
       
        ListNode dummy = head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode tail1 = left;
        ListNode tail2 = right;
        
        while(dummy != null){
            if(dummy.val < x){
                tail1.next = new ListNode(dummy.val);
                tail1 = tail1.next;
            }else{
                tail2.next = new ListNode(dummy.val);
                tail2 = tail2.next;
            }
            
            dummy = dummy.next;
        }
        
        tail1.next = right.next;
        
        return left.next;
    }
}
