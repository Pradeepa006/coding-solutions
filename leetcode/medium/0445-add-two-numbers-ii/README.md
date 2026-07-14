# Add Two Numbers II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two  **non-empty**  linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

 **Example 1:** 

```
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

```

 **Example 2:** 

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

```

 **Example 3:** 

```
Input: l1 = [0], l2 = [0]
Output: [0]

```

 

 **Constraints:** 

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

 

 **Follow up:**  Could you solve it without reversing the input lists?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 58.93%)  
**Memory:** 46.5 MB (beats 48.30%)  
**Submitted:** 2026-07-14T06:28:46.132Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/add-two-numbers-ii/)