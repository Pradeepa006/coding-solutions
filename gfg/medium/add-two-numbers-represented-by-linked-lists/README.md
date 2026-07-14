# Add Number Linked Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the head of two singly linked lists  **head1**  and  **head2**  representing two non-negative integers. You need to return the  **head**  of the linked list representing the  **sum**  of these two numbers.

 **Note:** There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

 **Examples:** 

```
Input: 
    
Output:  1 -> 1 -> 2 -> 2
Explanation: Given numbers are 123 and 999. There sum is 1122.
    

```

```
Input: 
    
Output: 7 -> 0 
Explanation: Given numbers are 63 and 7. There sum is 70.
    
```

 **Constraints:** 
1 ≤ Number of nodes in head1, head2 ≤ 105
0 ≤ node->data ≤ 9

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T06:24:34.929Z  

```java
/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node removeLeadingZeros(Node head) {
    while (head != null && head.data == 0) {
        head = head.next;
    }

    return (head == null) ? new Node(0) : head;
    }
    public Node reverse(Node head) {
        Node curr = head ;
        Node prev = null;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node head = new Node(-1);
        int carry = 0 ;
        Node curr = head;
        
        while(head1 != null || head2 != null || carry != 0){
            int a = (head1 != null) ? head1.data : 0;
            int b = (head2 != null) ? head2.data : 0;
            int sum = a + b + carry;
            carry = sum /10;
            curr.next = new Node(sum % 10);
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

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1)