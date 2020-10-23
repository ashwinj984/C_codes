class MyLinkedList {
    int length;
    Node head;
    Node tail;
    class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
        }
    }
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.length) {
            return -1;
        }
        Node dummy = head;
        for(int i = 0; i < index ; i++){
            dummy = dummy.next;
        }
        return dummy.val;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        if(tail == null){
            tail = head;
        }
        this.length++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.length == 0){
            addAtHead(val);
            return;
        }
        Node dummy = head;
        while(dummy.next != null){
            dummy = dummy.next;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.length){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == this.length){
            addAtTail(val);
            return;
        }
        Node dummy = head;
        for(int i = 0 ; i  < index - 1; i++){
            dummy = dummy.next;
        }
        Node node = new Node(val);
        node.next = dummy.next;
        dummy.next = node;
        this.length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length){
            return;
        }
        Node curr = head;
        if(index == 0){

            head = curr.next;
            this.length--;
            return;
        }
        Node dummy = head;
       for(int i = 0; i < index - 1; i++){
           dummy = dummy.next;
       }
        
        dummy.next = dummy.next.next;
        if(dummy.next == null){
            tail = dummy;
        }
        this.length--;   
        
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
