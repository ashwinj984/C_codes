class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        int res = 0;
        while(l1 != null || l2 != null){
            res = carry;
            if(l1 != null){
                res += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){
                res += l2.val;
                l2 = l2.next;
            }
            carry = res / 10;
            dummy.next = new ListNode(res % 10);
            dummy = dummy.next;
        }
        if(carry != 0){
            dummy.next = new ListNode(1);
        }
    return prev.next;
    }
}
