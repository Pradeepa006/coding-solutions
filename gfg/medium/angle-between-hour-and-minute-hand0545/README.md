# Hour and Minute Hands Angle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string s representing time in 24-hour format "HH:MM", compute the smallest angle in degrees between the hour and minute hands of an analog clock.

 

 **Examples:** 

```
Input: s = "06:00"
Output: 180.000
Explanation: When the time is 06:00, the angle between the hour and minute hands of the clock is 180.000 degrees.
```

```
Input: s = "03:15"
Output: 7.500
Explanation: When the time is 03:15, the angle between the hour and minute hands of the clock is 7.500 degrees.
```

**Constraints:
**s.size() = 5
00 ≤  HH  ≤ 23
00 ≤  MM  ≤ 59

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:44:28.981Z  

```java
class Solution {
    public double getAngle(String s) {
        int hr = 0 ;
        int min = 0 ;
        if(s.charAt(0) == '0'){
            hr += s.charAt(1) - '0';
        }
        else {
            hr += s.charAt(0) - '0';
            hr *= 10;
            hr += s.charAt(1) - '0' ;
        }
        if(hr > 12)
            hr = hr -12;
        if(s.charAt(3) == '0') {
            min += s.charAt(4) - '0';
        } else {
            min += s.charAt(3) - '0';
            min *= 10;
            min += s.charAt(4) - '0';
        }
        
        double res = Math.abs( 30.0 * hr - 5.5 * min );
        if(res <= 180)
            return res;
        else 
            return 360.0 - res;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/angle-between-hour-and-minute-hand0545/1)