class Intersect
{
    
	int intersectPoint(Node head1, Node head2)
	{
         int len1 = length(head1);
         int len2 = length(head2);
         Node ptr1 = head1;
         Node ptr2 = head2;
         int diff = Math.abs(len1 - len2);
         if(len1 > len2){
             while(diff-->0){
                 ptr1 = ptr1.next;
             }
         }else if(len1 < len2){
             while(diff-->0){
                 ptr2 = ptr2.next;
             }
         }
         while(ptr1 != ptr2){
             ptr1 = ptr1.next;
             ptr2 = ptr2.next;
         }
         return ptr1.data;
         
	}
	
	int length(Node node){
	    int len1 = 0;
	    Node ptr1 = node;
	    while(ptr1 != null){
             len1++;
             ptr1 = ptr1.next;
         }
         return len1;
	}
}
