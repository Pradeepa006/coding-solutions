/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        int carry = 1;
        Node curr = head;
        while(carry != 0){
            int v = curr.data;
            if(v + carry > 9){
                curr.data = 0;
                carry = 1;
            }
            else {
                curr.data = v + carry;
                carry--;
            }
            if(carry == 1 && curr.next == null) {
                curr.next = new Node(1);
                carry = 0;
            }
            curr = curr.next;
        }
        return reverse(head);
    }
}