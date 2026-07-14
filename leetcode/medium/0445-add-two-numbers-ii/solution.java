/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeLeadingZeros(ListNode head) {
        while (head != null && head.val == 0) {
            head = head.next;
        }
        return (head == null) ? new ListNode(0) : head;
    }
    public ListNode reverse(ListNode head) {
        ListNode curr = head ;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // code here
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        int carry = 0 ;
        ListNode curr = head;
        
        while(head1 != null || head2 != null || carry != 0){
            int a = (head1 != null) ? head1.val : 0;
            int b = (head2 != null) ? head2.val : 0;
            int sum = a + b + carry;
            carry = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(head1 != null)
                head1 = head1.next;
            if(head2 != null)
                head2 = head2.next;
        }
        return reverse(head.next);
    }
}
