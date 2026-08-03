# Delete Node Without Linked List Head

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a node  **x** in a singly linked list, delete this node without access to the head of the linked list. The driver code will print the updated linked list to verify the deletion.

 **Note:**  It is guaranteed that x is not the last node of the linked list.

 **Examples:** 

```
Input: x = 1

Output: 2
Explanation: After deleting 1 from the linked list, only 2 remains.

```

```
Input: x = 20

Output: 10 -> 4 -> 30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-03T06:16:14.542Z  

```java
/* Structure of Linked List Node
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    public void deleteNode(Node x) {
        // code here
        if(x.next != null){
            x.data = x.next.data;
            x.next = x.next.next;
        }
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)