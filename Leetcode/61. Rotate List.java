class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        if(k == 0){
            return head;
        }
        ListNode end = head;
        int count = 1;
        while(end.next != null){
            end = end.next;
            count++;
        }
        
        end.next = head;
        k = k % count;
        ListNode p = head;
        
        for(int i=1 ; i<count-k ; i++) p=p.next;        
        head= p.next;
        p.next=null;
        return head;
        
    }
}
