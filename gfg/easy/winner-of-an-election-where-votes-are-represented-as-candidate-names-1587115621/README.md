# Election Winner

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of strings arr[] representing votes cast in an election, where each string is the name of a candidate in lowercase English letters, find the candidate who received the maximum number of votes.

If multiple candidates receive the same highest number of votes, return the lexicographically smaller candidate name along with its vote count.

**Examples :
**

```
Input: arr[] = [john, johnny, jackie, johnny, john, jackie, jamie, jamie, john, johnny, jamie, johnny, john]
Output: [john, 4]
Explanation: john has 4 votes casted for him, but so does johnny. john is lexicographically smaller, so we print john and the votes he received.
```

```
Input: arr[] = [andy, blake, clark]
Output: [Andy, 1]
Explanation: All the candidates get 1 votes each. We print andy as it is lexicographically smaller.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-08T10:08:57.697Z  

```java
import java.util.*;

class Solution {
    public ArrayList<String> winner(String[] arr) {
        // code here
        HashMap<String , Integer> hs = new HashMap<>();
        for(int i = 0 ; i < arr.length ;i++) {
            String s = arr[i];
            hs.put(s , hs.getOrDefault(s,0)+1);
        }
        int max = -10;
        for(Integer value : hs.values()) {
            if(max < value) {
                max = value;
            }
        }
        String s = "" ;
        int c = 0;
        for (String key : hs.keySet()) {
            //System.out.println("Key: " + key);
            if((hs.get(key) == max && c == 0) || (hs.get(key) == max && c != 0 && key.compareTo(s) < 0)){
                s = key;
                c = 1;
            }
        }
        ArrayList<String> li = new ArrayList<>();
        li.add(s);
        li.add(Integer.toString(max));
        return li;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1)