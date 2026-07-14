/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        if(head == null || head.next == null)
            return true;
        Node slow = head ;
        Node fast = head ;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        while(prev != null ){
            if(prev.data != head.data)
                return false;
                
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}