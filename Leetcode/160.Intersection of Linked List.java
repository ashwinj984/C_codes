public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            if(node1 == null){
                node1 = headB;
            }else{
                node1 = node1.next;
            }
            
            if(node2 == null){
                node2 = headA;
            }else{
                node2 = node2.next;
            }
        }
        return node2;
    }
}

//Best way to understand this problem is to debug it 
// You will get a pattern and just code according to that


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode one = headA;
        ListNode two = headB;
        
        int len1 = 0;
        int len2 = 0;
        
        while(one != null){
            one = one.next;
            len1++;
        }
        while(two != null){
            two = two.next;
            len2++;
        }
        
        one = headA;
        two = headB;
        int delta = Math.abs(len1 - len2);
        
        if(len1 > len2){
            for(int i = 0; i < delta; i++){
                one = one.next;
            }
        }else{
            for(int i = 0; i < delta; i++){
                two = two.next;
            }
        }
        
        while(one != two){
            one = one.next;
            two = two.next;
        }
        
        return one;
    }
}
