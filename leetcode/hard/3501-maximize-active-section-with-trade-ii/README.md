# Maximize Active Section with Trade II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a binary string `s` of length `n`, where:

- '1' represents an active section.
- '0' represents an inactive section.

You can perform  **at most one trade**  to maximize the number of active sections in `s`. In a trade, you:

- Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
- Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.

Additionally, you are given a  **2D array**  `queries`, where `queries[i] = [li, ri]` represents a substring `s[li...ri]`.

For each query, determine the  **maximum**  possible number of active sections in `s` after making the optimal trade on the substring `s[li...ri]`.

Return an array `answer`, where `answer[i]` is the result for `queries[i]`.

 **Note** 

- For each query, treat s[li...ri] as if it is augmented with a '1' at both ends, forming t = '1' + s[li...ri] + '1'. The augmented '1's do not contribute to the final count.
- The queries are independent of each other.

 

 **Example 1:** 

 **Input:**  s = "01", queries = [[0,1]]

 **Output:**  [1]

 **Explanation:** 

Because there is no block of `'1'`s surrounded by `'0'`s, no valid trade is possible. The maximum number of active sections is 1.

 **Example 2:** 

 **Input:**  s = "0100", queries = [[0,3],[0,2],[1,3],[2,3]]

 **Output:**  [4,3,1,1]

 **Explanation:** 

- Query [0, 3] → Substring "0100" → Augmented to "101001" Choose "0100", convert "0100" → "0000" → "1111". The final string without augmentation is "1111". The maximum number of active sections is 4.
- Query [0, 2] → Substring "010" → Augmented to "10101" Choose "010", convert "010" → "000" → "111". The final string without augmentation is "1110". The maximum number of active sections is 3.
- Query [1, 3] → Substring "100" → Augmented to "11001" Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 1.
- Query [2, 3] → Substring "00" → Augmented to "1001" Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 1.

 **Example 3:** 

 **Input:**  s = "1000100", queries = [[1,5],[0,6],[0,4]]

 **Output:**  [6,7,2]

 **Explanation:** 

- Query [1, 5] → Substring "00010" → Augmented to "1000101" Choose "00010", convert "00010" → "00000" → "11111". The final string without augmentation is "1111110". The maximum number of active sections is 6.
- Query [0, 6] → Substring "1000100" → Augmented to "110001001" Choose "000100", convert "000100" → "000000" → "111111". The final string without augmentation is "1111111". The maximum number of active sections is 7.
- Query [0, 4] → Substring "10001" → Augmented to "1100011" Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 2.

 **Example 4:** 

 **Input:**  s = "01010", queries = [[0,3],[1,4],[1,3]]

 **Output:**  [4,4,2]

 **Explanation:** 

- Query [0, 3] → Substring "0101" → Augmented to "101011" Choose "010", convert "010" → "000" → "111". The final string without augmentation is "11110". The maximum number of active sections is 4.
- Query [1, 4] → Substring "1010" → Augmented to "110101" Choose "010", convert "010" → "000" → "111". The final string without augmentation is "01111". The maximum number of active sections is 4.
- Query [1, 3] → Substring "101" → Augmented to "11011" Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 2.

 

 **Constraints:** 

- 1 <= n == s.length <= 105
- 1 <= queries.length <= 105
- s[i] is either '0' or '1'.
- queries[i] = [li, ri]
- 0 <= li <= ri < n

## Solution

**Language:** Java  
**Runtime:** 276 ms (beats 30.00%)  
**Memory:** 273.5 MB (beats 10.00%)  
**Submitted:** 2026-07-22T18:02:00.298Z  

```java

class SparseTable {
    int sparse[][]; 
    SparseTable(int[] nums){
        int n = nums.length; 
        sparse = new int[21][n]; 

        // Now we have to create a sparse tables with nums, where nums[i] = sum of zeroBlocks[i] + zeroBlocks[i + 1] 

        // for zero length 
        for(int i = 0; i < n; i++) {
            sparse[0][i] = nums[i]; 
        }

        // for length 2 - 20 
        for(int base = 1; base <= 20; base++) {
            for(int i = 0; i < n; i++) {

                int pow2 = 1 << (base - 1); 
                if(i + pow2 < n) {
                    sparse[base][i] = Math.max(sparse[base - 1][i], sparse[base - 1][i + pow2]); 
                } else sparse[base][i] = sparse[base - 1][i]; 
            }
        }
    }

    int query(int l, int r) {
        if(l > r) return 0; 
        // return the max in range r to l 
        int base = 0; 
        for(; base <= 20; base++) {
            if((1 << base) > r - l + 1 ) {
                break; 
            }
        }
        base--; 
        if(base < 0) return 0;  
        return Math.max(sparse[base][l], sparse[base][r - (1 << base) + 1]); 
    }
}

class SegmentTree {
    private int n; 
    private int arr[]; 
    private int seg[]; 

    SegmentTree(int[] nums){
        int n = nums.length; 
        this.n = n; 
        seg = new int[4 * n]; 
        this.arr = nums; 
        build(1, 0, n - 1); 
    }

    private void build(int node, int l, int r) {
        if(l == r) {
            seg[node] = arr[l]; 
            return; 
        }

        int mid = (l + r) >> 1; 
        build(2 * node, l , mid); 
        build(2 * node + 1, mid + 1, r); 
        seg[node] = Math.max(seg[2 * node], seg[2 * node + 1]); 
    }

    int internalQuery(int node, int st, int en, int l, int r) {
        if(l <= st && en <= r) {
            // we found the current node 
            return seg[node]; 
        }
        int mid = (st + en) >> 1; 
        int res = 0; 
        if(mid >= l) {
            res = Math.max(res, internalQuery(node * 2, st, mid, l, r)); 
        }

        if(r > mid) {
            res = Math.max(res, internalQuery(node * 2 + 1, mid + 1, en, l, r)); 
        }
        return res; 
    }

    int query(int l, int r) {
        if(l > r) return 0; 
        return internalQuery(1, 0, n - 1, l, r); 
    }
}

class Solution {
    int seg = 0; 
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] q) {
        int n = s.length(); 
        int cnt1 = 0; 
        for(char c: s.toCharArray()) {
            if(c == '1') cnt1++; 
        }

        List<Integer> zeroBlocks = new ArrayList<>(); 
        List<Integer> zeroLeft = new ArrayList<>(); 
        List<Integer> zeroRight = new ArrayList<>(); 

        int idx = 0; 
        while(idx < n) {
            int r = idx; 
            while(r < n && s.charAt(idx) == s.charAt(r)) {
                r++; 
            }
            int curBlockLen = r - idx; 
            if(s.charAt(idx) == '0') {
                // zero block 
                zeroBlocks.add(curBlockLen); 
                zeroLeft.add(idx);
                zeroRight.add(r - 1); 
            }
            idx = r; 
        }

        // Now zeroLeft, zeroRight - both are sorted 
        int m = zeroBlocks.size(); 
        seg = m; 
        List<Integer> ans = new ArrayList<>(); 
        // base case 
        if(m <= 1) {
            for(int i = 0; i < q.length; i++) ans.add(cnt1); 
            return ans; 
        }
        int nums[] = new int[m - 1]; 
        // prepar the nums 
        for( int bl = 0; bl < m - 1; bl++) {
            nums[bl] = zeroBlocks.get(bl) + zeroBlocks.get(bl + 1); 
        }
        // SparseTable sp = new SparseTable(nums); 
        SegmentTree sp = new SegmentTree(nums); 

        
        for(int i = 0; i < q.length; i++) {
            int l = q[i][0], r= q[i][1]; 

            // More than two segments. Now we have to apply the operation in [l...r] 
            // We have three cases 
            int l_idx = lowerBound(zeroRight, l); 
            int r_idx = upperBound(zeroLeft, r) - 1; 

            if(l_idx > m - 1 || r_idx < 0 || l_idx >= r_idx) {
                // left index can not be last, 
                // right index can not be first 
                // both cannot be same or l_idx > r_idx 
                ans.add(cnt1); 
                continue; 
            } 

            // leftMostBlock that falls or overlaps with l 
            // it means for this zero block zeroLeft[i] < l & zeroRight[i] > l 
            // for this case contribution = r - max(zeroLeft[i], l) + zeroBlock[i + 1] 
            int leftLen = zeroRight.get(l_idx) - Math.max(zeroLeft.get(l_idx), l) + 1; 

            // rightMostBlock that falls or verlaps with r means zerLeft[j] < r & zeroRight[j] > r
            // here contri = min(r, zeroRight[j])  - zeroLeft[j] + zeroBlock[j - 1]
            int rightLen = Math.min(r, zeroRight.get(r_idx)) - zeroLeft.get(r_idx) + 1; 

            // If there are only two 0 blocks within the substring 
            if ( l_idx + 1 == r_idx) {
                int contribution = leftLen + rightLen; 
                ans.add(cnt1 + contribution); 
                continue; 
            }

            // If more than two blocks 
            // left contribution 
            int leftContri = leftLen + zeroBlocks.get(l_idx + 1); 
            int rightContri = rightLen + zeroBlocks.get(r_idx - 1); 

            // Now for all middle one's we have to find the max from the range 
            // i.e, from (i + 1 ... j - 2 )
            // This how to find efficiently ?? We can use Segment Tree / or sparse tables 
            int middleContri = sp.query(l_idx + 1, r_idx - 2); // why r_idx - 2?? If r_idx -1, then it will be count r_idx again ( last pair again).
            ans.add(cnt1 + Math.max(leftContri, Math.max(rightContri, middleContri)));  
        }
        return ans; 
    }

    private int lowerBound(List<Integer> zeroRight, int l) {
        int left = 0; 
        int right = seg; 
        while(left < right) {
            int mid = (left + right) >> 1; 
            if(zeroRight.get(mid) >= l) {
                right = mid; 
            } else left = mid + 1; 
        }
        return left; 
    }

    private int upperBound(List<Integer> zeroLeft, int r) {
        int left = 0, right = seg; 
        while(left < right) {
            int mid = (left + right) >> 1; 
            if(zeroLeft.get(mid) <= r) {
                left = mid + 1; 
            } else right = mid; 
        }
        return left; 
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximize-active-section-with-trade-ii/)