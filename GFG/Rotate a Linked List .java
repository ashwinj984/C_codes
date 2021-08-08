class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node ptr1 = head;
        Node ptr2 = head;
        while(ptr2.next != null){
            ptr2 = ptr2.next;
        }
        Node nxt = null;
        for(int i = 0; i < k; i++){
            nxt = ptr1.next;
            ptr2.next = ptr1;
            ptr1.next = null;
            ptr1 = nxt;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
