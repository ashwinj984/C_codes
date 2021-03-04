class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(n > 0){
            fast = fast.next;
            n--;
        }
        
        if(fast == null){
            head = head.next;
            return head;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
        
    }
}
