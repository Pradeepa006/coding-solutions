# Kth from End of Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the head of a linked list and an integer  **k**, return the kth node from the  **end**  of the linked list. If k is greater than the number of nodes in the list, return  **-1**.

**Examples :
**

```
Input: head: 1->2->3->4->5->6->7->8->9, k = 2
Output: 8
Explanation: 

The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from end is 8.

```

```
Input: head: 10->5->100->5, k = 5
Output: -1
Explanation: 

The given linked list is 10->5->100->5. Since 'k' is more than the number of nodes, the output is -1.

```

 **Constraints:** 
1 ≤ number of nodes ≤ 106
1 ≤ node->data, x ≤ 106
1 ≤ k ≤ 106

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T04:39:25.297Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1)