# Add 1 to a Linked List Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given head of a linked list where each node contains a single digit. The digits together represent a number formed by concatenating the node values in order. Add 1 to this number and return the head of the modified linked list.

 **Examples :** 

```
Input: Head: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

```

```
Input: Head: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
```

```
Input: Head: 0->0->1
Output: 002
```

 **Constraints:** 
1 ≤ len(list) ≤ 10
0 ≤ list[i] ≤ 9

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T08:26:13.591Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1)