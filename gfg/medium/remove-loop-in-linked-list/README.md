# Remove loop in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the **head** of a singly linked list, the task is to  **remove a cycle**  if present. A cycle exists when a node's next pointer points back to a previous node, forming a loop.

- Internally, a variable pos is used to denotes the position of the node where the cycle starts, but it is not passed as a parameter.
- The linked list remains as it is if there is cycle in the list.
- The output will be "true" if your code works according to expectations, otherwise "false". 

 **Examples:** 

```
Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.

```

```
Input: head = 1 -> 8 -> 3 -> 4, pos = 0
Output: true
Explanation: 

The Linked list does not contains any loop. 
```

```
Input: head = 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: The linked list looks like 

A loop is present in the list, and it is removed.
```

 **Constraints:** 
1 ≤ size of linked list ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-14T04:27:27.824Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)