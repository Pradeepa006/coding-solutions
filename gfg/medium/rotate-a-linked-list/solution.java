/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        // code here
        if(head == null || head .next == null || k == 0)
            return head;
        Node n = head;
        Node temp = head;
        int c = 1 ;
        while(n.next != null){
            n = n.next;
            c++;
        }
        k = k % c;
        if(k == 0)
            return head;
            
        n.next = temp;
        temp = head;
        
        while(k > 0){
            temp = temp.next;
            k--;
        }
        head = temp;
        
        while(c > 1) {
            temp = temp.next;
            c--;
        }
        temp.next = null;
        return head;
    }
}