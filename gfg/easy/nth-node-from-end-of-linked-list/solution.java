/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public int getKthFromLast(Node head, int k) {
        // code here
        if(head == null )
            return -1;
        if( k <= 0)
            return -1;
        int count = 0 ;
        Node curr = head ;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        if(k > count)
            return -1;
        curr = head ;
        for(int i = 0 ; i < count - k ; i++){
            if(curr == null)
                return -1;
            curr = curr.next;
        }
        return curr.data;
    }
}