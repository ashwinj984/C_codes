class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        
        nhead = reverse(nhead);
        ListNode h1 = head;
        ListNode h2 = nhead;
        
        boolean res = true;
        
        while(h2 != null){
            if(h1.val != h2.val){
                res = false;
                break;
            }
            
            h1 = h1.next;
            h2 = h2.next;
            
        }
        return res;
        
    }
    
    public ListNode midNode(ListNode head){
        ListNode s = head;
        ListNode f = head;
        
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        
        return s;
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
}

// 0 ms approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode newHead = null;
        ListNode fast = head;
        
        while (fast != null) {
            if (fast.next == null) {
                head = head.next;
                break;
            } else {
                fast = fast.next.next;
            }
            
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        while (newHead != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        
        return true;
    }
}
