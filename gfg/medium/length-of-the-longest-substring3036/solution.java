class Solution {
    int longestUniqueSubstring(String s) {
        // code here
        int n = s.length();
        int left = 0;
        int len = 0 ;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0 ; right < n ; right++){
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len = Math.max(len , right - left + 1);
        }
        return len;
        
    }
}