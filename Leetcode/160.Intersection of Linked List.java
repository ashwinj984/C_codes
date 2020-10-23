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
