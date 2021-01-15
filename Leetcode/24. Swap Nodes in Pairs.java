class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode temp = head;
        while(temp != null && temp.next != null){
            swap(temp,temp.next);
            temp = temp.next.next;
        }
        return head;
    }
    
    public void swap(ListNode head,ListNode curr){
        int temp = head.val;
        head.val = curr.val;
        curr.val = temp;
    }
}
