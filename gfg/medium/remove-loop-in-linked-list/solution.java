/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static boolean removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        // Node dummy = new Node(-1);
        // dummy.next = head;
        // Node prev = dummy;
        while(fast != null && fast.next != null) {
            //prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        
        if(slow != fast)
            return false;
        slow = head;
        while(slow != fast){
            //prev = prev.next;
            slow = slow.next;
            fast = fast.next;
        }
        Node start = fast;
        Node curr = start;
        while(curr.next != start){
            curr = curr.next;
        }
        curr.next = null;
        return true;
        
    }
}