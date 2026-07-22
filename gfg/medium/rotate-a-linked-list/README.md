# Rotate a Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the  **head**  of a singly linked list, you have to  **left rotate**  the linked list  **k**  times. Return the head of the modified linked list.

 **Examples:** 

```
Input: k = 4,
   
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
   
```

```
Input: k = 6,
   
Output: 30 -> 40 -> 10 -> 20 
   

```

**Constraints:
**1 ≤ number of nodes ≤ 105
0 ≤ k ≤ 109
0 ≤ node.data ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-22T06:00:56.288Z  

```java
/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        // code here
        if(head == null || head .next == null || k == 0)
            return head;
        Node n = head;
        Node temp = head;
        int c = 1 ;
        while(n.next != null){
            n = n.next;
            c++;
        }
        k = k % c;
        if(k == 0)
            return head;
            
        n.next = temp;
        temp = head;
        
        while(k > 0){
            temp = temp.next;
            k--;
        }
        head = temp;
        
        while(c > 1) {
            temp = temp.next;
            c--;
        }
        temp.next = null;
        return head;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1)