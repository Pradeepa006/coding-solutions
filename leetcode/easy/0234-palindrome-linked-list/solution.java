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
    public boolean isPalindrome(ListNode head){
        // code here
        if(head == null || head.next == null)
            return true;
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        while(prev != null ){
            if(prev.val != head.val)
                return false;
                
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}