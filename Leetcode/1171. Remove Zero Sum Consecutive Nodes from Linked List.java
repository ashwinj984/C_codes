class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1500);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        ListNode checkNode = null;
        
        while (current != null) {
            
            checkNode = current;
            ListNode node = checkifSumSub(checkNode);
            if (node != null){
                pre.next = node.next;
                current = node.next;
                continue;
            }
            pre = current;
            current = current.next;
        }
        return dummy.next;
    }
    
    private ListNode checkifSumSub(ListNode start) {
        int initSum = 0;
        while (start != null) {
            initSum += start.val;
            if (initSum == 0) {
                return start;
            }
            start = start.next;
        }
        return start;
    }
}
